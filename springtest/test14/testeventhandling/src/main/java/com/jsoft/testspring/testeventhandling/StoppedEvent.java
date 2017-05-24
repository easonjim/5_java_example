package com.jsoft.testspring.testeventhandling;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStoppedEvent;

public class StoppedEvent implements ApplicationListener<ContextStoppedEvent> {

	@Override
	public void onApplicationEvent(ContextStoppedEvent event) {
		// TODO Auto-generated method stub
		System.out.println("StoppedEvent");
	}

}
