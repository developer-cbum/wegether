$(function () {
    // 비밀번호 정규식
    // let num = $input.val().search(/[0-9]/g);
    // let eng = $input.val().search(/[a-z]/gi);
    // let spe = $input.val().search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);


    let pwFlag = false;
    let rePwFlag =false;

    // 패스워드 유효성 검사
    $('#memberPassword').on('keyup', function () {
        console.log("검사");
        if ($(this).val() == '') {
            $(this).next('.help').html('비밀번호를 입력해주세요.');
            $(this).addClass('error');
            $(this).focus();
            pwFlag = false;
            checkFlag()
            return false;
        } else if ($(this).val().length < 10 || $(this).val().length > 20) {
            $(this).next('.help').html('10자리 이상 20자리 이하로 입력해주세요.');
            $(this).addClass('error');
            $(this).focus();
            pwFlag = false;
            checkFlag()
            return false;
        } else {
            $(this).next('.help').html('');
            $(this).removeClass('error');
            pwFlag = true;
            checkFlag()
            return false;
        }
        checkFlag()
    });

    // 패스워드 확인 유효성 검사
    $('#verifyPassword').on('keyup', function () {

        if ($(this).val() == '') {
            $(this).next('.help').html('비밀번호를 입력해주세요.');
            $(this).addClass('error');
            $(this).focus();
            rePwFlag=false;
            checkFlag()
            return false;
        } else if ($(this).val() != $('#memberPassword').val()) {
            console.log("확인 검사");
            $(this).next('.help').html('비밀번호가 일치하지 않습니다.');
            $(this).addClass('error');
            $(this).focus();
            rePwFlag=false;
            checkFlag()
            return false;
        } else {
            $(this).next('.help').html('');
            $(this).removeClass('error');
            rePwFlag = true;
            checkFlag()
            return false;
        }
        checkFlag()
    });


    function checkFlag() {
        if(pwFlag && rePwFlag){ $('.reset-password__submit').attr("disabled", false);
        }else{
            $('.reset-password__submit').attr("disabled", true);
        }


    }


}); //E
