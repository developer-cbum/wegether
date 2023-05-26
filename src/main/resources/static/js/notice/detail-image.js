$(document).ready(function(){
    // 상세보기 대표 이미지
    const $noticeDetailImage = $(".notice-detail-image");

    text = "";

    files.forEach(file => {
        if(file.fileType == "NON_REPRESENTATIVE") {
            text += `
                <a href="/files/download?fileName=${file.filePath}/${file.fileUuid}_${file.fileName}">
                    <img src="/files/display?fileName=${file.filePath}/${file.fileUuid}_${file.fileName}" class="detail">
                </a>
        `
        }
    });

    $noticeDetailImage.html(text);

    $(".detail").css({
        "padding-top": "25px",
        "width": " 50vw",
        "object-fit": "scale-down"
    });
});
