$(document).ready(function () {
    $(".menu_01_p").hover(
        function (event) {
            console.log(event);
            $(".menu_01_img").addClass("reverse");
        },
        function (event) {
            console.log(event);
            $(".menu_01_img").removeClass("reverse");
        }
    );

    $(".menu_02_p").hover(
        function (event) {
            console.log(event);
            $(".menu_02_img").addClass("reverse");
            $(".menu_01_img").addClass("reverse_d");
        },
        function (event) {
            console.log(event);
            $(".menu_02_img").removeClass("reverse");
            $(".menu_01_img").removeClass("reverse_d");
        }
    );

    $(".menu_03_p").hover(
        function (event) {
            console.log(event);
            $(".menu_03_img").addClass("reverse");
            $(".menu_01_img").addClass("reverse_d");
        },
        function (event) {
            console.log(event);
            $(".menu_03_img").removeClass("reverse");
            $(".menu_01_img").removeClass("reverse_d");
        }
    );

    $(".menu_04_p").hover(
        function (event) {
            console.log(event);
            $(".menu_04_img").addClass("reverse");
            $(".menu_01_img").addClass("reverse_d");
        },
        function (event) {
            console.log(event);
            $(".menu_04_img").removeClass("reverse");
            $(".menu_01_img").removeClass("reverse_d");
        }
    );

    $(".menu_05_p").hover(
        function (event) {
            console.log(event);
            $(".menu_05_img").addClass("reverse");
            $(".menu_01_img").addClass("reverse_d");
        },
        function (event) {
            console.log(event);
            $(".menu_05_img").removeClass("reverse");
            $(".menu_01_img").removeClass("reverse_d");
        }
    );

    $(".menu_06_p").hover(
        function (event) {
            console.log(event);
            $(".menu_06_img").addClass("reverse");
            $(".menu_01_img").addClass("reverse_d");
        },
        function (event) {
            console.log(event);
            $(".menu_06_img").removeClass("reverse");
            $(".menu_01_img").removeClass("reverse_d");
        }
    );

    $(".menu_07_p").hover(
        function (event) {
            console.log(event);
            $(".menu_07_img").addClass("reverse");
            $(".menu_01_img").addClass("reverse_d");
        },
        function (event) {
            console.log(event);
            $(".menu_07_img").removeClass("reverse");
            $(".menu_01_img").removeClass("reverse_d");
        }
    );

    $(".menu_08_p").hover(
        function (event) {
            console.log(event);
            $(".menu_08_img").addClass("reverse");
            $(".menu_01_img").addClass("reverse_d");
        },
        function (event) {
            console.log(event);
            $(".menu_08_img").removeClass("reverse");
            $(".menu_01_img").removeClass("reverse_d");
        }
    );

    $(".menu_09_p").hover(
        function (event) {
            console.log(event);
            $(".menu_09_img").addClass("reverse");
            $(".menu_01_img").addClass("reverse_d");
        },
        function (event) {
            console.log(event);
            $(".menu_09_img").removeClass("reverse");
            $(".menu_01_img").removeClass("reverse_d");
        }
    );

    $(".menu_10_p").hover(
        function (event) {
            console.log(event);
            $(".menu_10_img").addClass("reverse");
            $(".menu_01_img").addClass("reverse_d");
        },
        function (event) {
            console.log(event);
            $(".menu_10_img").removeClass("reverse");
            $(".menu_01_img").removeClass("reverse_d");
        }
    );

    $(".menu_11_p").hover(
        function (event) {
            console.log(event);
            $(".menu_11_img").addClass("reverse");
            $(".menu_01_img").addClass("reverse_d");
        },
        function (event) {
            console.log(event);
            $(".menu_11_img").removeClass("reverse");
            $(".menu_01_img").removeClass("reverse_d");
        }
    );

    $(".menu_12_p").hover(
        function (event) {
            console.log(event);
            $(".menu_12_img").addClass("reverse");
            $(".menu_01_img").addClass("reverse_d");
        },
        function (event) {
            console.log(event);
            $(".menu_12_img").removeClass("reverse");
            $(".menu_01_img").removeClass("reverse_d");
        }
    );

    $(".menu_13_p").hover(
        function (event) {
            console.log(event);
            $(".menu_13_img").addClass("reverse");
            $(".menu_01_img").addClass("reverse_d");
        },
        function (event) {
            console.log(event);
            $(".menu_13_img").removeClass("reverse");
            $(".menu_01_img").removeClass("reverse_d");
        }
    );

    $(".menu_14_p").hover(
        function (event) {
            console.log(event);
            $(".menu_14_img").addClass("reverse");
            $(".menu_01_img").addClass("reverse_d");
        },
        function (event) {
            console.log(event);
            $(".menu_14_img").removeClass("reverse");
            $(".menu_01_img").removeClass("reverse_d");
        }
    );

    $(".menu_15_p").hover(
        function (event) {
            console.log(event);
            $(".menu_15_img").addClass("reverse");
            $(".menu_01_img").addClass("reverse_d");
        },
        function (event) {
            console.log(event);
            $(".menu_15_img").removeClass("reverse");
            $(".menu_01_img").removeClass("reverse_d");
        }
    );
});

// MAIN 08. 다중 요소 슬라이드
new Swiper(".awards .swiper", {
    autoplay: true,
    loop: true,
    spaceBetween: 30,
    slidesPerView: 5, // 한번에 보여줄 슬라이드 개수,
    navigation: {
        prevEl: ".awards .swiper-prev",
        nextEl: ".awards .swiper-next",
    },
});
