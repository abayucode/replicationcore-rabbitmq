package com.replicationcore.rabbitmq.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JSONUtils {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static String objectToJson(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (Exception e) {
            log.info("Error parse object to json ", e);
            return null;
        }
    }

}
