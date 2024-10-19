package com.replicationcore.rabbitmq.controller;

import com.replicationcore.rabbitmq.dto.ReqUpdateProductDTO;
import com.replicationcore.rabbitmq.service.UpdateProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1.0/replication-core/")
public class RabbitMqController {

    @Autowired
    private UpdateProductService updateProductService;

    @PostMapping("product")
    public Map<String, String> listenMsgUpdateProduct(@RequestBody ReqUpdateProductDTO reqUpdateProductDTO) {
        return updateProductService.updateProduct(reqUpdateProductDTO);
    }

}
