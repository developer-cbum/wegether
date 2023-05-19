// 스토리 아래 추가 정보 버튼
$(document).on("click", "#btn1", function () {
    $(".ProductNoticeInfo_notiContainer__1Ui4k").toggle();
    $(".rotate-icon").toggleClass("rotate");
});

$(document).on("click", "#btn2", function () {
    $(".DetailStory_seller__O9uJ6").toggle();
    $(".rotate-icon2").toggleClass("rotate");
});

$(document).on("click", "#btn3", function () {
    $(".DetailStory_service__2rTtM").toggle();
    $(".rotate-icon3").toggleClass("rotate");
});

$(document).ready(function () {
    // 찜하기 버튼
    $('.ProductFloatButton_wishButtonBox__236EH button').click(function () {
        // 찜하기 버튼 활성화
        var isActive = $(this).attr('aria-pressed') === 'true';

        // 찜하기 버튼 활성화 업데이트
        $(this).attr('aria-pressed', !isActive);

        // 찜하기 버튼 아이콘 변경
        var svgIcon = $(this).find('svg');
        svgIcon.toggleClass('selected');

        // 찜하기 버튼 텍스트 업데이트
        var buttonCount = $(this).find('.ProductFloatButton_count__1a-7B');
        var count = parseInt(buttonCount.text().replace(/,/g, ''));
        if (isActive) {
            count--;
        } else {
            count++;
        }
        buttonCount.text(count.toLocaleString());
    });
});

//   판매자 정보 더보기 버튼
$(document).ready(function () {
    var moreButton = $(".StoreMakerInfoContainer_accordionButton__3rhUd:contains('더보기')");
    var closeButton = $(".StoreMakerInfoContainer_accordionButton__3rhUd:contains('닫기')");
    var contactSection = $('.StoreMakerInfoContainer_contactSection__3MZnT');

    contactSection.hide();
    closeButton.hide();

    moreButton.click(function () {
        contactSection.show();
        moreButton.hide();
        closeButton.show();
    });

    closeButton.click(function () {
        contactSection.hide();
        moreButton.show();
        closeButton.hide();
    });
});