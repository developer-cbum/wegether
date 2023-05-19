
let $memberName = $("#memberName");
let $memberNickname = $("#memberNickname");
let $memberPhoneNumber = $("#memberPhoneNumber");
let $BtnSubmit = $("#btn_submit");

let nameCheck = false;
let nickNameCheck = false;
let phoneNumberCheck = false;


// 이름 유효성 검사
$('#memberName').on('keyup', function () {
    if ($(this).val() == '') {
        $(this).next('.help').html('이름을 입력해주세요.');
        $(this).addClass('error');
        $(this).focus();
        nameCheck = false;
        flagCheck();
        return false;
    } else {
        $(this).next('.help').html('');
        $(this).removeClass('error');
        nameCheck = true;
        console.log(nameCheck);
        flagCheck();
        return false;
    }
    flagCheck();
});
// 닉네임
$('#memberNickname').on('keyup', function () {
    if ($(this).val() == '') {
        $(this).next('.help2').html('닉네임을 입력해주세요.');
        $(this).addClass('error');
        $(this).focus();
        nickNameCheck = false;
        flagCheck();
        return false;
    } else {
        $(this).next('.help2').html('');
        $(this).removeClass('error');
        nickNameCheck = true;
        console.log(nickNameCheck);
        flagCheck();
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
        flagCheck();
        return false;
    }else if(!fn_mbtlnumChk($(this).val())){
        $(this).next('.help3').html('휴대폰 번호를 양식에 맞게 입력 해주세요.');
        $(this).addClass('error');
        $(this).focus();
        phoneNumberCheck = false;
        flagCheck();
        return false;
    } else {
        $(this).next('.help3').html('');
        $(this).removeClass('error');
        phoneNumberCheck = true;
        flagCheck();
        return false;
    }

    flagCheck();
});

// flag check
function flagCheck() {
    if ( nameCheck &&  nickNameCheck && phoneNumberCheck) {
        console.log('gogo');
        $BtnSubmit.attr('disabled', false);
    } else {
        $BtnSubmit.attr('disabled', true);
    }


}

function fn_mbtlnumChk(mbtlnum){
    var regExp = /^010\d{8}$/;
    if(!regExp.test(mbtlnum)){
        return false;
    }
    return true;
}