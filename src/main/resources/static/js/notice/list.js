$(document).ready(function(){
    // 리스트 부분 이미지
    const $noticeList = $(".notice-list");

    let text = "";

    notices.forEach(notice => {
        text += `
            <li>
                <div class="article">
                    <div class="info">
                        <div>
                            <h3 class="title">
                            <a href="/notices/detail?id=${notice.id}"">${notice.noticeTitle}</a>
                            </h3>
                            <span class="author">위게더</span>
                            <span class="created-at">${notice.noticeRegisterDate}</span>
                        </div>
                        <div>
                            <div class="preview">
            `
                            notice.files.forEach(file => {
                                if(file.fileType == "REPRESENTATIVE") {
                                    text += `<img src="/files/display?fileName=${file.filePath}/${file.fileUuid}_${file.fileName}" class="detailPreview">`;
                                }
                            })
        text += `
                            </div>
                        </div>
                    </div>
                </div>
            </li>
        `
    });
    $noticeList.html(text);

    $(".preview").css({
        "width": "144px",
        "height": "108px",
        "overflow": "hidden",
        "object-fit": "scale-down"
    });

    $(".detailPreview").css({
        "width": "100%",
        "height": "100%",
        "object-fit": "cover"
    });

    $(".info").css({
        "display": "flex",
        "justify-content": "space-between"
    })

    $(".article").css({
        "padding-bottom": "20px"
    })

    $(".title").css({
        "margin-right": "60px"
    })

});
