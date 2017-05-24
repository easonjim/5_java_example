package com.jsoft.testspring.testcustomevent;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class CustomEventPublisher implements ApplicationEventPublisherAware {

	private ApplicationEventPublisher publisher;
	
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		// TODO Auto-generated method stub
		this.publisher = applicationEventPublisher;
	}
	
	public void publish(){
		CustomEvent ce = new CustomEvent(this);
		publisher.publishEvent(ce);
	}

}
