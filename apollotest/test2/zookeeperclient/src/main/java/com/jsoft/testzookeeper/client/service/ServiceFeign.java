package com.jsoft.testzookeeper.client.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsoft.testzookeeper.client.service.fallback.FeignFallback;

@FeignClient(value = "service-zookeeper", fallback = FeignFallback.class)
public interface ServiceFeign {

	@RequestMapping(value = "/hello")
	String sayHello(@RequestParam(name = "name") String name);
}
