package xianzhan.id.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @author xianzhan
 * @since 2020-07-16
 */
public class JsonUtils {

    private static volatile ObjectMapper objectMapper;

    public static String toJson(Object obj) {
        String json;
        try {
            json = getObjectMapper().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return json;
    }

    public static <T> T toObj(String json, Class<T> type) {
        T obj;
        try {
            obj = getObjectMapper().readValue(json, type);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return obj;
    }

    private static ObjectMapper getObjectMapper() {
        ObjectMapper mapper = objectMapper;
        if (mapper == null) {
            synchronized (JsonUtils.class) {
                if (objectMapper == null) {
                    objectMapper = new ObjectMapper();
                }
                mapper = objectMapper;
            }
        }
        return mapper;
    }
}
