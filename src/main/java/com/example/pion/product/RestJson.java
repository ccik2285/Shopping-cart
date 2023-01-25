package com.example.pion.product;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor // 게터 세터 다 해줌!
@NoArgsConstructor(access = AccessLevel.PRIVATE)     //기본생성자 없어도 오류 안뜨는것!
public class RestJson {
	private String name;
	private int price;
	
	
	
}
