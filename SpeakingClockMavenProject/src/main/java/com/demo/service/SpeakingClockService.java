package com.demo.service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class SpeakingClockService {
	
	public String getCurrentTimeInWords(String time){

    StringBuilder timeInWords = new StringBuilder();

    int hour = 0;
    int min = 0;
    if(StringUtils.hasLength(time)){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime localTime = LocalTime.from(formatter.parse(time));
        hour = localTime.getHour();
        min = localTime.getMinute();
    } else {
        LocalTime localTime = LocalTime.now();
        hour = localTime.getHour();
        min = localTime.getMinute();
    }
    timeInWords = timeInWords.append("It's ");
    if(hour == 12 && min == 0){
        timeInWords = timeInWords.append("Midday");
    } else if(hour == 0 && min == 0){
        timeInWords = timeInWords.append("Midnight");
    } else {
    	timeInWords = timeInWords.append(ValueConverters.asWords(hour))
                .append(" ").append(ValueConverters.asWords(min)); 
    }

    return timeInWords.toString();
}

	

	
   /* public String convertToWords(String timeStr) {
        try {
            String[] timeParts = timeStr.split(":");
            
            if (timeParts.length != 2) {
                throw new IllegalArgumentException("Invalid time format");
            }
    
            int hours = Integer.parseInt(timeParts[0]);
            int minutes = Integer.parseInt(timeParts[1]);
    
            if ((hours < 0 || hours > 23 || minutes < 0 || minutes > 59) && !(hours == 24 && minutes == 0)) {
                throw new IllegalArgumentException("Invalid time format");
            }            
    
            String wordTime=convertTimeToWord(hours,minutes);
            String result = "It's " + wordTime;
            return result;
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid time format");
        }
    }
    
   
    private String convertTimeToWord( int hours, int minutes) {
        if (hours==12 && minutes==0) {
            return "Midday";
        }
        else if ((hours==0 && minutes==0) || (hours==24 && minutes==0)){
            return "Midnight";
        }
        else {           
            return getHourWord(hours) + " " + getMinuteString(minutes % 60);

        }
    }
    
    private String getHourWord(int hours) {
        String[] hourWords = {
                "twelve", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                "eleven","twelve"
        };
        return hourWords[hours % 12];
    }
    
    private String getMinuteString(int minutes) {
        String[] minuteWords = {
            "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
            "eighteen", "nineteen", "twenty", "twenty-one", "twenty-two", "twenty-three",
            "twenty-four", "twenty-five", "twenty-six", "twenty-seven", "twenty-eight",
            "twenty-nine", "thirty", "thirty-one", "thirty-two", "thirty-three", "thirty-four",
            "thirty-five", "thirty-six", "thirty-seven", "thirty-eight", "thirty-nine", "forty",
            "forty-one", "forty-two", "forty-three", "forty-four", "forty-five", "forty-six",
            "forty-seven", "forty-eight", "forty-nine", "fifty", "fifty-one", "fifty-two",
            "fifty-three", "fifty-four", "fifty-five", "fifty-six", "fifty-seven", "fifty-eight",
            "fifty-nine"
        };
        return minuteWords[minutes];
    }
*/
}
