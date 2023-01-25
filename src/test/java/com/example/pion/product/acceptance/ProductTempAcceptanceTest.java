package com.example.pion.product.acceptance;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import com.example.pion.AcceptanceTest;

import io.restassured.RestAssured;
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
		.contentType(ContentType.JSON)
		.body(body)
		.post("/main")
		.then()
		.log().all().extract();
		
		assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
	}

}
