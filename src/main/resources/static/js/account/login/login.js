$(function () {
    /* input + btns */
    let email = $('#memberId');
    let pwd = $('#memberPassword');
    let inputs = $('#memberId, #memberPassword');
    let loginBtn = $('#btnLogin');

    // 이메일 유효성 검사
    function fn_emailChk(email) {
        var regExp = /\w+([-+.]\w+)*@\w+([-.]\w+)*\.[a-zA-Z]{2,4}$/;
        if (!regExp.test(email)) {
            return false;
        }
        return true;
    }

    //   email input blur event
    email.on('focus', function () {
        email.blur(function (e) {
            if ($(e.target).val() == '') {
                $(this).addClass('error');
                $('#emailError').show();
            } else if (!fn_emailChk($(e.target).val())) {
                $(this).addClass('error');
                $('#emailError').show();
            } else {
                $(this).removeClass('error');
                $('#emailError').hide();
            }
        });
    });

    //   login btn click error event
    $(loginBtn).on('click', function () {
        let value = $(pwd).val();
        if (!value) {
            $(inputs).addClass('error');
            $('#loginError').show();
        }
    });

    // pwd focus
    pwd.on('focus', function () {
        $(this).removeClass('error');
        $('#loginError').hide();
    });



}); //E
