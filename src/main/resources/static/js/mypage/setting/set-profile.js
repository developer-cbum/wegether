const $upload = $("input.upload");
const $thumbnail = $("img.thumbnail");

console.log("set-profile");

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

    console.log("업로드 들어옴");

    sizes.push()(files[0].size);

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

$(".file_upload_btn").on("click", function(e){

    console.log("버튼 들어옴");

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



$("button.changeProfile").on("click", function(){
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

        console.log("전달 완료");
        // 저장완료 모달
        showWarnModal('등록이 완료되었습니다');
        setTimeout(function () {
            check();
            document.registerForm.submit();
        }, 2000);

    });
    $(writeForm).append(text);
    $(writeForm).submit();


});



//
//     /*사진변경*/
//     $(document).ready(function () {
//         $("#btn_updatePhoto").click(function () {
//             $("#file_input").click();
//         });
//
//         $("#file_input").change(function () {
//             var file = this.files[0];
//             var reader = new FileReader();
//
//             reader.onload = function (e) {
//                 $("#profile_image").attr("src", e.target.result);
//             };
//
//             reader.readAsDataURL(file);
//         }))
//
//         // $("#btn_deletePhoto").click(function () {
//         //     $("#profile_image").attr("src", "https://d2v80xjmx68n4w.cloudfront.net/assets/icon/mykmong-profile-default@3x.png");
//         // });
//
// )})