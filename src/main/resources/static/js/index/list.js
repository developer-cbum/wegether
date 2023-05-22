$(document).ready(function() {
    const $projectile = $(".project-list");


    let text = "";
    projects.forEach(project => {
        text += `
    
        <div class="RecommendFundingWrap_card___LnVO pjlist">
            <div>
            <a class="CardType_projectCard__3xhjb CardType_projectCardB__3N8ks"
        href="/web/campaign/detail/204506?_refer_section_st=PersonalCurator_0"
        data-ec-list="홈_추천_펀딩" data-ec-id="204506"
        data-ec-name="저스펙으로 대기업/공기업 취업 성공하는 방법" data-ec-position="0"
        data-ec-category="출판" data-ec-brand="마이준"
        data-ec-contenttype="REWARD"
        data-gtm-vis-first-on-screen-11319722_2073="74"
        data-gtm-vis-first-on-screen-11319722_2115="75"
        data-gtm-vis-recent-on-screen-11319722_2115="53737501"
        data-gtm-vis-total-visible-time-11319722_2115="2000"
        data-gtm-vis-recent-on-screen-11319722_2073="53737501"
        data-gtm-vis-total-visible-time-11319722_2073="2000"
        data-gtm-vis-has-fired-11319722_2115="1"
        data-gtm-vis-has-fired-11319722_2073="1">
            <article>
            <div
        class="commons_thumbnail__3wYGv CardType_thumbnail__2dtTe project_height">`
        project.files.forEach(file => {
            if (file.fileType == "REPRESENTATIVE") {
                text += `<img
                                 width="1024"
                                 height="600"
                                src="/files/display?fileName=${projects.filePath}/t_${projects.fileUuid}_${projects.fileName}" class="preview">`;
            }
        })
        text += ` < /div>
                                    < /div>
                                    < div
                                class
                                    = "commons_content__2K1SH CardType_content__1Pavj" >
                                        < em
                                class
                                    = "commons_title__1yGWm"
                                    name = "projectTitle" >${project.projecttitle} < /em>
                                        < /div>
                                        < /article>
                                        < /a>
                                        < /div>
                                        < /div>`

    });

    $projectile.html(text);

    console.log($projectile)
});