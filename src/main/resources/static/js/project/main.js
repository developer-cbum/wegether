$(document).ready(function () {
    const $ul = $("#list-container");
    let text = "";

    projects.forEach(project => {
        text += `
            <div role="presentation" class="CardTable_itemContainer__v9-cW"
                style="width: calc((25% - 24px + 6px) - 0.01px); margin-left: 0px; margin-right: 12px; margin-bottom: 40px;">
                <a class="StoreCard_item__1hRfz" href="#">
                    <div class="CardThumbnail_thumbnailContainer__DwnpC">
                    </div>
                </a>
            </div>
        `;
    });

    $ul.append(text);
});