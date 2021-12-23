package org.selenium.pom.utilis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.selenium.pom.Objects.LoginInfo;

import java.io.IOException;
import java.io.InputStream;

public class JacksonUtilis
{
    public static <T> T deserializeJson(String fileName, Class<T> T) throws IOException {
        InputStream is = JacksonUtilis.class.getClassLoader().getResourceAsStream(fileName);
        ObjectMapper objectMapper=new ObjectMapper();
        return objectMapper.readValue(is,T);
    }
}
