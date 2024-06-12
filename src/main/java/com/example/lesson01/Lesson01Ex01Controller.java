package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/lesson01/ex01") // 클래스에 위치한 매핑이 먼저 읽힘
@Controller // Spring bean 등록
public class Lesson01Ex01Controller {
	
	// http://localhost:8080/lesson01/ex01/1
	@ResponseBody // return 되는 값이 ResponseBody에 넣어진다. => HTML 응답
	@RequestMapping("1")
	public String ex01_1() {
		return "<h1>문자열을 Response Body에 보내는 예제</h1>";
	}
	
	// http://localhost:8080/lesson01/ex01/2
	// Map return => JSON 변환
	@RequestMapping("2")
	public @ResponseBody Map<String, Object> ex01_2() {
		Map<String, Object> map = new HashMap<>();
		map.put("라즈베리", 22);
		map.put("앵두", 31);
		map.put("체리", 105);
		map.put("딸기", 82);
		
		// map을 return하면 JSON이 된다.
		// spring web starter에 jackson 라이브러리가 포함되어 있기 때문
		return map;
	}
}
