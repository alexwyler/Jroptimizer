package util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class JacksonUtil {
    public static final FilterProvider OBJECT_FILTERS = new SimpleFilterProvider()
            .addFilter("noooop", SimpleBeanPropertyFilter.filterOutAllExcept("stringValue"));
    // Singleton is thread-safe and ideal. See: http://stackoverflow.com/a/3909846
    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
            .registerModule(new JodaModule())
            .configure(DeserializationFeature.USE_LONG_FOR_INTS, true)
            .configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true)
            .configure(DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS, true)
            .configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true)
            .configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE, true)
            .configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true)
            .configure(JsonParser.Feature.ALLOW_COMMENTS, true)
            .configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true)
            .configure(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS, true)
            .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
            .configure(MapperFeature.USE_STATIC_TYPING, false)
            .setFilterProvider(OBJECT_FILTERS);

    public static final ObjectMapper NONEMPTY_OBJECT_MAPPER = OBJECT_MAPPER.copy()
            .setSerializationInclusion(JsonInclude.Include.NON_EMPTY);

    public static final ObjectMapper NONDEFAULT_OBJECT_MAPPER = OBJECT_MAPPER.copy()
            .setSerializationInclusion(JsonInclude.Include.NON_DEFAULT);

    public static final XmlMapper XML_MAPPER = (XmlMapper) new XmlMapper()
            .registerModule(new JodaModule())
            .configure(DeserializationFeature.USE_LONG_FOR_INTS, true);

    /**
     * Converts a JSON InputStream into an instances of the given Class.
     */
    public static <T> T read(InputStream jsonStream, Class<T> clazz) {
        if (jsonStream == null) {
            return null;
        }
        try {
            return OBJECT_MAPPER.readValue(jsonStream, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Converts a JSON String into an instances of the given Class.
     */
    public static <T> T read(String json, Class<T> clazz) {
        if (json == null) {
            return null;
        }
        try {
            return OBJECT_MAPPER.readValue(json, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Converts a JSON String into an instances of the given Class.
     */
    public static <T> T read(String json, JavaType type) {
        if (json == null) {
            return null;
        }
        try {
            return OBJECT_MAPPER.readValue(json, type);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Converts an XML String into an instances of the given Class.
     */
    public static <T> T readXml(String xml, Class<T> clazz) {
        if (xml == null) {
            return null;
        }
        try {
            return XML_MAPPER.readValue(xml, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Writes the given Object into a JSON String.
     */
    public static String write(Object o) {
        try {
            return OBJECT_MAPPER.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Writes the given Object into a JSON String.
     */
    public static String writeNonEmpty(Object o) {
        try {
            return NONEMPTY_OBJECT_MAPPER.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Writes the given Object into a JSON String.
     */
    public static String writeNonDefault(Object o) {
        try {
            return NONDEFAULT_OBJECT_MAPPER.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Writes the given Object into a pretty-printed JSON String.
     */
    public static String writePretty(Object o) {
        try {
            return OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String writeXml(Object o) {
        try {
            return XML_MAPPER.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String writeXmlPretty(Object o) {
        try {
            return XML_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Converts a JSON String into a List containing instances of the given Class.
     */
    public static <T> List<T> readList(String json, Class<T> type) {
        CollectionType listType = OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, type);
        try {
            return OBJECT_MAPPER.readValue(json, listType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Converts a JSON String into an arbitrary TypeReference. Only use this when complicated generics data is needed.
     * For example List<List<MySObject>>.
     */
    public static <T> T read(String json, TypeReference<T> typeReference) {
        if (json == null) {
            return null;
        }
        try {
            return OBJECT_MAPPER.readValue(json, typeReference);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T readFromGenericMap(Map<String, Object> map, Class<T> clazz) {
        return read(write(map), clazz);
    }

    // TEMPORARY METHODS

    /**
     * Converts a json String into a generic Map of String to Object.  This this method is a stub to help ease in
     * migrating to Jackson.  All new code should use read(string, clazz) and should deal in POJOs.
     */
    @Deprecated
    public static Map<String, Object> readGenericMap(String json) {
        return read(json, new TypeReference<Map<String, Object>>() {
        });
    }

    /**
     * Converts a json String into a generic List of Map of String to Object.  This this method is a stub to help ease in
     * migrating to Jackson.  All new code should use read(string, clazz) and should deal in POJOs.
     */
    @Deprecated
    public static List<Map<String, Object>> readGenericListOfMap(String json) {
        return read(json, new TypeReference<List<Map<String, Object>>>() {
        });
    }

    public static void syso(Object object) {
        System.out.println(writePretty(object));
    }
}
