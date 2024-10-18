const swiper = new Swiper('.swiper', {
	autoplay: {
		//자동슬라이드 (false-비활성화)          
		delay: 5000, // 시간 설정          
		disableOnInteraction: false, // false-스와이프 후 자동 재생        
	},
	loop: true, // 반복재생 여부
	slidesPerView: 1, //레이아웃 뷰 개수
    /* swiper-slide에 각각 margin-right를 준다. */
    spaceBetween: 30,

    centeredSlides: true, 
	grabCursor: true,

	// If we need pagination
	pagination: {
		 el: ".swiper-pagination", //버튼을 담을 태그 설정          
		clickable: true, // 버튼 클릭 여부
	},

	// Navigation arrows
	navigation: {
		nextEl: '.swiper-button-next',
		prevEl: '.swiper-button-prev',
	},
    breakpoints:{
        280: {
           //280px 이하의 크기에서 옵션 값 
        },
        768 : {
        	//768px 이하의 크기에서 옵션 값 
        },
        1024 : {
           //1024px 이하의 크기에서 옵션 값 
        }
    }
});