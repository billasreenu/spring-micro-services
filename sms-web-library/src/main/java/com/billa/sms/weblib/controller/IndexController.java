package com.billa.sms.weblib.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.billa.sms.weblib.vo.SmsResponseVO;

@RestController
public class IndexController {

	@GetMapping("/")
	public ResponseEntity<SmsResponseVO> index() {

		SmsResponseVO vo = SmsResponseVO.builder().build();
		vo.setCode("00");
		vo.setMessage("SUCCESS");
		vo.setData("hello from index controller");

		return new ResponseEntity<>(vo, HttpStatus.OK);
	}

}
