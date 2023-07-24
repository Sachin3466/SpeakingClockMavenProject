package com.example.SpeakingClockMavenProject;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.service.SpeakingClockService;
import com.demo.service.ValueConverters;

@SpringBootTest
class SpeakingClockMavenProjectApplicationTests {


	@Autowired
	private SpeakingClockService speakingClockService;

	@Test
	void testSpecificTime() {
		String str  = speakingClockService.getCurrentTimeInWords("05:30");
		Assertions.assertEquals("It's five thirty", str);
	}

	@Test
	void testMidnightTime() {
		String str  = speakingClockService.getCurrentTimeInWords("00:00");
		Assertions.assertEquals("It's Midnight", str);
	}

	@Test
	void testMiddayTime() {
		String str  = speakingClockService.getCurrentTimeInWords("12:00");
		Assertions.assertEquals("It's Midday", str);
	}

	@Test
	void testCurrentTime() {
		String str = speakingClockService.getCurrentTimeInWords("");
		if(!str.contains("It's")){
			Assertions.fail();
		} else {
			String substring = str.substring(str.indexOf("It's ") + 5);
			LocalTime localTime = LocalTime.now();
			int hour = localTime.getHour();
			int min = localTime.getMinute();
			if(substring.equals("Midday")) {
				Assertions.assertEquals(hour, 12);
				Assertions.assertEquals(min, 0);
			} else if(substring.equals("Midday")) {
				Assertions.assertEquals(hour, 0);
				Assertions.assertEquals(min, 0);
			} else {
				String []timeArr = substring.split(" ");
				Assertions.assertEquals(ValueConverters.asWords(hour), timeArr[0]);
				Assertions.assertEquals(ValueConverters.asWords(min), timeArr[1]);
			}
		}
	}

}
