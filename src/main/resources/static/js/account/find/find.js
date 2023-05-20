$(function () {
    /*이메일 입력창 태그*/
    let email = $('#memberId');
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
    // $('#btnIsJoinedEmail').on('click', function () {
    //     $(this).closest('.id-check').hide();
    //     $(this).closest('.id-check').next('.id-result').show();
    // });

    //   pwd - btn click event
    // $('#BtnSendlink').on('click', function () {
    //     $('.pwd_modal').show();
    //     console.log('나타나라 모달');
    // });

    // 모달 닫기
    $(closeBtns).on('click', function () {
        $('.pwd_modal').hide();
        console.log('사라져 모달');
    });


    //아이디찾기
    $('#btnIsJoinedEmail').on("click", function () {
        $.ajax({
            type: "POST",
            url: "/accounts/check-id",
            data: {"memberId": $("#memberId").val()},
            success: function (data) {
                if (data != null) {
                    $('.page-body').html(`
                                             <div class="wz container id-result" style="display: block;">
                                        <div class="isJoin-email-wrap">
                                        <p id="inputedEmail" class="wz text headline2">${$("#memberId").val()}</p>
                                        <p id="joinedEmail" class="wz text body1" style="display: block;">회원으로 등록된 이메일 아이디입니다.<br>해당 이메일로 로그인하고 와디즈를 이용하세요!
                                        </p>
                                        <div class="inner-container">
                                        <a id="goToLogin" class="wz primary block button" href="/accounts/login" style="display: inline-block;">로그인</a>
                                      <a id="btn-recheck" class="wz block button" href="/accounts/find/id">다시 확인</a>
                                        </div>
                                        </div>
                                        </div>
                        `)
                } else {
                    $('.page-body').html(`
                          <div cl
                        <div class="wz container id-result" style="display: block;">
                                        <div class="isJoin-email-wrap">
                                        <p id="inputedEmail" class="wz text headline2">${$("#memberId").val()}</p>
                                        </p>
                                        <p id="notJoinedEmail" class="wz text body1" style="display: block;">는 와디즈에 등록되어 있지 않은 계정입니다.</p>
                                        <div class="inner-container">
                                        <a id="goToJoin" class="wz primary block button" href="/accounts/register" style="display: block;">회원가입하기</a>
                                        <a id="btn-recheck" class="wz block button" href="/accounts/find/id">다시 확인</a>
                                        </div>
                                        </div>
                                        </div>
                    `)
                }
            }
        });
        });


    // 비밀번호 찾기
    $('#BtnSendlink').on("click", function () {
        $.ajax({
            type: "POST",
            url: "/accounts/check-id",
            data: {"memberId": $("#memberId").val()},
            success: function (data) {
                       if(data.memberLoginStatus == 'KAKAO' || data.memberLoginStatus == 'NAVER'){
                           showWarnModal(`<span> SNS 연동계정입니다.</span>`)
                           return;
                       }

                if (data != null) {
                    console.log(data);
                    console.log(data.id);
                    $.ajax({
                        type : "POST",
                        url : "/accounts/change-pw",
                        data : {
                            "memberId" : $('#memberId').val(),
                            "id" : data.id
                        },
                        success : function(){
                                $('.warn-modal').css("width", "350px");
                                showWarnModal(`<span>이메일로 비밀번호 재설정 주소를 발송하였습니다.</span>`)
                        }
                    })
                } else {
                    showWarnModal(`<span>등록되지 않은 아이디입니다.</span>`)
                    $('#notJoinedEmail').css("display", "block");
                }
            }
        });
    });

    }); //E
