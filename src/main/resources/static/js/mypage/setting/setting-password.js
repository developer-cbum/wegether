

const $oldPasswordInput=$('#oldPassword');






// form 태그
const $form = $('#saveform');

// input 비밀번호 태그들
const $input = $('input[type=password]');
// 버튼
const $button = $('#saveBtn');

// 현재 비밀번호 오류 메세지
const $oldPassword = $('#oldPassword-error');

// 새 비밀번호 오류 메세지1
const $newPasswordError = $('#newPassword-error');
// 새 비밀번호 오류 메세지2
const $pwdText = $('p.pwd-text');

// 비밀번호 재확인 에러메세지1
const $newPasswordConfirmError = $('#newPasswordConfirm-error');
// 비밀번호 재확인 에러메세지2
const $error = $('.not-same');

/* 테두리 효과 */
$input.on('focus', function () {
  if ($(this).val().length == 0) {
    $(this).css('border', '1px solid rgb(208, 2, 27)');
  } else {
    $(this).css('border', '1px solid #50e3c2');
  }
});

//-----------------------------------------------

// blur

//첫번째


$input.eq(0).on('blur', function() {
    console.log("eq0들어옴")
  $.ajax({
    url:"compare",
    success:function (data) {
          console.log("ajax 들어옴")
          console.log(data);
          if(data==$oldPasswordInput.val()){
            $input.eq(0).css('border', '1px solid #e4e4e4');
            $oldPassword.css('display', 'none');
          }

          else{
            $input.eq(0).css('border', '1px solid rgb(208, 2, 27)');
            $oldPassword.css('display', 'block');
          }
    }


  })


})

$input.eq(0).on('blur', function () {
  if ($input.eq(0).val().length == 0) {
    $input.eq(0).css('border', '1px solid rgb(208, 2, 27)');
    $oldPassword.css('display', 'block');
  } else {
    $input.eq(0).css('border', '1px solid #e4e4e4');
    $oldPassword.css('display', 'none');
  }
});

//두번째
$input.eq(1).on('blur', function () {
  // 비밀번호 정규식
  let num = $input.eq(1).val().search(/[0-9]/g);
  let eng = $input.eq(1).val().search(/[a-z]/gi);
  let spe = $input
    .eq(1)
    .val()
    .search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);

  if (num < 0 || eng < 0 || spe < 0) {
    $input.eq(1).css('border', '1px solid rgb(208, 2, 27)');
    $pwdText.css('color', 'rgb(208, 2, 27)');
  } else {
    $input.eq(1).css('border', '1px solid #e4e4e4');
    $pwdText.css('color', '#rgb(74, 74, 74)');
  }

  if ($input.eq(1).val().length == 0) {
    $input.eq(1).css('border', '1px solid rgb(208, 2, 27)');
    $newPasswordError.css('display', 'block');
  } else {
    $input.eq(1).css('border', '1px solid #e4e4e4');
    $newPasswordError.css('display', 'none');
  }
});

//세번째
$input.eq(2).on('blur', function () {
  if ($input.eq(2).val().length == 0) {
    $input.eq(2).css('border', '1px solid rgb(208, 2, 27)');
    $newPasswordConfirmError.css('display', 'block');
  } else {
    $input.eq(2).css('border', '1px solid #e4e4e4');
    $newPasswordConfirmError.css('display', 'none');
  }
});

//-----------------------------------

// keyup

//첫번째
$input.eq(0).on('keyup', function () {
  if ($input.eq(0).val().length == 0) {
    $input.eq(0).css('border', '1px solid rgb(208, 2, 27)');
    $oldPassword.css('display', 'block');
    $oldPassword.css('color', 'rgb(208, 2, 27)');
    return;
  } else {
    $input.eq(0).css('border', '1px solid #50e3c2');
    $oldPassword.css('display', 'none');
    return;
  }
});

//두번째
$input.eq(1).on('keyup', function () {
  // 비밀번호 정규식
  let num = $input.eq(1).val().search(/[0-9]/g);
  let eng = $input.eq(1).val().search(/[a-z]/gi);
  let spe = $input
    .eq(1)
    .val()
    .search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);

  if ($input.eq(1).val().length == 0) {
    $input.eq(1).css('border', '1px solid rgb(208, 2, 27)');
    $newPasswordError.css('display', 'block');
    $newPasswordError.css('color', 'rgb(208, 2, 27)');
  } else {
    $input.eq(1).css('border', '1px solid #50e3c2');
    $newPasswordError.css('display', 'none');
  }

  //정규식검사
  if (num < 0 || eng < 0 || spe < 0) {
    $input.eq(1).css('border', '1px solid rgb(208, 2, 27)');
    $pwdText.css('color', 'rgb(208, 2, 27)');
  } else {
    $input.eq(1).css('border', '1px solid #50e3c2');
    $pwdText.css('color', 'rgb(74, 74, 74)');
  }
});

// 세번째
$input.eq(2).on('keyup', function () {
  if ($input.eq(2).val().length < 8) {
    $input.eq(2).css('border', '1px solid rgb(208, 2, 27)');
    $newPasswordConfirmError.css('display', 'block');
    $newPasswordConfirmError.css('color', 'rgb(208, 2, 27)');
  } else {
    $input.eq(2).css('border', '1px solid #50e3c2');
    $newPasswordConfirmError.css('display', 'none');
  }
});

// ------------------------------------

// 버튼 눌렀을 때 유효성 검사

$button.on('click', function () {

  console.log("버튼 클릭");

  // 비밀번호 정규식
  let num = $input.eq(1).val().search(/[0-9]/g);
  let eng = $input.eq(1).val().search(/[a-z]/gi);
  let spe = $input
    .eq(1)
    .val()
    .search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);

  // 현재 비밀번호
  if ($input.eq(0).val().length == 0) {
    $input.eq(0).css('border', '1px solid rgb(208, 2, 27)');
    $oldPassword.css('display', 'block');
    $oldPassword.css('color', 'rgb(208, 2, 27)');
    return;
  } else {





    $input.eq(0).css('border', '1px solid #e4e4e4');
    $oldPassword.css('display', 'none');
  }

  // 새비밀번호
  if (num < 0 || eng < 0 || spe < 0) {
    $input.eq(1).css('border', '1px solid rgb(208, 2, 27)');
    $pwdText.css('color', 'rgb(208, 2, 27)');
    return;
  } else {
    $input.eq(1).css('border', '1px solid #e4e4e4');
    $pwdText.css('color', 'rgb(74, 74, 74)');
  }

  if ($input.eq(1).val().length < 8) {
    $newPasswordError.css('display', 'block');
    $input.eq(1).css('border', '1px solid rgb(208, 2, 27)');
    return;
  } else {
    $newPasswordError.css('display', 'none');
  }

  // 새 비밀번호 확인
  if ($input.eq(2).val().length < 8) {
    $newPasswordConfirmError.eq(2).css('display', 'block');
    $newPasswordConfirmError.eq(2).text('비밀번호는 최소 8자리 이상입니다.');
    $input.eq(2).css('border', '1px solid rgb(208, 2, 27)');
    return;
  } else {
    $newPasswordConfirmError.eq(2).css('display', 'none');
    $newPasswordConfirmError.eq(2).text('');
    $input.eq(2).css('border', '1px solid #e4e4e4');
  }

  // 불일치
  if ($input.eq(1).val() != $input.eq(2).val()) {
    console.log('들어옴');
    $error.css('display', 'block');
    $error.css('color', 'rgb(208, 2, 27)');
    return;
  } else {
    $error.css('display', 'none');
  }

  //확인차원 submit 나중에 수정해야함
  $form.submit();
});
