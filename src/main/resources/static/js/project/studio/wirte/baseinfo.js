// .select_category_wrap
$(function () {
    const MenuController = $('.select-menu__control');
    const NoticeSec = $('.notice_section');

    // 카테고리 리스트 초기화
    $('.select_category_wrap').hide();

    //   공지사항 리스트
    $(MenuController).on('click', function () {
        console.log('classOn');
        $('.select_category_wrap').toggle();
        $(this).toggleClass('select-menu__control--menu-is-open');
    });
}); //E
