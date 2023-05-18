$(function () {

    <!-- 모달 부분 js -->

    let modalCheck;
    function showWarnModal(modalMessage) {
        modalCheck = false;
        $('div#content-wrap').html(modalMessage);
        $('div.warn-modal').css('animation', 'popUp 0.5s');
        $('div.modal').css('display', 'flex').hide().fadeIn(500);
        setTimeout(function () {
            modalCheck = true;
        }, 500);
    }

    $('div.modal').on('click', function () {
        if (modalCheck) {
            $('div.warn-modal').css('animation', 'popDown 0.5s');
            $('div.modal').fadeOut(500);
        }
    });


    <!-- 유효성 검사 -->
    <!-- 여기 부분 다른 곳 작업 끝나면 유효성 검사 추가 -->

    function check() {}
    // 자료 제목 유효성 검사
    if (document.registerForm.dataTitle.value == '') {
        showWarnModal('자료 제목을 입력해주세요');
        document.registerForm.dataTitle.focus();
        return;
    }

    // 자료 가격
    if (document.registerForm.dataPrice.value == '') {
        showWarnModal('자료 가격을 입력해주세요');
        document.registerForm.dataPrice.focus();
        return;
    }

    // 자료 출처(학교)
    if (document.registerForm.dataSchool.value == '') {
        showWarnModal('자료 출처(학교)를 입력해주세요');
        document.registerForm.dataSchool.focus();
        return;
    }

    // 자료 출처(전공)
    if (document.registerForm.dataMajor.value == '') {
        showWarnModal('자료 출처(전공)을 입력해주세요');
        document.registerForm.dataMajor.focus();
        return;
    }

    // 자료 내용 유효성 검사
    if (document.registerForm.dataContent.value == '') {
        showWarnModal('자료 내용을 입력해주세요');
        document.registerForm.dataContent.focus();
        return;
    }

    showWarnModal('저장이 완료되었습니다');
    setTimeout(function () {
        document.registerForm.submit();
    }, 2000);

}); //E