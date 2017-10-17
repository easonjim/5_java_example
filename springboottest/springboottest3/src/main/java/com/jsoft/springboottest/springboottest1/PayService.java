package com.jsoft.springboottest.springboottest1;

import java.time.LocalTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.remoting.RemoteAccessException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;

@Service
public class PayService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private final int totalNum = 100000;

    @Retryable(value = { Exception.class },maxAttempts = 3,backoff = @Backoff(delay = 2000,multiplier = 1.5))
    public int minGoodsnum(int num) throws Exception{
        logger.info("minGoodsnum开始"+ LocalTime.now());
        if(num <= 0){
            throw new Exception("数量不对");
        }
        logger.info("minGoodsnum执行结束");
        return totalNum - num;
    }
    
    @Recover
	public void recover(Exception e) {
		logger.info("=>>>>>"+e.getMessage());
	}
}
