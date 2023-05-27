/*이메일 유효성검사 함수*/
function fn_emailChk(email) {
  let regExp = /\w+([-+.]\w+)*@\w+([-.]\w+)*\.[a-zA-Z]{1,4}$/;
  if (!regExp.test(email)) {
    return false;
  }
  return true;
}

/*휴대폰 유효성검사*/
function fn_mbtlnumChk(mbtlnum) {
  let phoneExp = /^(?:(010\d{4})|(01[1|6|7|8|9]\d{3,4}))(\d{4})$/;
  if (!phoneExp.test(mbtlnum)) {
    return false;
  }
  return true;
}

// 이메일 input 키업
$('#userName').keyup(function () {
  if (!fn_emailChk($('#userName').val())) {
    $('#emailError').css('display', 'block');
  } else {
    $('#emailError').css('display', 'none');
  }

  if ($('#emailError').css('display') == 'block') {
    $('#emailCheckBtn').css('backgroundColor', '#e1deda');
    $('.email-change-button').attr('disabled', true);
  } else {
    $('.email-change-button').removeAttr('disabled');
    $('#emailCheckBtn').css('backgroundColor', '#8c8881');
  }
});

//핸드폰
$('#mobileNumber').keyup(function () {
  if (!fn_mbtlnumChk($('#mobileNumber').val())) {
    $('#phoneError').css('display', 'block');
  } else {
    $('#phoneError').css('display', 'none');
  }

  if ($('#phoneError').css('display') == 'block') {
    $('#mobileCheckBtn').css('backgroundColor', '#e1deda');
    $('.mobile-change-button').attr('disabled', true);
  } else {
    $('.mobile-change-button').removeAttr('disabled');
    $('#mobileCheckBtn').css('backgroundColor', '#8c8881');
  }
});

// email 변경버튼
$('#emailChangeBtn').on('click', function () {
  $(this).css('display', 'none');
  $('#emailCheckBtn').css('display', 'block');
  $('#userName').val('');
  $('#userName').prop('disabled', false);
});

//모바일 변경버튼

$('#mobileChangeBtn').on('click', function () {
  $(this).css('display', 'none');
  $('#mobileCheckBtn').css('display', 'block');
  $('#mobileNumber').val('');
  $('#mobileNumber').prop('disabled', false);
  $('#mobileNumber').removeAttr('readOnly');
});

// 이메일 변경하기 버튼
$('.email-change-button').on('click', function () {
  if ($('.email-change-button').attr('disabled', true)) {
    $('#verify-next').css('display', 'none');
    $('#alertify-o-cover').css('display', 'block');
    $('#alertify-o').css('display', 'block');
  }
});

//모바일 변경하기버튼
$('.mobile-change-button').on('click', function () {
  if ($('.mobile-change-button').attr('disabled', true)) {
    $('#verify-next').css('display', 'none');
    $('#alertify-o-cover').css('display', 'block');
    $('#alertify-o').css('display', 'block');
  }
});

//모달 확인창
$('#alertify-o-ok').on('click', function () {
  $('#emailCheckBtn').css('backgroundColor', '#e1deda');
  $('#mobileCheckBtn').css('backgroundColor', '#e1deda');
  $('#emailChangeBtn').css('display', 'block');
  $('#mobileChangeBtn').css('display', 'block');
  $('#emailCheckBtn').css('display', 'none');
  $('#mobileCheckBtn').css('display', 'none');
  $('#verify-step2').css('display', 'block');
  $('#alertify-o-cover').css('display', 'none');
  $('#alertify-o').css('display', 'none');
});


// $('.kakao-button').on("click",function () {
//   console.log("카카오 버튼 들어옴");
//
//   location.href="https://kauth.kakao.com/oauth/authorize?client_" +
//       "id=4d189f87999895c1fba5bb291861d41d&redirect_uri=http://localhost:10000/login&response_type=code";
// })