package com.ict.project.weather.controller;
 
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ict.project.weather.service.WeatherService;

@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;
	
    @RequestMapping(value = "/weather", produces="application/json; charset=utf-8")
	@ResponseBody
	public String getWeather(HttpServletRequest request) {
		String stnId 		= request.getParameter("stnId");
		String ntmFc 		= request.getParameter("tmFc");
				
    	System.out.println("WeatherController **********************************");	
		
		return weatherService.getWeatherData(stnId, ntmFc);

	}
    
    @RequestMapping(value = "/weather2", produces="application/json; charset=utf-8")
	@ResponseBody
	public String getWeather2(HttpServletRequest request) {
		String baseDate = request.getParameter("baseDate");
		String baseTime = request.getParameter("baseTime");
		String nx 		= request.getParameter("nx");
		String ny 		= request.getParameter("ny");
		
    	System.out.println("WeatherController **********************************");	
		
		return weatherService.getWeatherData2(baseDate, baseTime, nx, ny);

	}
    
}

