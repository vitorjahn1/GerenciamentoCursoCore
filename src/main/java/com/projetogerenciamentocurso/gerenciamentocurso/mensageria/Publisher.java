package com.projetogerenciamentocurso.gerenciamentocurso.mensageria;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
@Component
@AllArgsConstructor
public class Publisher {

	private final RabbitTemplate rabbitTemplate;
	
	
	public void send(String exchange,String routeKey, Object dto) {
		
		rabbitTemplate.convertAndSend(exchange, routeKey, dto);
	}
}
