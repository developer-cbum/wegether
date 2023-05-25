$(function () {
    const BtnNotice = $('.btn_notice');
    const NoticeSec = $('.notice_section');

    //   공지사항 리스트
    $(BtnNotice).on('click', function () {
        console.log('classOn');
        $(NoticeSec).toggleClass('AnnouncementPopover_slideDown__31tIu');
    });
}); //E
