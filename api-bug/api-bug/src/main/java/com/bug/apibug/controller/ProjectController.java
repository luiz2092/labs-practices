package com.bug.apibug.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/project")
public class ProjectController {

	@PostMapping
	public ResponseEntity<Void> createBug() {
		log.info("Create Bug");
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
