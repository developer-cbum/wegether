

let titleCheck = false;
let contentCheck= false;
let categoryCheck= false;

//input value 값주기
$(document).on("click", function () {
    $('.value').val(`${$.trim($('.menu-value').text())}`);
})

// textarea 값 넣기
$('.content-textarea').on("input", function () {
    $('.consult-content').val(`${$.trim($(this).val())}`)
})


// 유효성 버튼 검사
 $('#consultingTitle').on("keyup", function () {
     if($('.consult-content').val() != ''){
         categoryCheck =true;
     }else{
         categoryCheck =false;
     }

     if($(this).val() == ''){
         titleCheck=false;
     }else{
         titleCheck=true;
     }
     consultingFlag()


 })

$('.content-textarea').on("keyup", function () {

    if($('.consult-content').val() != ''){
        categoryCheck =true;
    } else{
        categoryCheck =false;
    }

    if($(this).val() == ''){
        contentCheck=false;
    }else{
        contentCheck=true;
    }

    consultingFlag()
})



function consultingFlag() {
    if(categoryCheck && contentCheck && titleCheck){
        $('.button_save').attr("disabled", false);
    }else{
        $('.button_save').attr("disabled", true);
    }
}

const $upload = $("input.upload");
const $thumbnail = $("label.attach img.thumbnail");

$("img.preview").each(function(i){
    if(!$(this).attr("src")){
        $(this).hide();
    }
});

let sizes = new Array(4).fill(0);
$upload.on("change", function(e){
    let i = $upload.index($(this));
    let files = $(this)[0].files;
    let name = files[0].name;
    let formData = new FormData();

    sizes[i] = files[0].size;

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
            $("label.attach").eq(i).find("h6").hide();
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

    // console.log($(this).files[0]);

    // var reader = new FileReader();
    // reader.readAsDataURL(e.target.files[0]);
    // reader.onload = function(e){
    //     let url = e.target.result;
    //     if(url.includes('image')){
    //         $("label.attach").eq(i).find("h6").hide();
    //         $("div.x").eq(i).show();
    //         $thumbnail.eq(i).show();
    //         $thumbnail.eq(i).attr('src', url);
    //     }else{
    //         showWarnModal("이미지 파일만 등록 가능합니다.");
    //     }
    // }
});

$("div.x").on("click", function(e){
    e.preventDefault();
    let i = $("div.x").index($(this));
    sizes = sizes.splice(i, 1);
    $upload.eq(i).val("");
    $("label.attach").eq(i).find("h6").show();
    $("div.x").eq(i).hide();
    $thumbnail.eq(i).attr('src', "");
    $thumbnail.eq(i).hide();
});

$("button.button_save").on("click", function(){
    let text = ``;
    let count = 0;
    $("img.thumbnail").each((i, img) => {
        let fullPath = $(img).attr("src");
        if(!fullPath) {return;}

        let datas = fullPath.split("_");
        let filePath = datas[0].split("=")[1].replace("/t", "");
        let fileUuid = datas[1];
        let fileName = datas[2];
        let fileType = $(img).hasClass("representative");
        let fileSize = sizes[i];

        text += `
            <input type="hidden" name="files[${count}].filePath" value="${filePath}">
            <input type="hidden" name="files[${count}].fileUuid" value="${fileUuid}">
            <input type="hidden" name="files[${count}].fileName" value="${fileName}">
            <input type="hidden" name="files[${count}].fileSize" value="${fileSize}">
        `
        if(fileType){
            text += `<input type="hidden" name="files[${count}].fileType" value="REPRESENTATIVE">`;
        }
        count++;
    });
    $(writeForm).append(text);
    $(writeForm).submit();
});




function lastok() {
    location.href = "./main.html";
    // 마이페이지 이동
}
