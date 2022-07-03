package com.study.rabbitmq.Services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQServices {

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void enviarMensagem(Object mensagem, String nomeFila) {
        rabbitTemplate.convertAndSend(nomeFila, mensagem);
    }
}
