package com.replicationcore.rabbitmq.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ReqUpdateProductDTO {
    private String productCode;
    private String productName;
    private String productDescription;
    private BigDecimal productPrice;
    private Integer productQuantity;
}
