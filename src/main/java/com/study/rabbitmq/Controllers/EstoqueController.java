package com.study.rabbitmq.Controllers;

import com.study.rabbitmq.DTO.EstoqueDTO;
import com.study.rabbitmq.Services.RabbitMQServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    @Autowired
    private RabbitMQServices service;

    @Value("${spring.rabbitmq.queues.queue-estoque.estoque}")
    private String FILA_ESTOQUE;


    @PutMapping
    private ResponseEntity alterarEstoque(@RequestBody EstoqueDTO estoqueDTO){
        service.enviarMensagem(estoqueDTO, FILA_ESTOQUE);
        return ResponseEntity.ok().build();
    }
}
