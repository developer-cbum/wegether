$(function () {
    /*이메일 입력창 태그*/
    let email = $('#userName');
    let btn = $('#btnIsJoinedEmail , #BtnSendlink');
    let closeBtns = $('.close_btn');

    /* btns 처음 초기값 : disabled */
    btn.attr('disabled', 'disabled');

    // 이메일 유효성 검사
    function fn_emailChk(email) {
        var regExp = /\w+([-+.]\w+)*@\w+([-.]\w+)*\.[a-zA-Z]{2,4}$/;
        if (!regExp.test(email)) {
            return false;
        }
        return true;
    }

    //   input blur event
    email.on('focus', function () {
        email.blur(function (e) {
            if ($(e.target).val() == '') {
                $(this).addClass('error');
                $('#emailError').show();
            } else if (!fn_emailChk($(e.target).val())) {
                $(this).addClass('error');
                $('#emailError').show();
            } else {
                console.log('버튼 살려줘');
                btn.removeAttr('disabled');
                $(this).removeClass('error');
                $('#emailError').hide();
            }
        });
    });

    //   id - btn click event
    $('#btnIsJoinedEmail').on('click', function () {
        $(this).closest('.id-check').hide();
        $(this).closest('.id-check').next('.id-result').show();
    });

    //   pwd - btn click event
    $('#BtnSendlink').on('click', function () {
        $('.pwd_modal').show();
        console.log('나타나라 모달');
    });

    // 모달 닫기
    $(closeBtns).on('click', function () {
        $('.pwd_modal').hide();
        console.log('사라져 모달');
    });
}); //E
