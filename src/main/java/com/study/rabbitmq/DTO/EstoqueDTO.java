package com.study.rabbitmq.DTO;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class EstoqueDTO implements Serializable {
    public String cdProduto;
    public Long qtdProduto;

}
