
const $upload = $("input.upload");
const $thumbnail = $("label.attach img.thumbnail");

$("img.preview").each(function(i){
    if(!$(this).attr("src")){
        $(this).hide();
    }});

let sizes = new Array();
$upload.on("change", function(e){
    let i = $upload.index($(this));
    let files = $(this)[0].files;
    let name = files[0].name;
    let formData = new FormData();

    sizes.push(files[0].size);

    $(files).each((i, file) => {
        formData.append("uploadFile", file);
    });

    $.ajax({
        url: "/files/upload",
        type: "post",
        data: formData,
        contentType: false,
        processData: false,
        success: function(uuids){
            $(".file_upload_btn").hide();
            $("div.x").eq(i).show();
            $("img.thumbnail").eq(i).show();

            let now = new Date();
            let year = now.getFullYear();
            let month = now.getMonth() + 1;
            let date = now.getDate();

            month = month < 10 ? "0" + month : month;
            date = date < 10 ? "0" + date : date;

            let fileName = year + "/" + month + "/" + date + "/t_" + uuids[0] + "_" + name;
            $("img.thumbnail").eq(i).attr("src", `/files/display?fileName=${fileName}`);
        }
    });

});

$("div.x").on("click", function(e){
    e.preventDefault();
    let i = $("div.x").index($(this));
    sizes = sizes.splice(i, 1);
    $upload.eq(i).val("");
    $(".file_upload_btn").show();
    // $("label.attach").eq(i).find("h6").show();
    $("div.x").eq(i).hide();
    $thumbnail.eq(i).attr('src', "");
    $thumbnail.eq(i).hide();
});

$("button.ok-button").on("click", function(){
    const imgs = $("img.thumbnail").filter((i, img) => $(img).attr("src"));
    let text = ``;
    imgs.each((i, img) => {
        let fullPath = $(img).attr("src");
        let datas = fullPath.split("_");
        let filePath = datas[0].split("=")[1].replace("/t", "");
        let fileUuid = datas[1];
        let fileName = datas[2];
        let fileSize = sizes[i];

        text += `
            <input type="hidden" name="files[${i}].filePath" value="${filePath}">
            <input type="hidden" name="files[${i}].fileUuid" value="${fileUuid}">
            <input type="hidden" name="files[${i}].fileName" value="${fileName}">
            <input type="hidden" name="files[${i}].fileSize" value="${fileSize}">
        `

        // 저장완료 모달
        showWarnModal('등록이 완료되었습니다');
        setTimeout(function () {
            check();
            document.registerForm.submit();
        }, 2000);

    });
    $(writeForm).append(text);
    $(writeForm).submit();



    $(function () {

        $(".ok-button").attr('disabled', true);
        history.replaceState({}, null, location.pathname);

        <!-- 모달 부분 js -->

        let modalCheck;
        function showWarnModal(modalMessage) {
            modalCheck = false;
            $('div#content-wrap').html(modalMessage);
            $('div.warn-modal').css('animation', 'popUp 0.5s');
            $('div.modal').css('display', 'flex').hide().fadeIn(500);
            setTimeout(function () {
                modalCheck = true;
            }, 300);
        }

        $('div.modal').on('click', function () {
            if (modalCheck) {
                $('div.warn-modal').css('animation', 'popDown 0.5s');
                $('div.modal').fadeOut(500);
            }
        });


        <!-- 유효성 검사 -->
        <!-- 여기 부분 다른 곳 작업 끝나면 유효성 검사 추가 -->
        let schoolCheck = false;
        let majorCheck = false;
        let contentCheck = false;

        $('#projectSchool').on('keyup', function () {
            // 자료 출처(학교)
            if ($(this).val() == '') {
                showWarnModal('자료 출처(학교)를 입력해주세요');
                document.writeForm.dataSchool.focus();
                schoolCheck = false;
                flagCheck();
                return false;
            } else {
                schoolCheck = true;
                flagCheck();
                return false;
            }
            flagCheck();
        });

        $('#projectMajor').on('keyup', function () {
            // 자료 출처(전공)
            if ($(this).val() == '') {
                showWarnModal('자료 출처(전공)을 입력해주세요');
                document.writeForm.projectMajor.focus();
                majorCheck = false;
                flagCheck();
                return false;
            }
            // else {
            //     console.log("major pass");
            //     majorCheck = true;
            //     return;
            // }
            flagCheck();
        });

        $('#projectContent').on('keyup', function () {
            console.log("들어는 옴");
            // 자료 내용 유효성 검사
            if ($(this).val() == '') {
                console.log("여기는 실패");
                showWarnModal('자료 내용을 입력해주세요');
                document.writeForm.dataContent.focus();
                contentCheck = false;
                flagCheck();
                return false;
            } else {
                console.log("여기는 성공");
                contentCheck = true;
                console.log("자료내용 체크 : " + contentCheck);
                flagCheck();
                return false;
            }
            flagCheck();
        });



//    select box
        $("#projectMajor-div").on('click', function () {
            $(".select-menu__menu").toggle();

        });

        // major div - input 처럼 사용하기
        let $majorInput = $("#projectMajor");
        let $majorDiv = $("#projectMajor-div");

        $(".select_category a").on("click", function(){
            // console.log('data:   '+$(this).data());
            console.log('value:   '+$(this).data("value"));
            console.log("text:   " + $(this).text());

            $majorInput.val($(this).project("value"));
            // dataMajor.val($(this).val());
            $majorDiv.text($(this).text()).css("color", "#212529");
            $(".select-menu__menu").hide();
            majorCheck = true;
            flagCheck();
        });


        // flag check
        function flagCheck() {

            console.log("school" + schoolCheck);
            console.log("major" + majorCheck);
            console.log("content" + contentCheck);
            if (titleCheck && priceCheck && schoolCheck && majorCheck && contentCheck) {
                console.log('gogo');
                $(".ok-button").attr('disabled', false);
            } else {
                $(".ok-button").attr('disabled', true);
            }
        }




    }); //E

});