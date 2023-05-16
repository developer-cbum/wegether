// 더보기 버튼
$(".GNBDesktop_container__3X3Cg").on("click", function () {
    if ($(".MoreMenuDesktop_isOpened__17yOy").css("display") == "none" && $(".GNBDesktop_backdrop__3h5Cq").css("display") == "none") {
        $(".MoreMenuDesktop_isOpened__17yOy").slideDown();
        $(".GNBDesktop_backdrop__3h5Cq").show();
    } else {
        $(".MoreMenuDesktop_isOpened__17yOy").hide();
        $(".GNBDesktop_backdrop__3h5Cq").hide();
    }

    if ($(".DesktopSearchApp_wideConditionContainer__fDZNJ").css("display") == "block" || $(".NotificationPopover_container__3nC48").css("display") == "block") {
        $(".DesktopSearchApp_wideConditionContainer__fDZNJ").hide()
        $(".NotificationPopover_container__3nC48").hide();
    }
});
// 검색버튼
$("input[type=search]").on("click", function () {
    if ($(".DesktopSearchApp_wideConditionContainer__fDZNJ").css("display") == "none") {
        $(".DesktopSearchApp_wideConditionContainer__fDZNJ").show()
    } else {
        $(".DesktopSearchApp_wideConditionContainer__fDZNJ").hide()
    }

    if ($(".MoreMenuDesktop_isOpened__17yOy").css("display") == "block" || $(".GNBDesktop_backdrop__3h5Cq").css("display") == "block" || $(".NotificationPopover_container__3nC48").css("display") == "block") {
        $(".MoreMenuDesktop_isOpened__17yOy").hide();
        $(".GNBDesktop_backdrop__3h5Cq").hide();
        $(".NotificationPopover_container__3nC48").hide();
    }
})
// 헤더 반응형
$(window).resize(function(){
    if (window.innerWidth > 1097) {  // 다바이스 크기가 480이상일때
        /* 스크립트내용*/
        $(".web-header-large").show();
        $(".web-header-mobile").hide();
        $(".MobileTitleBar_container__2ywDg").hide();
        $(".MobileSearchAppMain_content__2OZNC").hide();
    } else {
        /* 스크립트내용*/
        $(".web-header-large").hide();
        $(".web-header-mobile").show();

    }
}).resize();
// 모바일 검색버튼
$(".SearchField_container__2Wc6p").on("click", function(){
    if($(".MobileSearchAppMain_content__2OZNC").css("display") == "none"){
        $(".MobileSearchAppMain_content__2OZNC").show();
        $(".MobileTitleBar_container__2ywDg").show();
        $(".web-header-mobile").hide();
        $(".web-header-large").hide();
    }
})
// 모바일 검색버튼 해제
$(".MobileTitleBar_buttonContainer__3jnuy").on("click", function(){
    if($(".MobileSearchAppMain_content__2OZNC").css("display") == "block")
        $(".web-header-mobile").show();
    $(".MobileTitleBar_container__2ywDg").hide();
    $(".MobileSearchAppMain_content__2OZNC").hide();
})
// 알림버튼
$(".HeaderDesktop_notificationContainer__1iRey").on("click", function(){
    if($(".NotificationPopover_container__3nC48").css("display") == "none"){
        $(".NotificationPopover_container__3nC48").show();
    }else{$(".NotificationPopover_container__3nC48").hide();}

    if($(".MoreMenuDesktop_isOpened__17yOy").css("display") == "block" || $(".GNBDesktop_backdrop__3h5Cq").css("display") == "block" || $(".DesktopSearchApp_wideConditionContainer__fDZNJ").css("display") == "block"){
        $(".MoreMenuDesktop_isOpened__17yOy").hide();
        $(".GNBDesktop_backdrop__3h5Cq").hide();
        $(".DesktopSearchApp_wideConditionContainer__fDZNJ").hide();
    }
})

// 모바일 알림버튼
$(".NotificationButton_btnNotification__2fRCj").on("click", function(){
    if($(".ReactModalPortal").css("display") == "none" && window.innerWidth < 1097){
        $(".ReactModalPortal").show();
    }
})

// 모바일 알림 모달 닫기
$(".ConfirmModal_closeIconWrapper__1ON9Q").on("click", function(){
    $(".ReactModalPortal").hide();
})
