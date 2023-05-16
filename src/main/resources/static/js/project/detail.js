$(function () {
    /* input tag + btns */

    let modal = $('.ReactModalPortal');
    let BtnApply = $('.btn_apply');
    let BtnModalClose = $('.btn_modal_close');

    // 인증하는 부분 + 모달 숨기기
    $(modal).hide();

    //   전체동의 모달 열기
    $(BtnApply).on('click', function () {
        $(modal).show();
    });

    //   전체동의 모달 닫기
    $(BtnModalClose).on('click', function () {
        $(modal).hide();
    });


}); //E
  