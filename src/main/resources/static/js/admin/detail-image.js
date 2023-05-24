$(document).ready(function(){
    // 상세보기 부분 이미지
    const $noticeImage = $(".notice-image");

    text = "";

    files.forEach(file => {
        if(file.fileType == "REPRESENTATIVE") {
            text += `
                <img src="/files/display?fileName=${file.filePath}/t_${file.fileUuid}_${file.fileName}" class="preview">
        `
        }
    });

    $noticeImage.html(text);

    $(".preview").css({
        "padding-top": "25px",
        "width": "120px",
        "height": "100px",
        "object-fit": "scale-down"
    });
});
