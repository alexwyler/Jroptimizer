package util;

import com.google.common.collect.ForwardingMap;
import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.Serializer;

import java.util.Map;

/**
 * Created by alexwyler on 2/14/19.
 */
public class MapDB {

    public static DB dbInstance;

    static {
        dbInstance = DBMaker.fileDB("data/data.db").make();
    }

    public static Map<String, String> getDataMap() {
        return new CommittingMap<>(dbInstance.hashMap("data", Serializer.STRING, Serializer.STRING).createOrOpen());
    }

    /**
     * A forwarding map that commits changes to the DB instance
     */
    private static class CommittingMap<X, Y> extends ForwardingMap<X, Y> {

        Map<X, Y> delegate;

        public CommittingMap(Map<X, Y> delegate) {
            this.delegate = delegate;
        }

        @Override
        protected Map<X, Y> delegate() {
            return delegate;
        }

        @Override
        public Y remove(Object object) {
            Y _object = super.remove(object);
            dbInstance.commit();
            return _object;
        }

        @Override
        public void clear() {
            super.clear();
            dbInstance.commit();
        }

        @Override
        public Y put(X key, Y value) {
            Y _object = super.put(key, value);
            dbInstance.commit();
            return _object;
        }

        @Override
        public void putAll(Map<? extends X, ? extends Y> map) {
            super.putAll(map);
            dbInstance.commit();
        }
    }
}
