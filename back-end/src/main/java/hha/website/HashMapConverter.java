package hha.website;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Map;

@Converter(autoApply = true)
public class HashMapConverter implements AttributeConverter<Map<String, Object>, String> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Map<String, Object> data) {

        String dataJson = null;
        try {
            dataJson = objectMapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return dataJson;
    }

    @Override
    public Map<String, Object> convertToEntityAttribute(String dataJson) {

        Map<String, Object> data = null;
        try {
            data = objectMapper.readValue(dataJson, Map.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return data;
    }
}
