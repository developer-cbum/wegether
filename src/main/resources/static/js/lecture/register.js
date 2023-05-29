console.log("연동테스트");

const $upload = $("input.upload");
const $thumbnail = $("label.attach img.thumbnail");

$("img.preview").each(function(i){
    if(!$(this).attr("src")){
        $(this).hide();
    }
});

let sizes = new Array(4).fill(0);
$upload.on("change", function(e){
    console.log("들어옴?");
    let i = $upload.index($(this));
    let files = $(this)[0].files;
    let name = files[0].name;

    let formData = new FormData();

    sizes[i] = files[0].size;
    $('.file-size').eq(i).text((files[0].size / 1024).toFixed(2) + "KB");

    $(files).each((i, file) => {
        formData.append("uploadFile", file);
        formData.append("name", $(this).attr("id"));
    });

    $.ajax({
        url: "/lecture-files/upload",
        type: "post",
        data: formData,
        contentType: false,
        processData: false,
        success: function(uuids){
            console.log("들어왔나")
            $("label.attach").eq(i).find("h6").hide();
            $("div.x").eq(i).show();
            $("img.thumbnail").eq(i).show();
            let now = new Date();
            let year = now.getFullYear();
            let month = now.getMonth() + 1;
            let date = now.getDate();

            month = month < 10 ? "0" + month : month;
            date = date < 10 ? "0" + date : date;

            let fileName = year + "/" + month + "/" + date + "/t_" +uuids[0] + "_" + name;
            $("img.thumbnail").eq(i).attr("src", `/lecture-files/display?fileName=${fileName}`);
        }
    });


});

$("div.x").on("click", function(e){
    e.preventDefault();
    let i = $("div.x").index($(this));
    sizes[i] =0;
    $('.file-size').eq(i).text("");
    $upload.eq(i).val("");
    $("label.attach").eq(i).find("h6").show();
    $("div.x").eq(i).hide();
    $thumbnail.eq(i).attr('src', "");
    $thumbnail.eq(i).hide();
});


// 번호만 입력
$('.personnel').on('input', function () {
    let numericVal = $(this).val().replace(/[^0-9]/g, '');

    if (numericVal.length > 11) {
        numericVal = numericVal.substr(0, 11); // 최대 11자리까지만 유지
    }

    $(this).val(numericVal);
});


$("button.ok-button").on("click", function(){

    // 강연 제목 유효성 검사
    if (document.registerForm.lectureTitle.value == '') {
        showWarnModal('강연 제목을 입력해주세요');
        document.registerForm.lectureTitle.focus();
        return;
    }

    // 강연 날짜 유효성 검사
    if (document.registerForm.lectureDate.value == '') {
        showWarnModal('강연 날짜를 입력해주세요');
        document.registerForm.lectureDate.focus();
        return;
    }

    // 강연 시간 유효성 검사
    if (document.registerForm.lectureTime.value == '') {
        showWarnModal('강연 시간을 입력해주세요');
        document.registerForm.lectureTime.focus();
        return;
    }

    // 강연 위치 유효성 검사
    if (document.registerForm.lectureLocation.value == '') {
        showWarnModal('강연 위치를 입력해주세요');
        document.registerForm.lectureLocation.focus();
        return;
    }

    // 강연 총 인원 유효성 검사
    if (document.registerForm.lectureTotalPersonnel.value == '') {
        showWarnModal('강연 총 인원을 입력해주세요');
        document.registerForm.lectureTotalPersonnel.focus();
        return;
    }

    // 강연 내용 유효성 검사
    if (document.registerForm.lectureContent.value == '') {
        showWarnModal('강연 내용을 입력해주세요');
        document.registerForm.lectureContent.focus();
        return;
    }

    //사진 있는 지 검사
      if(!$thumbnail.eq(0).attr("src")){
          showWarnModal("대표이미지를 등록해주세요.")
          return;
      }
    if(!$thumbnail.eq(1).attr("src")){
        showWarnModal("제목사진을 등록해주세요.")
        return;
    }
    if(!$thumbnail.eq(2).attr("src")){
        showWarnModal("내용사진을 등록해주세요.")
        return;
    }

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
    });
    $(registerForm).append(text);
    console.log($(registerForm))

    showWarnModal('저장이 완료되었습니다');
    setTimeout(function () {
        $(registerForm).submit();
    }, 2000);



});

//업로드 클릭이벤트막기
$upload.on("click", function (e) {
    let i = $upload.index($(this));
    if($thumbnail.eq(i).attr("src") != ""){
        e.preventDefault();
    }
})