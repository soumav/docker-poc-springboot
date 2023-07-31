package com.test.sbd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.sbd.model.Book;
import com.test.sbd.service.BookService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class BookController {

	@Autowired
	HttpServletRequest request;
	
	@Autowired
	BookService service;
	
	@GetMapping("/hello")
	public ResponseEntity<Map<String,Object>> hello(){
		HttpHeaders headers=new HttpHeaders();
		Map<String,Object> response = new HashMap<>();
		
		response.put("Your IP",request.getRemoteAddr());
		response.put("message","All good here!");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(response);
	}
	
	@PostMapping("/books")
	public ResponseEntity<List<Book>> insertBooks(@RequestBody List<Book> books){
		HttpHeaders headers=new HttpHeaders();
		
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(service.insertBooks(books));
	}
	@GetMapping("/books")
	public ResponseEntity<List<Book>> displayBooks(){
		HttpHeaders headers=new HttpHeaders();
		
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(service.getBooks());
	}
}
