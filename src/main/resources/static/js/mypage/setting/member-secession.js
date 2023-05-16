const $selectOption = $('#selectDropOutReason option');

$selectOption.each((i, el) => {
  $(this)
    .eq(i)
    .on('click', function () {
      $('.selectReason').text(`${$('#selectDropOutReason option:checked').text()}`);
    });
});

$('#selectDropOutReason').on('change', function () {
  if ($(this).val() == 'etc') {
    $('.reason-text').css('display', 'block');
  } else {
    $('.reason-text').css('display', 'none');
  }
});

// 본인확인하기 버튼 클릭

$('#verify-next').on('click', function () {
  $('#verify-next').css('display', 'none');
  $('#alertify-o-cover').css('display', 'block');
  $('#alertify-o').css('display', 'block');
});

$('#alertify-o-ok').on('click', function () {
  $('#verify-step2').css('display', 'block');
  $('#alertify-o-cover').css('display', 'none');
  $('#alertify-o').css('display', 'none');
});

if ($('#selectDropOutReason option:selected') && $('#dropConfirm').prop('checked')) {
  console.log('들어옴');
  $('#btnDropOut').prop('disable', 'none');
}

$('#verify-confirm').on('click', function () {
  if ($('#code').val().length == 6 && $("#dropConfirm").prop("checked")) {
    console.log('들어옴');
    $('#btnDropOut').attr('disabled', false);
  }
});
