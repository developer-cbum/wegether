$(document).ready(function() {
    const $comu = $("#comu-wrap li");
    let text = "";
    const numToShow = 3; // 보여줄 개수 설정

    for (let i = 0; i < Math.min(numToShow, communities.length); i++) {
        const comu = communities[i];
        text += `
            <a href="/web/campaign/detail/209392?_refer_section_st=earlyBird_0"
                data-ec-list="홈_얼리버드_프리오더" data-ec-id="209392"
                data-ec-name="뻔하고 후줄근한 티셔츠는 그만!  [프리미엄 소프트 코튼 티셔츠]" data-ec-position="0"
                data-ec-category="패션·잡화" data-ec-brand="주식회사 포인트나인크루"
                data-ec-contenttype="PREORDER"
                data-gtm-vis-recent-on-screen-11319722_2115="264732"
                data-gtm-vis-first-on-screen-11319722_2115="264732"
                data-gtm-vis-total-visible-time-11319722_2115="2000"
                data-gtm-vis-recent-on-screen-11319722_2073="264732"
                data-gtm-vis-first-on-screen-11319722_2073="264732"
                data-gtm-vis-total-visible-time-11319722_2073="2000"
                data-gtm-vis-has-fired-11319722_2073="1"
                data-gtm-vis-has-fired-11319722_2115="1" style="width:33%; margin-right:30px;">
                <div class="CardType_projectCard__3xhjb CardType_earlybirdCard__1t1n1">
                    <div class="commons_thumbnail__3wYGv CardType_thumbnail__2dtTe">`;

        comu.files.forEach(file => {
            if (file.fileType == "REPRESENTATIVE") {
                text += `<img src="/files/display?fileName=${file.filePath}/t_${file.fileUuid}_${file.fileName}" class="preview">`;
            }
        });

        text += `
                    </div>
                    <div class="CardType_cardContent__3UMOr">
                        <div>
                            <div class="commons_content__2K1SH CardType_content__1Pavj">
                                <em class="commons_title__1yGWm">${comu.communityTitle}</em>
                            </div>
                        </div>
                    </div>
                </div>
            </a>`;
    }

    $comu.html(text);
    console.log("나감");
    console.log($comu);
});
