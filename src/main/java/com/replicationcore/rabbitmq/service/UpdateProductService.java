package com.replicationcore.rabbitmq.service;

import com.replicationcore.rabbitmq.dto.ReqUpdateProductDTO;

import java.util.Map;

public interface UpdateProductService {
    Map<String, String> updateProduct(ReqUpdateProductDTO reqUpdateProductDTO);
}
