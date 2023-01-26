package com.example.pion.product.acceptance;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import com.example.pion.AcceptanceTest;
import com.example.pion.product.dto.ProductResponse;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

@DisplayName("상품 관련 기능")
public class ProductTempAcceptanceTest extends AcceptanceTest {
	

	@DisplayName("상품을 저장하는 시나리오")
	@Test
	void saveProduct() {
		Map<String,String> body = new HashMap<>();
		body.put("name","밍그라진곰");
		body.put("price",String.valueOf(1000));
		
		ExtractableResponse<Response> response = RestAssured.given().log().all()
		.contentType(ContentType.URLENC)
		.config(RestAssuredConfig.newConfig().encoderConfig(EncoderConfig.encoderConfig().defaultContentCharset("UTF-8")))
		.formParams(body)
		.post("/main")
		.then()
		.log().all().extract();
		
		assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
	}
	
	@DisplayName("전체 상품을 조회한다")
	@Test
	void findAllProduct() {
		
		상품을_등록함("망그라진곰",2000);
		상품을_등록함("루피",5000);
		
		ExtractableResponse<Response> response = RestAssured.given().log().all()
				.get("/main/find/all")
				.then()
				.log().all().extract();
		
		List<ProductResponse> list = response.jsonPath().getList(".",ProductResponse.class);
		
		assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
		assertThat(list.size()).isEqualTo(2);
		
	}
	
	private ExtractableResponse<Response> 상품을_등록함(String name,int price){
	
		Map<String,String> body = new HashMap<>();
		body.put("name",name);
		body.put("price",String.valueOf(price));
	
		return RestAssured.given().log().all()
				.contentType(ContentType.URLENC)
				.config(RestAssuredConfig.newConfig().encoderConfig(EncoderConfig.encoderConfig().defaultContentCharset("UTF-8")))
				.formParams(body)
				.post("/main")
				.then()
				.log().all().extract();
		
	}
	
	@DisplayName("상품 정보를 조회한다")
	@Test
	void findProductById() {
		상품을_등록함("망그라진곰",2000);
		상품을_등록함("루피",5000);
		
		ExtractableResponse<Response> response = RestAssured.given().log().all()
				.get("/main/find/all")
				.then()
				.log().all().extract();
		
		List<ProductResponse> list = response.jsonPath().getList(".",ProductResponse.class);
		
		ProductResponse productA = list.get(0);
		
		response = RestAssured.given().log().all()
		.get("/main/detail/{id}",productA.getId())
		.then()
		.log().all().extract();
		
		 ProductResponse result = response.jsonPath().getObject(".",ProductResponse.class);
		
		assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
		assertThat(result.getId()).isEqualTo(productA.getName());
		
	}
	
	
	
}
