$(document).ready(function() {
    
    initialize();
    
});

function initialize(){    
    
    getLocation(function (long, lat) {
	  console.log("위도 : " + long);
	  console.log("경도 : " + lat);
/*
      지역별 nx, ny를 구한 후 해당지역 날씨 구하기
      1. 위도 경도를 서버에 보내서 tbl_region.longitude = long,   tbl_region.latitude = lat 해서 
         dis_lv_01, dis_lv_02, dis_lv_03, nx, ny 를 구한다.
      2. dis_lv_03이 있으면 없으면 $("#location").text(dis_lv_03);에 넣는다
         dis_lv_03이 없고 dis_lv_02가 있으면  $("#location").text(dis_lv_02);에 넣는다
         dis_lv_02이 없고 dis_lv_01가 있으면  $("#location").text(dis_lv_01);에 넣는다
      3. fetchWeather(nx, ny);를 호출 한다.   
*/
      
      getNxNy(long, lat); //지역명 및 nx ny 구하기
         
      var nx = 59;  // 신수동
      var ny = 126;
      
      fetchWeather(nx, ny); //현재 지역의 날씨 구하기
         
	});
 
    
} 

// 현재 위치의 위경도를 구하고 위/도를 nx, ny로 변환 
function getLocation(callback) {
  if (navigator.geolocation) {
    navigator.geolocation.getCurrentPosition(function(position) {
		//alert("Latitude: " + position.coords.latitude + "Longitude: " + position.coords.longitude);	 
		callback(position.coords.longitude, position.coords.latitude);
	});
  } else { 
    alert("Geolocation is not supported by this browser.");
  }
}

function getNxNy(long, lat){
	
	// Ajax 요청으로 서버의 /weather API 호출
    $.ajax({
        url: `/getnxny?long=${long}&lat=${lat}`,
        method: 'GET',
        dataType: 'json',
        success: function(data) {
          // 여기서 nx ny를 받아서 처리
/*
        1. 위도 경도를 서버에 보내서 tbl_region.longitude = long,   tbl_region.latitude = lat 해서 
	       dis_lv_01, dis_lv_02, dis_lv_03, nx, ny 를 구한다.
	    2. dis_lv_03이 있으면 없으면 $("#location").text(dis_lv_03);에 넣는다
	       dis_lv_03이 없고 dis_lv_02가 있으면  $("#location").text(dis_lv_02);에 넣는다
	       dis_lv_02이 없고 dis_lv_01가 있으면  $("#location").text(dis_lv_01);에 넣는다
	    3. fetchWeather(nx, ny);를 호출 한다.  
*/      
          // 지역명도 여기서 설정
          $("#location").text("신수동");
          
        } 	    
    });
            
};
    
function fetchWeather(nx, ny) {
    // baseDate와 baseTime을 현재 시간 기준으로 설정
    const now = new Date();
    const baseDate = now.toISOString().slice(0, 10).replace(/-/g, "");
    const strMin = now.setMinutes(now.getMinutes() - 30);  // 현재 보다 30분 이전    
    const strHour = now.getHours().toString().padStart(2, '0');          
    const strTime = `${strHour}${strMin}`
    const baseTime = strTime.toString().slice(0, 4);
    
    const str2Hour = now.setHours(now.getHours() + 30).toString().padStart(2, '0');      
    const str2Time = `${str2Hour}${strMin}`
    const base2Time = str2Time.toString().slice(0, 4);
    
    // X, Y 좌표 설정 (서울 기준 예시: 55, 127)
    //const nx = "55";
    //const ny = "127";
    
    // Ajax 요청으로 서버의 /weather API 호출
    $.ajax({
        url: `/weather2?baseDate=${baseDate}&baseTime=${baseTime}&nx=${nx}&ny=${ny}`,
        method: 'GET',
        dataType: 'json',
        success: function(data) {
        	        		    
            // API 응답에서 필요한 데이터 추출 및 HTML에	 표시
            const weatherData = data.response.body.items.item;
            
            let temperature = "-";
            let condition = "-";
            let icon      = "01";
            let rtn       = null;
                           
            $.each(weatherData, function(index, item) {     
                if (baseTime < item.fcstTime && base2Time >= item.fcstTime){
                                             	
	                if (item.category === "T1H") {
	                    temperature = item.fcstValue + "°";  // 온도
	                }                    
	                if (item.category === "SKY") {                        
	                    switch (item.fcstValue) {
	                		case "1":
	                			icon = "01";
	                			condition = "맑음";
	                			break;
	                		case "3":
	                			icon = "03";
	                			condition = "구름 많음";
	                			break;
	                		case "4":
	                			icon = "04";
	                			condition = "흐림";
	                			break;
						}    
	                }
	                if (item.category === "PTY") { 
	                    //(초단기) 없음(0), 비(1), 비/눈(2), 눈(3), 빗방울(5), 빗방울눈날림(6), 눈날림(7) 
	                    switch (item.fcstValue) {    	
							case "0":
								break;
							case "1":
								icon = "05";
								condition = "비";
								break;
							case "2":
								icon = "06";
								condition = "비/눈";
								break;
							case "3":
								icon = "07";
								condition = "눈";
								break;	
							case "5":
								icon = "08";
								condition = "빗방울";
								break;	
							case "5":
								icon = "09";
								condition = "빗방울";
								break;	
							case "6":
								icon = "10";
								condition = "빗방울눈날림";
								break;	
							case "7":
								icon = "11";
								condition = "눈날림";
								break;			        			
						}
					}   
				}
            });
            
            // 화면에 데이터 업데이트
            const regionName = regionMap[`${nx},${ny}`] || "알 수 없는 지역";
            
            //alert(nx + " : " + ny);
            
            $("#temperature").text(`${temperature}`);
            $("#condition").text(`${condition}`);                
            $("#location").text(regionName);
            
            let img_nm = "";
            img_nm = `/resources/images/w${icon}.png`; //이미지 아이콘코드 별로 필요함
                        
            $("#img_icon").attr("src", img_nm);
            
            //const imgElement = $("#img_icon");  // 이미지 요소 선택
            //imgElement.attr("src", `/resources/images/weather_${icon}.jpg`);  // weather_01.jpg, weather_02.jpg, 
        },
        error: function() {
            console.error("날씨 데이터를 불러오는 중 오류가 발생했습니다.");
        }
    });
}

const regionMap = {
    '60,127': '서울',
    '55,124': '인천',
    '89,91': '대전',
    '98,76': '대구',
    '73,134': '춘천',
    '66,103': '광주',
    '102,84': '부산',
    '67,100': '전주',
    '57,128': '고양시',
    '59,126': '신수동',
    // 필요한 만큼 추가
};
