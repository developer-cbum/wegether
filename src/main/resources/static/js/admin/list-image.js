$(document).ready(function(){
    // 리스트 부분 이미지
    const $noticeList = $(".notice-list");

    let text = "";
    notices.forEach(notice => {
        text += `
            <tr>
                <td class="checkbox-line">
                    <input type="checkbox" class="noticeCheckbox" name="check" value=${notice.id}/>
                </td>
                <td>${notice.id}</td>
                <td>
                    <a href="/admins/notice/detail?id=${notice.id}">${notice.noticeTitle}</a>
                </td>
                <td>${notice.noticeRegisterDate}</td>
                <td>
            `
                    notice.files.forEach(file => {
                    if(file.fileType == "REPRESENTATIVE") {
                        text += `<img src="/files/display?fileName=${file.filePath}/t_${file.fileUuid}_${file.fileName}" class="preview">`;
                        }
                    })

        text += `
                </td>
            </tr>
        `
    });
    $noticeList.html(text);

    $(".preview").css({
        "padding-top": "20px",
        "width": "120px",
        "height": "100px",
        "object-fit": "scale-down"
    });

});
