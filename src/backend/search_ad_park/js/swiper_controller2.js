new Swiper('.garosu_slider .swiper', {
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
        320: {
        	// 320px 이하의 크기에서 옵션 값 
        },
        480: {
        	// 480px 이하의 크기에서 옵션 값 
			spaceBetween: 0 
        },
        650: {
        	// 650px 이하의 크기에서 옵션 값 
			spaceBetween: 0 
        },
        768 : {
        	// 768px 이하의 크기에서 옵션 값
        },
        1000 : {
        	// 1000px 이하의 크기에서 옵션 값 
        }
    }
});


new Swiper('.event_slider .swiper', {
	autoplay: {
		//자동슬라이드 (false-비활성화)          
		delay: 5000, // 시간 설정          
		disableOnInteraction: false, // false-스와이프 후 자동 재생        
	},
	loop: true, // 반복재생 여부
	slidesPerView: 1, //레이아웃 뷰 개수
    /* swiper-slide에 각각 margin-right를 준다. */
    spaceBetween: 30,

    // centeredSlides: true, 
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
        320: {
        	//320px 이하의 크기에서 옵션 값 
        },
        480: {
        	//480px 이하의 크기에서 옵션 값 
			slidesPerView: 1, //레이아웃 뷰 개수
        },
        650: {
        	// 650px 이하의 크기에서 옵션 값 
			slidesPerView: 2, //레이아웃 뷰 개수
        },
        768 : {
        	//768px 이하의 크기에서 옵션 값 
			slidesPerView: 2, //레이아웃 뷰 개수
        },
        950 : {
        	// 1000px 이하의 크기에서 옵션 값 
			slidesPerView: 3 //레이아웃 뷰 개수
        },
        1321 : {
        	// 1000px 이하의 크기에서 옵션 값 
			slidesPerView: 1 //레이아웃 뷰 개수
        }
    }
});

// 산책 코스 찾기
new Swiper('.course_slider .swiper', {
	autoplay: {
		//자동슬라이드 (false-비활성화)          
		delay: 10000, // 시간 설정          
		disableOnInteraction: false, // false-스와이프 후 자동 재생        
	},
	loop: true, // 반복재생 여부
	slidesPerView: 1, //레이아웃 뷰 개수
    /* swiper-slide에 각각 margin-right를 준다. */

    // centeredSlides: true, 
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
        320: {
        	//320px 이하의 크기에서 옵션 값 
        },
        480: {
        	//480px 이하의 크기에서 옵션 값 
        },
        650: {
        	// 650px 이하의 크기에서 옵션 값 
        },
        768 : {
        	//768px 이하의 크기에서 옵션 값 
        },
        1000 : {
        	// 1000px 이하의 크기에서 옵션 값 
        }
    }
});

// 개최중인 행사 찾기
new Swiper('.in_progress_slider .swiper', {
	// autoplay: {
		//자동슬라이드 (false-비활성화)          
		// delay: 10000, // 시간 설정          
		// disableOnInteraction: false, // false-스와이프 후 자동 재생        
	// },
	loop: true, // 반복재생 여부
	slidesPerView: 1, //레이아웃 뷰 개수
    /* swiper-slide에 각각 margin-right를 준다. */

    // centeredSlides: true, 
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
        320: {
        	//320px 이하의 크기에서 옵션 값 
        },
        480: {
        	//480px 이하의 크기에서 옵션 값 
        },
        650: {
        	// 650px 이하의 크기에서 옵션 값 
        },
        768 : {
        	//768px 이하의 크기에서 옵션 값 
        },
        1000 : {
        	// 1000px 이하의 크기에서 옵션 값 
        }
    }
});

// 개최예정중인 행사 찾기
new Swiper('.scheduled_slider .swiper', {
	// autoplay: {
		//자동슬라이드 (false-비활성화)          
		// delay: 10000, // 시간 설정          
		// disableOnInteraction: false, // false-스와이프 후 자동 재생        
	// },
	loop: true, // 반복재생 여부
	slidesPerView: 1, //레이아웃 뷰 개수
    /* swiper-slide에 각각 margin-right를 준다. */

    // centeredSlides: true, 
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
        320: {
        	//320px 이하의 크기에서 옵션 값 
        },
        480: {
        	//480px 이하의 크기에서 옵션 값 
        },
        650: {
        	// 650px 이하의 크기에서 옵션 값 
        },
        768 : {
        	//768px 이하의 크기에서 옵션 값 
        },
        1000 : {
        	// 1000px 이하의 크기에서 옵션 값 
        }
    }
});


$(document).ready(function() {

	var menuIdx = $(".m_menu_slide .swiper-slide.cur_submenu").index();

	const swiper1 = new Swiper('.m_menu_slide .swiper', {
		initialSlide: menuIdx,	
		breakpoints: {
			// 화면의 넓이가 320px 이상일 때
			320: {
				slidesPerView : '2', // 한 슬라이드에 보여줄 갯수

				// Navigation arrows
				navigation: {
					nextEl: '.swiper-button-next',
					prevEl: '.swiper-button-prev',
				}
			},
			450: {
				slidesPerView : '3', // 한 슬라이드에 보여줄 갯수

				// Navigation arrows
				navigation: {
					nextEl: '.swiper-button-next',
					prevEl: '.swiper-button-prev',
				}
			},
			600: {
				slidesPerView : '4', // 한 슬라이드에 보여줄 갯수

				// Navigation arrows
				navigation: {
					nextEl: '.swiper-button-next',
					prevEl: '.swiper-button-prev',
				}
			},
			750: {
				slidesPerView : '5', // 한 슬라이드에 보여줄 갯수

				// Navigation arrows
				navigation: {
					nextEl: '.swiper-button-next',
					prevEl: '.swiper-button-prev',
				}
			},
			// 화면의 넓이가 640px 이상일 때
			1000: {
				slidesPerView : '10', // 한 슬라이드에 보여줄 갯수
				spaceBetween: 10,

				// Navigation arrows
				navigation: {
					nextEl: '.swiper-button-next',
					prevEl: '.swiper-button-prev',
				}

			}
		}
	});
});


// 베스트 리뷰 슬라이드
new Swiper('.best_review_slider .swiper', {
	loop: true, // 반복재생 여부
	slidesPerView: 4, //레이아웃 뷰 개수
    /* swiper-slide에 각각 margin-right를 준다. */
    spaceBetween: 32,

    // centeredSlides: true, 
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
        320: {
        	//320px 이하의 크기에서 옵션 값 
			slidesPerView: 1, //레이아웃 뷰 개수
        },
        480: {
        	//480px 이하의 크기에서 옵션 값 
			slidesPerView: 2, //레이아웃 뷰 개수
        },
        768 : {
        	//768px 이하의 크기에서 옵션 값 
			slidesPerView: 3, //레이아웃 뷰 개수
        },
        1000 : {
        	// 1000px 이하의 크기에서 옵션 값 
			slidesPerView: 4, //레이아웃 뷰 개수
        }
    }
});
