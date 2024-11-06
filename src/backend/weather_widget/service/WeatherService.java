package com.ict.project.weather.service;

public interface WeatherService {
	
	// 중기전망 조회
	public String getWeatherData(String stnId, String tmFc);
	
	// 초단기예보
	public String getWeatherData2(String baseDate, String baseTime, String nx, String ny);
	
	// 초단기예보
	public String getRegionName(String nx, String ny);
}

