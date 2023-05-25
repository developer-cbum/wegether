$(document).ready(function() {
        const $psearch = $("#project-search");

        let text = "";
        searches.forEach(search => {
                text += `
                    <div class="preview">
                        <a href=""></a>
                `
                search.files.forEach(file => {
                        if (file.fileType == "REPRESENTATIVE") {
                                text += `<img src="/files/display?fileName=${file.filePath}/t_${file.fileUuid}_${file.fileName}">`;
                        }
                })
                text += `
                            <p class="PreOrderCard_projectCard_title__psAv4">
                                <strong>${search.projectTitle}</strong>
                            <small class="PreOrderCard_projectCard_subInfo__vbiVf">
                                <span>${search.projectMajor}</span>
                            </small>
                            </p>
                    </div>
                `
        });
        $psearch.html(text);

        $(".preview").css({
                "width": "30%",
                "height": "100px"
        });
});
