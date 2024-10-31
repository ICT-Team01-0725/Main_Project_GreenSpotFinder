$(document).ready(function () {
    // 숫자 카운트 애니메이션
    $('.nums').each(function () {
        const $this = $(this),
            countTo = $this.attr('data-count');

        // 애니메이션 시작
        $({
            countNum: $this.text()
        }).animate({
            countNum: countTo
        }, {
            duration: 500, // 애니메이션 지속 시간 (밀리초)
            easing: 'linear', // 애니메이션의 흐름
            step: function () {
                // 현재 숫자를 반올림하여 텍스트로 업데이트
                $this.text(Math.floor(this.countNum));
            },
            complete: function () {
                // 애니메이션 완료 후 최종 숫자 설정
                $this.text(this.countNum);
            }
        });
    });
});
