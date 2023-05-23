$(function () {

    history.replaceState({}, null, location.pathname);

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

    function check() {
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
    }

    // 저장완료 모달
    // showWarnModal('등록이 완료되었습니다');
    // setTimeout(function () {
        // check();
        // document.registerForm.submit();
    // }, 2000);



//    select box
    $("#dataMajor-div").on('click', function () {
        $(".select-menu__menu").toggle();

    });

    // input 처럼 div 사용하기
    let $majorInput = $("#dataMajor");
    let $majorDiv = $("#dataMajor-div");

    $(".select_category a").on("click", function(){
        console.log('value:   '+$(this).val() + " text:   " + $(this).text());

        $majorInput.val($(this).val());
        $majorDiv.text($(this).text()).css("color", "#212529");
        $(".select-menu__menu").hide();
    });




    // 카테고리 이름 변경
    // $(function() {
    // $(".computer a").text("컴퓨터공학과");
    // $(".design a").text("디자인학과");
    // $(".sports a").text("스포츠과학과");
    // $(".biology a").text("생명과학과");
    // $(".chemistry a").text("화학과");
    // $(".machine a").text("기계공학과");
    // $(".engineering a").text("전기공학과");
    // $(".math a").text("수학과");
    // $(".media a").text("미디어영상학과");
    // $(".applied_music a").text("실용음악과");
    // });

}); //E