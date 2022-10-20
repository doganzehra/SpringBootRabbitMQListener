package com.bilgeadam.SpringBootRabbitMQListener;

import java.util.Random;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
// pom 'da jackson eklemeyi unutma
public class RabbitListenerClass
{
	@Bean
	public Jackson2JsonMessageConverter asdasd()
	{
		return new Jackson2JsonMessageConverter();
	}

	// sdece string yakalamak istersek yukarıdaki message converter tanımlanmamalı
//	@RabbitListener(queues = "myDirectQueue")
//	public void getQueuedMessage(String mesaj)
//	{
//		System.err.println("listener1 " + mesaj);
//	}

	@RabbitListener(queues = "myDirectQueue")
	public void getQueuedMessage2(Person person)
	{
		if (new Random().nextBoolean())
		{
			int k = 7 / 0;
		}
		System.err.println("listener2 " + person.getIsim() + " - " + person.getId());
	}
}

class Person
{
	private int id;

	private String isim;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getIsim()
	{
		return isim;
	}

	public void setIsim(String isim)
	{
		this.isim = isim;
	}

	public Person()
	{
	}

	public Person(int id, String isim)
	{
		this.id = id;
		this.isim = isim;
	}
}