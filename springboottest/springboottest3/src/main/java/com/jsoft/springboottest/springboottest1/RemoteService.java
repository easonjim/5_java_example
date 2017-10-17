package com.jsoft.springboottest.springboottest1;

import java.time.LocalTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.remoting.RemoteAccessException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class RemoteService {
	
	private final static Logger logger = LoggerFactory.getLogger(RemoteService.class);
	
	@Retryable(value = { RemoteAccessException.class }, maxAttempts = 3, backoff = @Backoff(delay = 5000l, multiplier = 1))
	public void call() throws Exception {
		logger.info(LocalTime.now()+" do something...");
		throw new RemoteAccessException("RPC调用异常");
	}

	@Recover
	public void recover(RemoteAccessException e) {
		logger.info(e.getMessage());
	}
}