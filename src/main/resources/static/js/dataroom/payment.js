$(function () {

//  체크박스 유효성 검사
    const payButton = $("#payButton");
    const chkList = $('input[type=checkbox]');
    const agreeAll = $("#checkAll");
    const privacyTerms = $("#privacyTerms");
    const serviceTerms = $("#serviceTerms");
    const chk = $(".checkBox");
    let chkboxCheck = false;

    //버튼 초기화
    payButton.attr('disabled', true);

    // checkbox => agreeAll
    agreeAll.click(function () {
        if ($(this).is(':checked')) {
            chk.prop('checked', true);
            chkboxCheck = true;
            console.log(chkboxCheck);
        } else {
            chk.prop('checked', false);
            chkboxCheck = false;
        }
        flagCheck();
    });

    // check list => All
    chk.click(function () {
        if ($('.checkBox:checked').length >= $('.checkBox').length) {
            agreeAll.prop('checked', true);
            chkboxCheck = true;
            console.log(chkboxCheck);
        } else {
            agreeAll.prop('checked', false);
            chkboxCheck = false;
        }
        flagCheck();
    });


    // flag check
    function flagCheck() {
        if (chkboxCheck) {
            console.log('gogo');
            payButton.attr('disabled', false);
        } else {
            console.log("nono");
            payButton.attr('disabled', true);
        }
    }






}); //E



