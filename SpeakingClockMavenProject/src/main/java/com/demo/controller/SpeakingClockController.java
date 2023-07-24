package com.demo.controller;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.service.SpeakingClockService;

@RestController
@RequestMapping("/speakingclock")
public class SpeakingClockController {
	@Autowired
	private SpeakingClockService speakingClockService;

	@GetMapping("/currentTimeWords")
	public String getCurentTimeInWords() {
		return speakingClockService.getCurrentTimeInWords("");
	}

	@GetMapping("/words/time/{time}")
	public String getTimeInWords(@PathVariable("time") String time) {
		return speakingClockService.getCurrentTimeInWords(time);
	}

}
