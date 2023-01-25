package com.example.pion.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class RestTestController {
	
	@GetMapping("/getString")
	public String getString() {
		return "index";
	}
	
	@GetMapping("/getJson")
	public RestJson getJson() {
		RestJson result = new RestJson("상품 A",3000);
		return result;
	}
}
