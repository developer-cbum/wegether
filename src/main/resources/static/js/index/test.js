$(document).ready(function() {
    const $searchtest = $("#project-search");

    let text = "";
    searchtest.forEach(searchtest => {
        text += `
                    <div class="preview">
                        <a href=""></a>
                `
        searchtest.files.forEach(file => {
            if (file.fileType == "REPRESENTATIVE") {
                text += `<img src="/files/display?fileName=${file.filePath}/t_${file.fileUuid}_${file.fileName}">`;
            }
        })
        text += `
                            <p class="PreOrderCard_projectCard_title__psAv4">
                                <strong>${searchtest.dataTitle}</strong>
                            <small class="PreOrderCard_projectCard_subInfo__vbiVf">
                                <span>${searchtest.dataMajor}</span>
                            </small>
                            </p>
                    </div>
                `
    });
    $searchtest.html(text);

    $(".preview").css({
        "width": "30%",
        "height": "100px",
        "margin-bottom": "50px"
    });
});
