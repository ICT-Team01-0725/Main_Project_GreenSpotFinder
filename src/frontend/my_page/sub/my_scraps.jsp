<!-- 스크랩 페이지 삭제에 따라 mypage_menu.jsp내 변경사항을 따라서 서브 페이지 변경 부탁드립니다 --> 

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>마이 페이지 - 스크랩</title>
	<link rel="icon" type="image/x-icon" href="resourceresources/images/favicon.png">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.2/reset.min.css">
    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    
    <link rel="stylesheet" href="resources/css/menu.css" />
    <link rel="stylesheet" href="resources/css/mypage_main.css" />
    <link rel="stylesheet" href="resources/css/my_scraps.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="resources/js/menu.js"></script>
</head>
<body>
	<div id="sub_main_container">
        <!-- sub_header 불러오기 -->
        <jsp:include page="../common/sub_header.jsp"></jsp:include>
        
        <!-- 컨텐츠 영역(main) 시작 -->
        <main>
            <div id="sub_container">
                <ul class="contents_box">
                    <li class="textcenter">
                        <h2 class="great_title">마이페이지</h2>
                        <p class="subheading_title_my">스크랩</p>
                        
                        <!-- 마이 페이지 메뉴 -->
                        <jsp:include page="../common/mypage_menu.jsp"></jsp:include>
                        
                        <!-- 마이 페이지 프로필 -->
                        <jsp:include page="../common/mypage_profile.jsp"></jsp:include>

                        <!-- 나의 녹지 스크랩 -->
                        <div class="my_greenery_scraps2">
                            <ul class="my_scraps_category">
                                <li class="on" onclick="scraps_category()">
                                    <div class="scraps_img"></div>
                                    <p>공원</p>
                                </li>
                                <li onclick="scraps_category()">
                                    <div class="scraps_img"></div>
                                    <p>가로수길</p>
                                </li>
                                <li onclick="scraps_category()">
                                    <div class="scraps_img"></div>
                                    <p>보호수</p>
                                </li>
                            </ul>
                        </div>
                        
                        
                        <!-- photo list 영역 start -->
		                <ul class="photo_list_ul">
		                    <li>
		                        <div class="photo_list_img box">
		                            <img src="resources/images/rewiew_1.jpg" alt="rewiew_1." class="content">
		                        </div>
		                        <div class="contents">
		                            <p class="review_stars">
		                                <i class="fa-solid fa-star"></i>
		                                <i class="fa-solid fa-star"></i>
		                                <i class="fa-solid fa-star"></i>
		                                <i class="fa-solid fa-star"></i>
		                                <i class="fa-solid fa-star"></i>
		                            </p>
		                            <p class="place_name">장소명</p>
		                            <p class="place_content">
		                                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quo odio nostrum at neque vel, itaque unde quibusdam doloribus, ut eum ea deleniti reprehenderit, temporibus deserunt illo maxime molestiae ratione. Reprehenderit.                        
		                            </p>
		                            <p class="id">id12345</p>
		                        </div>
		                    </li>
		                    <li>
		                        <div class="photo_list_img box">
		                            <img src="resources/images/rewiew_1.jpg" alt="rewiew_1." class="content">
		                        </div>
		                        <div class="contents">
		                            <p class="review_stars">
		                                <i class="fa-solid fa-star"></i>
		                                <i class="fa-solid fa-star"></i>
		                                <i class="fa-solid fa-star"></i>
		                                <i class="fa-solid fa-star"></i>
		                                <i class="fa-solid fa-star"></i>
		                            </p>
		                            <p class="place_name">장소명</p>
		                            <p class="place_content">
		                                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quo odio nostrum at neque vel, itaque unde quibusdam doloribus, ut eum ea deleniti reprehenderit, temporibus deserunt illo maxime molestiae ratione. Reprehenderit.                        
		                            </p>
		                            <p class="id">id12345</p>
		                        </div>
		                    </li>
		                    <li>
		                        <div class="photo_list_img box">
		                            <img src="resources/images/rewiew_1.jpg" alt="rewiew_1." class="content">
		                        </div>
		                        <div class="contents">
		                            <p class="review_stars">
		                                <i class="fa-solid fa-star"></i>
		                                <i class="fa-solid fa-star"></i>
		                                <i class="fa-solid fa-star"></i>
		                                <i class="fa-solid fa-star"></i>
		                                <i class="fa-solid fa-star"></i>
		                            </p>
		                            <p class="place_name">장소명</p>
		                            <p class="place_content">
		                                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quo odio nostrum at neque vel, itaque unde quibusdam doloribus, ut eum ea deleniti reprehenderit, temporibus deserunt illo maxime molestiae ratione. Reprehenderit.                        
		                            </p>
		                            <p class="id">id12345</p>
		                        </div>
		                    </li>
		                    <li>
		                        <div class="photo_list_img box">
		                            <img src="resources/images/rewiew_1.jpg" alt="rewiew_1." class="content">
		                        </div>
		                        <div class="contents">
		                            <p class="review_stars">
		                                <i class="fa-solid fa-star"></i>
		                                <i class="fa-solid fa-star"></i>
		                                <i class="fa-solid fa-star"></i>
		                                <i class="fa-solid fa-star"></i>
		                                <i class="fa-solid fa-star"></i>
		                            </p>
		                            <p class="place_name">장소명</p>
		                            <p class="place_content">
		                                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quo odio nostrum at neque vel, itaque unde quibusdam doloribus, ut eum ea deleniti reprehenderit, temporibus deserunt illo maxime molestiae ratione. Reprehenderit.                        
		                            </p>
		                            <p class="id">id12345</p>
		                        </div>
		                    </li>
		                    <li>
		                        <div class="photo_list_img box">
		                            <img src="resources/images/rewiew_1.jpg" alt="rewiew_1." class="content">
		                        </div>
		                        <div class="contents">
		                            <p class="review_stars">
		                                <i class="fa-solid fa-star"></i>
		                                <i class="fa-solid fa-star"></i>
		                                <i class="fa-solid fa-star"></i>
		                                <i class="fa-solid fa-star"></i>
		                                <i class="fa-solid fa-star"></i>
		                            </p>
		                            <p class="place_name">장소명</p>
		                            <p class="place_content">
		                                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quo odio nostrum at neque vel, itaque unde quibusdam doloribus, ut eum ea deleniti reprehenderit, temporibus deserunt illo maxime molestiae ratione. Reprehenderit.                        
		                            </p>
		                            <p class="id">id12345</p>
		                        </div>
		                    </li>
		                    <li>
		                        <div class="photo_list_img box">
		                            <img src="resources/images/rewiew_1.jpg" alt="rewiew_1." class="content">
		                        </div>
		                        <div class="contents">
		                            <p class="review_stars">
		                                <i class="fa-solid fa-star"></i>
		                                <i class="fa-solid fa-star"></i>
		                                <i class="fa-solid fa-star"></i>
		                                <i class="fa-solid fa-star"></i>
		                                <i class="fa-solid fa-star"></i>
		                            </p>
		                            <p class="place_name">장소명</p>
		                            <p class="place_content">
		                                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quo odio nostrum at neque vel, itaque unde quibusdam doloribus, ut eum ea deleniti reprehenderit, temporibus deserunt illo maxime molestiae ratione. Reprehenderit.                        
		                            </p>
		                            <p class="id">id12345</p>
		                        </div>
		                    </li>
		                    <li>
		                        <div class="photo_list_img box">
		                            <img src="resources/images/rewiew_1.jpg" alt="rewiew_1." class="content">
		                        </div>
		                        <div class="contents">
		                            <p class="review_stars">
		                                <i class="fa-solid fa-star"></i>
		                                <i class="fa-solid fa-star"></i>
		                                <i class="fa-solid fa-star"></i>
		                                <i class="fa-solid fa-star"></i>
		                                <i class="fa-solid fa-star"></i>
		                            </p>
		                            <p class="place_name">장소명</p>
		                            <p class="place_content">
		                                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quo odio nostrum at neque vel, itaque unde quibusdam doloribus, ut eum ea deleniti reprehenderit, temporibus deserunt illo maxime molestiae ratione. Reprehenderit.                        
		                            </p>
		                            <p class="id">id12345</p>
		                        </div>
		                    </li>
		                    <li>
		                        <div class="photo_list_img box">
		                            <img src="resources/images/rewiew_1.jpg" alt="rewiew_1." class="content">
		                        </div>
		                        <div class="contents">
		                            <p class="review_stars">
		                                <i class="fa-solid fa-star"></i>
		                                <i class="fa-solid fa-star"></i>
		                                <i class="fa-solid fa-star"></i>
		                                <i class="fa-solid fa-star"></i>
		                                <i class="fa-solid fa-star"></i>
		                            </p>
		                            <p class="place_name">장소명</p>
		                            <p class="place_content">
		                                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quo odio nostrum at neque vel, itaque unde quibusdam doloribus, ut eum ea deleniti reprehenderit, temporibus deserunt illo maxime molestiae ratione. Reprehenderit.                        
		                            </p>
		                            <p class="id">id12345</p>
		                        </div>
		                    </li>
		                    <li>
		                        <div class="photo_list_img box">
		                            <img src="resources/images/rewiew_1.jpg" alt="rewiew_1." class="content">
		                        </div>
		                        <div class="contents">
		                            <p class="review_stars">
		                                <i class="fa-solid fa-star"></i>
		                                <i class="fa-solid fa-star"></i>
		                                <i class="fa-solid fa-star"></i>
		                                <i class="fa-solid fa-star"></i>
		                                <i class="fa-solid fa-star"></i>
		                            </p>
		                            <p class="place_name">장소명</p>
		                            <p class="place_content">
		                                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quo odio nostrum at neque vel, itaque unde quibusdam doloribus, ut eum ea deleniti reprehenderit, temporibus deserunt illo maxime molestiae ratione. Reprehenderit.                        
		                            </p>
		                            <p class="id">id12345</p>
		                        </div>
		                    </li>
		                    <li>
		                        <div class="photo_list_img box">
		                            <img src="resources/images/rewiew_1.jpg" alt="rewiew_1." class="content">
		                        </div>
		                        <div class="contents">
		                            <p class="review_stars">
		                                <i class="fa-solid fa-star"></i>
		                                <i class="fa-solid fa-star"></i>
		                                <i class="fa-solid fa-star"></i>
		                                <i class="fa-solid fa-star"></i>
		                                <i class="fa-solid fa-star"></i>
		                            </p>
		                            <p class="place_name">장소명</p>
		                            <p class="place_content">
		                                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quo odio nostrum at neque vel, itaque unde quibusdam doloribus, ut eum ea deleniti reprehenderit, temporibus deserunt illo maxime molestiae ratione. Reprehenderit.                        
		                            </p>
		                            <p class="id">id12345</p>
		                        </div>
		                    </li>
		                    <li>
		                        <div class="photo_list_img box">
		                            <img src="resources/images/rewiew_1.jpg" alt="rewiew_1." class="content">
		                        </div>
		                        <div class="contents">
		                            <p class="review_stars">
		                                <i class="fa-solid fa-star"></i>
		                                <i class="fa-solid fa-star"></i>
		                                <i class="fa-solid fa-star"></i>
		                                <i class="fa-solid fa-star"></i>
		                                <i class="fa-solid fa-star"></i>
		                            </p>
		                            <p class="place_name">장소명</p>
		                            <p class="place_content">
		                                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quo odio nostrum at neque vel, itaque unde quibusdam doloribus, ut eum ea deleniti reprehenderit, temporibus deserunt illo maxime molestiae ratione. Reprehenderit.                        
		                            </p>
		                            <p class="id">id12345</p>
		                        </div>
		                    </li>
		                    <li>
		                        <div class="photo_list_img box">
		                            <img src="resources/images/rewiew_1.jpg" alt="rewiew_1." class="content">
		                        </div>
		                        <div class="contents">
		                            <p class="review_stars">
		                                <i class="fa-solid fa-star"></i>
		                                <i class="fa-solid fa-star"></i>
		                                <i class="fa-solid fa-star"></i>
		                                <i class="fa-solid fa-star"></i>
		                                <i class="fa-solid fa-star"></i>
		                            </p>
		                            <p class="place_name">장소명</p>
		                            <p class="place_content">
		                                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quo odio nostrum at neque vel, itaque unde quibusdam doloribus, ut eum ea deleniti reprehenderit, temporibus deserunt illo maxime molestiae ratione. Reprehenderit.                        
		                            </p>
		                            <p class="id">id12345</p>
		                        </div>
		                    </li>
		                </ul>
		                
		                <!-- paging 영역 start -->
		                <div>
		                    <ul class="paging_num_ul">
		                        <li class="material-icons prev">
		                            keyboard_double_arrow_left
		                        </li>
		                        <li class="material-icons prev">
		                            chevron_left
		                        </li>
		                        <li class="active">1</li>
		                        <li>2</li>
		                        <li>3</li>
		                        <li>4</li>
		                        <li>5</li>
		                        <li class="material-icons next">
		                            chevron_right
		                        </li>
		                        <li class="material-icons next">
		                            keyboard_double_arrow_right
		                        </li>
		                    </ul>
		                </div>
		                <!-- paging 영역 end -->
			            <!-- photo list 영역 end -->
                    </li>
                </ul>
            </div>
        	<!-- 컨텐츠 영역(main) 끝 -->
        	
        	
        	<!-- footer 불러오기 -->
        	<jsp:include page="../common/sub_footer.jsp"></jsp:include>
        </main>
        	
        <!-- 모바일 메뉴 불러오기 -->
        <jsp:include page="../common/sub_m_menu.jsp"></jsp:include>
    </div>
    
    
    <jsp:include page="../common/topBtn.jsp"></jsp:include>
    
    <script>
	    $(document).ready(function () {
	        function toggleSidebar() {
	            $(".button").toggleClass("active");
	            $("main").toggleClass("move-to-left");
	            $(".sidebar-item").toggleClass("active");
	            $(".sidebar-item").toggleClass("active");
	        }
	
	        $(".button").on("click tap", function () {
	            toggleSidebar();
	        });
	
	        
	    });
	
	    const btns = document.querySelectorAll(".sub_menu_area, .btn");
	
	    btns.forEach((btn) => {
	        btn.addEventListener("click", () => {
	            const faqItem = btn.parentNode;
	            const isActive = faqItem.classList.contains("active");
	
	            removeActiveClasses();
	
	            if (!isActive) {
	                faqItem.classList.add("active");
	            }
	        });
	    });
	
	    function removeActiveClasses() {
	        btns.forEach((btn) => {
	            btn.parentNode.classList.remove("active");
	        });
	    }
	
	    function open_chatroom(){
	        var windowWidth = $( window ).width(); 
	        if(windowWidth > 1000) {
	            //창 가로 크기가 500 미만일 경우  
	            console.log("1000px 이상");
	            
	            $(".sidebar").addClass("displayNone");
	            $(".sidebar").removeClass("displayBlock");
	            $("main").removeClass("move-to-left");
	            $(".button").removeClass("active");
	
	            
	                
	        } else if(windowWidth > 768) {
	            //창 가로 크기가 500 미만일 경우  
	            console.log("768px 이상");
	            $(".sidebar").removeClass("displayNone");
	            $(".sidebar").addClass("displayBlock");
	            
	        } else if(windowWidth > 480) {
	            //창 가로 크기가 500 미만일 경우  
	            console.log("480px 이상");
	            $(".sidebar").removeClass("displayNone");
	            $(".sidebar").addClass("displayBlock");
	        }
	    }
	
	    $( window ).resize(function() {
	        //창크기 변화 감지
	        open_chatroom();
	    });
	
	    open_chatroom();
	
	    // sroll top Script
	    const basicScrollTop = function () {
	        // The button
	        const btnTop = document.querySelector('#goTop');
	        // Reveal the button
	        const btnReveal = function () {
	            if (window.scrollY >= 300) {
	                btnTop.classList.add('is-visible');
	            } else {
	                btnTop.classList.remove('is-visible');
	            }
	        }
	        // Smooth scroll top
	        // Thanks to => http://stackoverflow.com/a/22610562
	        const TopscrollTo = function () {
	            if (window.scrollY != 0) {
	                setTimeout(function () {
	                    window.scrollTo(0, window.scrollY - 30);
	                    TopscrollTo();
	                }, 5);
	            }
	        }
	        // Listeners
	        window.addEventListener('scroll', btnReveal);
	        btnTop.addEventListener('click', TopscrollTo);
	
	    };
	    basicScrollTop();
	
	    
	    if (jQuery(window).width() > 0) {
	        jQuery(window).on("scroll", function (ev) {
	            if (jQuery(window).scrollTop() > 0) {
	                jQuery('.mypage_nav').addClass('bg_on');
	            } else {
	                jQuery('.mypage_nav').removeClass('bg_on');
	            }
	            return false;
	        });
	    }
	
	
	    //숫자 카운트 애니메이션
	    $('.nums').each(function () {
	        const $this = $(this),
	            countTo = $this.attr('data-count');
	
	        $({
	            countNum: $this.text()
	        }).animate({
	            countNum: countTo
	        }, {
	            duration: 500,
	            easing: 'linear',
	            step: function () {
	                $this.text(Math.floor(this.countNum));
	            },
	            complete: function () {
	                $this.text(this.countNum);
	            }
	        });
	    });
    </script>
</body>
</html>
