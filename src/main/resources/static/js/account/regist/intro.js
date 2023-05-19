$(function () {
    /* input tag + btns */
    let authentication = $('.authentication');
    let BtnAuthentication = $('.authentication-btn');
    let BtnReSend = $('.re_send_btn');
    let BtnSubmit = $('#btn_submit');

    let email = $('#email_input');
    let name = $('#nick_name');
    // let pwd = $('#password');
    // let inputs = $('#userName, #password');

    let modal = $('.ReactModalPortal');
    let BtnModalView = $('.btn_check_modal_view');
    let BtnModalClose = $('.btn_modal_close');

    BtnSubmit.attr('disabled', true);

    // 인증하는 부분 + 모달 숨기기
    $(BtnReSend).hide();
    $(authentication).hide();
    $(modal).hide();

    //   전체동의 모달 열기
    $(BtnModalView).on('click', function () {
        $(modal).show();
    });

    //   전체동의 모달 닫기
    $(BtnModalClose).on('click', function () {
        $(modal).hide();
    });

    // flag
    let emailCheck = false;
    let nameCheck = false;
    let pwdCheck = false;
    let rePwdCheck = false;
    let chkboxCheck = false;
    let nickNameCheck = false;
    let phoneNumberCheck = false;
    let emconfirmchk = false;

    // 이메일 유효성 검사
    var getMail = RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/);
    $('#email_input').on('keyup', function () {
        if ($(this).val() == '') {
            $(this).next('.help').html('이메일을 입력해주세요.');
            $(this).addClass('error');
            $('this').focus();
            $(BtnAuthentication).attr("disabled", true);
            emailCheck = false;
            return false;
        } else if (!getMail.test($('#email_input').val())) {
            $(this).next('.help').html('이메일에 형식에 맞게 입력해주세요.');
            $(this).addClass('error');
            $(BtnAuthentication).attr("disabled", true);
            emailCheck = false;
            return false;
        } else {
            $(this).next('.help').html('');
            $(this).removeClass('error');
            $(BtnAuthentication).attr("disabled", false);
            // $(BtnAuthentication).hide();
            // $(BtnReSend).show();
            // $(authentication).show();
            emailCheck = true;
            console.log(emailCheck);
            return false;
        }

        flagCheck();
    });

    // 인증번호 입력
/*    $('#authCode').on('keyup', function () {
        if ($(this).val().length == 6) {
            console.log($(this).val().length);
            $('#btn_check_mail').removeAttr('disabled');
        }
    });*/

    // 이름 유효성 검사
    $('#name').on('keyup', function () {
        if ($(this).val() == '') {
            $(this).next('.help').html('이름을 입력해주세요.');
            $(this).addClass('error');
            $(this).focus();
            nameCheck = false;
            return false;
        } else {
            $(this).next('.help').html('');
            $(this).removeClass('error');
            nameCheck = true;
            console.log(nameCheck);
            return false;
        }
        flagCheck();
    });
    // 닉네임
    $('#nick_name').on('keyup', function () {
        if ($(this).val() == '') {
            $(this).next('.help2').html('닉네임을 입력해주세요.');
            $(this).addClass('error');
            $(this).focus();
            nickNameCheck = false;
            return false;
        } else {
            $(this).next('.help2').html('');
            $(this).removeClass('error');
            nickNameCheck = true;
            console.log(nickNameCheck);
            return false;
        }
        flagCheck();
    });

    // 휴대폰 번호 검사
    $('#memberPhoneNumber').on('input', function () {
        let numericVal = $(this).val().replace(/[^0-9]/g, '');

        if (numericVal.length > 11) {
            numericVal = numericVal.substr(0, 11); // 최대 11자리까지만 유지
        }

        $(this).val(numericVal);
    });


    $('#memberPhoneNumber').on('keyup', function () {


        if ($(this).val() == '') {
            $(this).next('.help3').html('휴대폰 번호를 입력해주세요.');
            $(this).addClass('error');
            $(this).focus();
            phoneNumberCheck = false;
            return false;
        }else if(!fn_mbtlnumChk($(this).val())){
            $(this).next('.help3').html('휴대폰 번호를 양식에 맞게 입력 해주세요.');
            $(this).addClass('error');
            $(this).focus();
            phoneNumberCheck = false;
            return false;
        } else {
            $(this).next('.help3').html('');
            $(this).removeClass('error');
            phoneNumberCheck = true;
            return false;
        }


        flagCheck();
    });




    // let pwd = $('#password').val();

    // 비밀번호 정규식
    // let num = $input.val().search(/[0-9]/g);
    // let eng = $input.val().search(/[a-z]/gi);
    // let spe = $input.val().search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);

    // 패스워드 유효성 검사
    $('#memberPassword').on('keyup', function () {
        if ($(this).val() == '') {
            $(this).next('.help').html('비밀번호를 입력해주세요.');
            $(this).addClass('error');
            pwdCheck = false;
            $(this).focus();
            return false;
        } else if ($(this).val().length < 10 || $(this).val().length > 20) {
            $(this).next('.help').html('10자리 이상 20자리 이하로 입력해주세요.');
            $(this).addClass('error');
            $(this).focus();
            pwdCheck = false;
            return false;
        } else {
            $(this).next('.help').html('');
            $(this).removeClass('error');
            pwdCheck = true;
            console.log(pwdCheck);
            return false;
        }

        flagCheck();
    });

    // 패스워드 확인 유효성 검사
    $('#verifyPassword').on('keyup', function () {
        if ($(this).val() == '') {
            $(this).next('.help').html('비밀번호를 입력해주세요.');
            $(this).addClass('error');
            $(this).focus();
            rePwdCheck = false;
            return false;
        } else if ($(this).val() != $('#memberPassword').val()) {
            $(this).next('.help').html('비밀번호가 일치하지 않습니다.');
            $(this).addClass('error');
            $(this).focus();
            rePwdCheck = false;
            return false;
        } else {
            $(this).next('.help').html('');
            $(this).removeClass('error');
            rePwdCheck = true;
            console.log(rePwdCheck);
            return false;
        }

        flagCheck();
    });

    /* 패스워드 svg 변경 및 text 보이기 */
    let firstsvg = $('.firstsvg');
    let secondsvg = $('.secondsvg');
    let checkfirstsvg = $('.checkfirstsvg');
    let checksecondsvg = $('.checksecondsvg');

    $(secondsvg).hide();
    $(checksecondsvg).hide();

    $(firstsvg).on('click', function () {
        $(firstsvg).hide();
        $(secondsvg).show();
        $('#memberPassword').prop('type', 'text');
    });

    $(secondsvg).on('click', function () {
        $(firstsvg).show();
        $(secondsvg).hide();
        $('#memberPpassword').prop('type', 'password');
    });

    $(checkfirstsvg).on('click', function () {
        $(checkfirstsvg).hide();
        $(checksecondsvg).show();
        $('#verifyPassword').prop('type', 'text');
    });

    $(checksecondsvg).on('click', function () {
        $(checkfirstsvg).show();
        $(checksecondsvg).hide();
        $('#verifyPassword').prop('type', 'password');
    });

    // 체크박스 활성화
    const chkList = $('input[type=checkbox]');
    const chk = $('.chk');
    const essentialChk = $('.essential_chk');
    const agreeAll = $('#termsUpdateRequestCheckBox');
    const btn_modal_agree = $('#btn_modal_agree');
    const fullAgreement = $('input[name=fullAgreement]');

    // madal btn 비활성화
    btn_modal_agree.attr('disabled', true);

    // checkbox => agreeAll
    agreeAll.click(function () {
        console.log('agreeAll');
        if ($(this).is(':checked')) {
            chkList.prop('checked', true);
            chkboxCheck = true;
            console.log(chkboxCheck);
            btn_modal_agree.attr('disabled', false);
        } else {
            chkList.prop('checked', false);
            chkboxCheck = false;
            btn_modal_agree.attr('disabled', true);
        }

        flagCheck();
    });

    // modal checkbox => fullAgreement
    fullAgreement.click(function () {
        console.log('fullAgreement');
        if ($(this).is(':checked')) {
            chkList.prop('checked', true);
            chkboxCheck = true;
            console.log(chkboxCheck);
            btn_modal_agree.attr('disabled', false);
        } else {
            chkList.prop('checked', false);
            chkboxCheck = false;
            btn_modal_agree.attr('disabled', true);
        }
        flagCheck();
    });

    // check list => select
    $('.chk').change(function () {
        if ($('.chk:checked').length >= $('.chk').length) {
            agreeAll.prop('checked', true);
            fullAgreement.prop('checked', true);
            chkboxCheck = true;
            console.log(chkboxCheck);
            btn_modal_agree.attr('disabled', false);
        } else {
            agreeAll.prop('checked', false);
            fullAgreement.prop('checked', false);
            chkboxCheck = false;
            btn_modal_agree.attr('disabled', true);
        }
        flagCheck();
    });

    // essential check list => select
    essentialChk.change(function () {
        if ($('.essential_chk:checked').length >= essentialChk.length) {
            btn_modal_agree.attr('disabled', false);
            chkboxCheck = true;
            console.log(chkboxCheck);
        } else {
            btn_modal_agree.attr('disabled', true);
            chkboxCheck = false;
        }
        flagCheck();
    });

    // madal btn
/*
    btn_modal_agree.click(function () {
        $(modal).hide();
    });
*/

    function fn_mbtlnumChk(mbtlnum){
        var regExp = /^010\d{8}$/;
        if(!regExp.test(mbtlnum)){
            return false;
        }
        return true;
    }


    // flag check
    function flagCheck() {
        if (emconfirmchk && emailCheck && nameCheck && pwdCheck && rePwdCheck && chkboxCheck && nickNameCheck && phoneNumberCheck) {
            console.log('gogo');
            BtnSubmit.attr('disabled', false);
        } else {
            BtnSubmit.attr('disabled', true);
        }
    }




    //

    //중복확인 버튼클릭 이벤트
    $(BtnAuthentication).on("click", () => {
        $.ajax({
            type  : "POST",
            url : "check-id",
            data : {"memberId" : $("#email_input").val()},
            dataType: "json",
            success : function (member) {
                    if(member == null){
                        showWarnModal("사용가능한 아이디입니다");
                        $(BtnAuthentication).hide();
                        $(BtnReSend).show();
                        $(authentication).show();
                        email.attr("readOnly", true);
                        $('#authCode').attr("readOnly", true);
                    } else {
                        showWarnModal("중복된 아이디입니다.");
                    }
            }

        })
            });

    // 이메일 발송
    $('.email-submit').on("click",()=>{
        $.ajax({
            type : "POST",
            url : "mail-confirm",
            data : {
                "memberId" : $('#email_input').val()
            },
            success : function(data){
                $('.warn-modal').css("width", "350px");
                showWarnModal(`<span>해당 이메일로 인증번호 발송이 완료되었습니다.</span><br/> <span>확인부탁드립니다.</span>`);
                $('#btn_check_mail').removeAttr('disabled');
                $('#authCode').attr("readOnly", false);
                console.log("data : "+data);
                chkEmailConfirm(data);
            }
        })

    })

    // 이메일 인증번호 체크 함수
    function chkEmailConfirm(data){
        $('#btn_check_mail').on("click", function(){
            if (data != $('#authCode').val()) { //
                emconfirmchk = false;
                showWarnModal(`<span>인증번호가 잘못되었습니다</span>`);
            } else {
                emconfirmchk = true;
                showWarnModal(`<span>인증번호가 확인완료</span>`);
                $('#authCode').attr("readOnly", true);
                $(this).attr("disabled", true);
                flagCheck();
            }
        })
    }




    //
}); //E
