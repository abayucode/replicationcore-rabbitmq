package com.replicationcore.rabbitmq.service;

import com.rabbitmq.tools.json.JSONUtil;
import com.replicationcore.rabbitmq.dto.ReqUpdateProductDTO;
import com.replicationcore.rabbitmq.utils.JSONUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class UpdateProductServiceImpl implements UpdateProductService {

    private static final Logger log = LoggerFactory.getLogger(UpdateProductServiceImpl.class);
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Value("${replication-rabbit.queue}")
    public String queue;

    @Value("${replication-rabbit.exchange}")
    public String exchange;

    @Value("${replication-rabbit.routing-key}")
    public String routingKey;

    @Override
    public Map<String, String> updateProduct(ReqUpdateProductDTO reqUpdateProductDTO) {
        Map<String, String> result = new HashMap<String, String>();

        rabbitTemplate.convertAndSend(exchange, routingKey, Objects.requireNonNull(JSONUtils.objectToJson(reqUpdateProductDTO)));
        result.put("message", "success");
        result.put("code", "201");

        log.info("Rabbitmq update product message successfully sender {}", JSONUtils.objectToJson(reqUpdateProductDTO));
        return result;
    }
}
