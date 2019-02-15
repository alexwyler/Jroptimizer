package util;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Supplier;

public class CachedValue<T> {
    private final Supplier<T> getter;
    private final long ttlMillis;
    private long lastCheckMillis;
    private T lastValue;
    private AtomicBoolean operating;
    private boolean hasFirstValue;

    public CachedValue(long ttlMillis, Supplier<T> getter) {
        this.getter = getter;
        this.ttlMillis = ttlMillis;
        this.lastValue = null;
        this.lastCheckMillis = 0;
        this.operating = new AtomicBoolean(false);
        this.hasFirstValue = false;
    }

    public T get() {
        long now = System.currentTimeMillis();

        // In case we are stale..
        if (lastCheckMillis + ttlMillis < now) {
            if (!hasFirstValue) {
                // Populate the value for the first time
                // This is blocking as we don't have a stale value to fall back on
                return loadFirstTime(now);
            } else if (operating.compareAndSet(false, true)) {
                // We are stale, and took responsibility for replacing the value
                // other threads won't be blocked but this thread will.
                return reload(now);
            }
        }

        // If we are not stale OR we are stale but are not responsible for refreshing its value
        return lastValue;
    }

    private T loadFirstTime(long now) {
        synchronized (this) {
            if (!hasFirstValue) {
                lastValue = getter.get();
                lastCheckMillis = now;
                hasFirstValue = true;
            }

            return lastValue;
        }
    }

    private T reload(long now) {
        try {
            lastValue = getter.get();
            lastCheckMillis = now;
            return lastValue;
        } finally {
            operating.set(false);
        }
    }
}
