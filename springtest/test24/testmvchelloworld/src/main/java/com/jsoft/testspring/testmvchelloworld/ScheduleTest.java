package com.jsoft.testspring.testmvchelloworld;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component  
public class ScheduleTest {  

    @Scheduled(cron = "0/5 * * * * ?")  
    public void schTest1() {  
        Date date = new Date();  
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        String dateStr = sim.format(date);  
        System.out.println("这是spring定时器1，每五秒执行一次,当前时间：" + dateStr);  
    }  
}  