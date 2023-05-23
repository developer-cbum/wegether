$(document).ready(function(){
    const $ul = $("ul");

    let text = "";

    projects.forEach(project => {
        text += `
            <li
                  class="CardList_itemContainer__2c_vS"
                  style="
            width: calc((100% - 0px) - 0.01px);
            margin-left: 0px;
            margin-right: 0px;
            margin-bottom: 0px;
          "
          >
            <div role="link" class="PurchaseSummaryCard_item__3LlZ3">
              <dl class="PurchaseSummaryCard_etcArea__3Ummh">
                <dd> </dd>
                <dd> </dd>
              </dl>
              <div class="PurchaseSummaryCard_content__21XLk">
                <div class="PurchaseSummaryCard_thumbnailArea__2BT7p" aria-hidden="true">
                  <div class="PurchaseSummaryCard_thumbnailPlaceholder__3O0tl">
                    <div
                            aria-hidden="true"
                            class="CardThumbnail_thumbnail__3bDBJ CardThumbnail_visible__343f4"
               > `
        // project.files.forEach(file => {
        //     if(file.fileType == "REPRESENTATIVE"){
        //         text += `<img src="/files/display?fileName=${file.filePath}/t_${file.fileUuid}_${file.fileName}" class="preview">`;
        //     }
        // })
        text+=`
           
        </div>
                  </div>
                </div>
            
                
                <dl class="PurchaseSummaryCard_titleArea__3qDl4">
                  <dd
                          title="<컴퓨터 공학과> 사이트 개발 프로젝트"
                          class="PurchaseSummaryCard_title__uCiz5"
                  > ${project.projectTitle}

                  </dd>
                  <dd class="PurchaseSummaryCard_description__245z_">
                    <span class="PurchaseSummaryCard_makerName__1n7dA">info</span>
                  </dd>
                </dl>
              </div>
              <div class="PurchaseSummaryCard_detailText__2GWWi" aria-hidden="true">
                <button>수정</button>
                <span>&nbsp | &nbsp</span>
                <button>삭제</button>
              </div>


            </div>
          </li>
`;

    });

    $ul.html(text);
});



