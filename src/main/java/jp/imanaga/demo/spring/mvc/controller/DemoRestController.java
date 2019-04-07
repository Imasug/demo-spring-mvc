package jp.imanaga.demo.spring.mvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jp.imanaga.demo.spring.mvc.data.DemoBean;

@RestController
public class DemoRestController {

	@GetMapping("/get")
	public ResponseEntity<?> get() {
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("/post")
	public ResponseEntity<?> post(@Validated @RequestBody DemoBean demoBean) {
		System.out.println(demoBean.getName());
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
