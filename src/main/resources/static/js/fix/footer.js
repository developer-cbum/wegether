let $recentViewContainer = $('#inquiryregister');

// 등록하기폼으로 이동하기 버튼
$recentViewContainer.on("click", function () {
    if (session == null) {
        showWarnModal("<span>로그인 후</span><span>이용해주세요.</span>");
        $('.modal').on("click", () => {
            location.href = '/accounts/login?list=false';
        })
    } else {
        location.href = '/index/inquiry-register';
    }
});

