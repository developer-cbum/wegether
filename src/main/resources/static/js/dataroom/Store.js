// 버튼 클릭시 페이지 위로 이동
$(document).ready(function () {
    var button = $(".FloatingTopButton_pageTop__2gqm9");
    button.hide();

    $(window).scroll(function () {
        if ($(this).scrollTop() > 0) {
            button.fadeIn();
        } else {
            button.fadeOut();
        }
    });

    button.click(function () {
        $("html, body").animate({scrollTop: 0}, "slow");
        return false;
    });
});

$(document).ready(function () {
    $('.OrderSelectDesktop_sortItem__12TKi').click(function () {
        //   클릭한 버튼 활성화
        $(this).addClass('OrderSelectDesktop_active__YTP2K').siblings().removeClass('OrderSelectDesktop_active__YTP2K');
    });
});


$(document).ready(function () {
    $('.ImageTab_tab__3siCY').click(function () {
        // 클릭한 버튼 활성화
        $(this).addClass('ImageTab_active__BGdXu')
            .parent()
            .siblings()
            .find('.ImageTab_tab__3siCY')
            .removeClass('ImageTab_active__BGdXu');
    });
});