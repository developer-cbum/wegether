$(document).ready(function() {
    const $datarg = $("#dataregister");
    let text = "";
    datards.forEach(datard => {
        text += `
        <div role="presentation" class="CardTable_itemContainer__v9-cW" style="width: calc((16.6667% - 16px + 5px) - 0.01px); margin-left: 0px; margin-right: 8px; margin-bottom: 0px;">
            <a href="/web/store/detail/35?_refer_section_st=storeCurator_0" class="RecommendationStoreCard_item__3iMMQ" data-ec-list="홈_추천_스토어" data-ec-id="35" data-ec-name="내 손안의 스마트한 스튜디오, 저스트모바일 셔터그립2" data-ec-position="0" data-ec-price="59900" data-ec-category="테크·가전" data-ec-brand="주식회사 시티파이브" data-ec-contenttype="STORE">
                <div class="RecommendationStoreCard_thumbnailContainer__mghKx">
                    <div class="RecommendationStoreCard_thumbnailPlaceholder__3TTOS" style="padding-top: calc(100% - 0px);">
                        <img src="/files/display?fileName=${datard.files[0].filePath}/t_${datard.files[0].fileUuid}_${datard.files[0].fileName}" class="preview">
                    </div>
                </div>
                <div class="RecommendationStoreCard_contentContainer__aDF-5">
                    <div class="RecommendationStoreCard_projectName__kIgBJ">${datard.dataTitle}</div>
                </div>
            </a>
        </div>`;
    });
    $datarg.html(text);
});
