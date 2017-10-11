package com.jsoft.testzookeeper.client.service.fallback;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsoft.testzookeeper.client.service.ServiceFeign;

@Component
public class FeignFallback implements ServiceFeign {

	@Override
	public String sayHello(@RequestParam(name = "name") String name) {
		return null;
	}
}
