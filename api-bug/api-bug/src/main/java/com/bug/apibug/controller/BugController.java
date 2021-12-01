package com.bug.apibug.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bug.apibug.model.BugModel;
import com.bug.apibug.service.BugService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin
@RestController
@RequestMapping("/bug")
@Slf4j
public class BugController {

	@Autowired
	private BugService bugService;

	@PostMapping
	public ResponseEntity<Void> createBug(@RequestBody @Valid BugModel bug) throws JsonProcessingException {
		log.info(new ObjectMapper().writeValueAsString(bug));
		bugService.createBug(bug);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping("/{idBug}")
	public ResponseEntity<BugModel> getBug(@PathVariable int idBug) {
		log.info("---------> " + idBug);
		return new ResponseEntity<>(bugService.retrieveBug(idBug), HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<BugModel>> getAllBug() {
		return new ResponseEntity<>(bugService.retrieveAllBugs(), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Void> updateBug(@RequestBody BugModel bug) throws JsonProcessingException {
		log.info(new ObjectMapper().writeValueAsString(bug));
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
