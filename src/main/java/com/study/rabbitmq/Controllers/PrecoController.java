package com.study.rabbitmq.Controllers;

import com.study.rabbitmq.DTO.EstoqueDTO;
import com.study.rabbitmq.DTO.PrecoDTO;
import com.study.rabbitmq.Services.RabbitMQServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/preco")
public class PrecoController {

    @Autowired
    private RabbitMQServices service;

    @Value("${spring.rabbitmq.queues.queue-preco.preco}")
    private String FILA_PRECO;

    @PutMapping
    private ResponseEntity aletraPreco(@RequestBody PrecoDTO precoDTO){
        service.enviarMensagem(precoDTO, FILA_PRECO);
        return ResponseEntity.ok().build();
    }
}
