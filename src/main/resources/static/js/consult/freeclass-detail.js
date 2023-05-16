
const cancel = document.querySelector('.alertify-o-button-cancel');
const confirm = document.querySelector('.alertify-o-button-ok');
const lastok = document.querySelector('.lastok');



function selectTab(num) {
  var tabnum = num - 1;
  $('.tab-con').hide();
  $('#tab-con' + num).show();
  $('.school-tab> li').removeClass('tab-on');
  $('.school-tab > li:eq(' + tabnum + ')').addClass('tab-on');
}


// 신청 form
function applySchool() {
  console.log('여기도');

  $('.black-bg-wrap').show();
  $('.sch-payment-wrap').show();
  $('body').css('position', 'fixed').css('width', '100%');
  $('#schoolForm-3').show();

  console.log('들어옴');
}

// 신청 완료
function completePay() {
  // $('body').css('position', 'relative').css('width', '100%');
  $('.done-info').show();
  $('.registeryet').hide();
  $('.school-value').hide();
  $('.lect-val-num').hide();
  $('.registercom').show();
  $('.black-bg-wrap').hide();
  $('.sch-payment-wrap').hide();
  $('body').css('position', 'static').css('width', '100%');
  $('#schoolForm-3').hide();
}


// 신청 취소 버튼
function cancelApply() {
  $('.alertify-o-cover1').show();
  $('.alertify-o-confirm').show();
}



// 취소 안하기
cancel.addEventListener('click', () => {
  $('.alertify-o-cover1').hide();
  $('.alertify-o-confirm').hide();
});

// 취소 하기
confirm.addEventListener('click', () => {
  $('.alertify-o-confirm').hide();
  $('.alertify-o-cover1').hide();
  $('.alertify-o-cover2').show();
  $('.lastcheck').show();
  
});

// 취소 완료
lastok.addEventListener('click', () => {
  $('.registeryet').show();
  $('.done-info').hide();
  $('.registercom').hide();
  $('.registeryet').show();
  $('.alertify-o-cover2').hide();
  $('.lastcheck').hide();
  $('.long set-num').show();
  $('.numOnly').show();
  $('.school-value').show();
  
});