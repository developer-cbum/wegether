$(document).ready(function() {
        const $psearch = $("#project-search");

        let text = "";
        searches.forEach(search => {
                text += `
                    <div class="PreOrderCard_root__1igPa PreOrderCard_search_result_projectCard__1KDkx search_result_list">
                                <a href="https://www.wadiz.kr/web/campaign/detail/188485"
                                    class="PreOrderCard_eventContainer__fCFWx" data-ec-list="검색_결과_상품카드_프리오더"
                                    data-ec-id="188485" data-ec-name="[국내최초런칭]초고속 듀얼 F1 레이저각인기! 안전과 성능 모두 잡았다!"
                                    data-ec-position="0" data-ec-category="테크·가전" data-ec-brand="시안인터내셔널 "
                                    data-ec-contenttype="PREORDER" data-gtm-vis-first-on-screen-11319722_2115="1916"
                                    data-gtm-vis-first-on-screen-11319722_2073="1917"
                                    data-gtm-vis-recent-on-screen-11319722_2115="20173"
                                    data-gtm-vis-total-visible-time-11319722_2115="2000"
                                    data-gtm-vis-recent-on-screen-11319722_2073="20173"
                                    data-gtm-vis-total-visible-time-11319722_2073="2000"
                                    data-gtm-vis-has-fired-11319722_2115="1" data-gtm-vis-has-fired-11319722_2073="1">
                                    <div class="PreOrderCard_projectCard_badge__2Ekrm"></div>
                                    <div class="PreOrderCard_imgContainer__aTJ7C">`

                search.files.forEach(file => {
                        if (file.fileType == "REPRESENTATIVE") {
                                text += `<img src="/files/display?fileName=${file.filePath}/t_${file.fileUuid}_${file.fileName}" class="preview">`;
                        }
                })
                text += `
                    </div>
                    <p class="PreOrderCard_projectCard_title__psAv4"><strong>${search.projectTitle}</strong>
                    <small class="PreOrderCard_projectCard_subInfo__vbiVf"><span>${search.projectMajor}</span>
<!--                    <span>시안인터내셔널</span>-->
                    </small>
                    </p>
                        </a>
<!--                                <div class="PreOrderCard_preOrderCountContainer__2g0xz">-->
<!--                                    <div class="PreOrderCard_countBox__2Cmjs"><span>274</span><span>명 참여</span></div>-->
<!--                                    <div class="PreOrderCard_remain__21s1Z">12일 남음</div>-->
<!--                                </div>-->
                            </div>
            `
        });
        $psearch.html(text);
});
