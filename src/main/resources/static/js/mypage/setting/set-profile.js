/*프로필 설정*/
let $upload = $('.upload');


/*프로필 삭제*/

$("#btn_deletePhoto").on("click", function(e){
    e.preventDefault();
    remove();
    $('.profileimg-wrap button em').css('background-image', "url(https://static.wadiz.kr/assets/icon/profile-icon-6.png)");
});


// 프로필 설정 ajax

$upload.on("change", function () {
    console.log("들어옴");
    let files = $(this)[0].files;
    let name = files[0].name;
    console.log(files);
    console.log(name)
    let formData = new FormData();
    let size = files[0].size;
    let text= '';


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

            let now = new Date();
            let year = now.getFullYear();
            let month = now.getMonth() + 1;
            let date = now.getDate();

            month = month < 10 ? "0" + month : month;
            date = date < 10 ? "0" + date : date;

            let fileName = year + "/" + month + "/" + date + "/t_" + uuids[0] + "_" + name;

            $('.profileimg-wrap button em').css('background-image', `url(/files/display?fileName=${fileName}`);

            text += `
            <input type="hidden" name="filePath" value="${year + "/" + month + "/" + date}">
            <input type="hidden" name="fileUuid" value="${uuids}">
            <input type="hidden" name="fileName" value="${name}">
            <input type="hidden" name="fileSize" value="${size}">
            `

            $(writeForm).append(text);

        }
    });
})

// 삭제 ajax

function remove() {
    $.ajax({
        url : "basic-profile",
        type: "put",
        success: function () {
            console.log("들어옴")
            showWarnModal("기본 프로필로 변경되었습니다.")
        }

    })
}