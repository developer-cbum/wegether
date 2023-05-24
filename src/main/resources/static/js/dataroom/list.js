$(document).ready(function () {

    let dataPagination = 1;
    const $ul = $("#list-container");
    let text = "";

    load("all");

    $(".all").click(function () {
        load("all");
    });



    function showList(datas) {
        datas.forEach(data => {
            text += `

            <div role="presentation" class="CardTable_itemContainer__v9-cW"
                style="width: calc((25% - 24px + 6px) - 0.01px); margin-left: 0px; margin-right: 12px; margin-bottom: 40px;">
                <a class="StoreCard_item__1hRfz"
                   href="/datas/detail?id=${data.id}">
                   <div class="CardThumbnail_thumbnailContainer__DwnpC" style="height: 269px;">
                   `

            data.files.forEach(file => {
                if (file.fileType == "REPRESENTATIVE") {
                    text += `
                                <div class="CardThumbnail_thumbnailPlaceholder__1Yv8K" style="padding-top: calc(100% - 0px); background-color: #f7f7f7; min-width: auto; min-height: auto;">
                                    <div aria-hidden="true"
                                        class="CardThumbnail_thumbnail__3bDBJ CardThumbnail_visible__343f4"
                                        style="background-image: url(/files/display?fileName=${file.filePath}/t_${file.fileUuid}_${file.fileName}); border-radius: 8px;">
                                     </div>
                                </div>`;
                }
            })

            text += `
                   </div>
                   <div class="StoreCard_contentContainer__tQfaN">
                      <div class="StoreCard_title__2hUM7">${data.dataTitle}
                      </div>
                      <div class="StoreCard_subText__1G_sb">${data.memberNickname}</div>
                      <div class="StoreCard_footer__12twC">
                         <div class="StoreCard_priceGroup__3T4UV">
                            <div class="StoreCard_priceContainer__3-AjB">
                               <span class="StoreCard_price__210Oz">${data.dataPrice}</span>
                               <span>원</span>
                            </div>
                            <div class="StoreCardFooter_container__X5rH8">
                               <div class="StoreCardFooter_upperFooter__kvjJa">
                                  <div class="ParticipantScore_container__JH3e_">
                                     <div class="ParticipantScore_peopleIcon__22zg8"></div>
                                     <span class="ParticipantScore_peopleCountText__1oHUl"> ${data.dataReadCount}
                                        참여</span>
                                  </div>
                               </div>
                            </div>
                         </div>
                      </div>
                   </div>
                   <div class="CardSpinner_container__1cKRs">
                      <div class="CardSpinner_loader__2-LrZ" style="width: 32px; height: 32px;">
                         <svg viewBox="25 25 50 50" aria-label="Loading">
                            <g class="Loader_circular__2dy3E">
                               <circle class="Loader_path__2uhmv" cx="50" cy="50" r="20"
                                  fill="none" stroke-width="4" stroke-miterlimit="10"></circle>
                            </g>
                         </svg>
                      </div>
                   </div>
                </a>
                <button type="button"
                   class="WishButton_button__1ZqbG WishButton_smallArea__sDV77 WishButton_interaction__2FCel"
                   aria-label="찜하기 버튼" aria-pressed="false" data-ga-category="공통_상품카드_스토어"
                   data-ga-action="찜하기_추가" data-ga-label="">
                   <svg viewBox="0 0 32 32" focusable="false" role="presentation"
                      class="withIcon_icon__3VTbq" aria-hidden="true">
                      <path
                         d="M22.16 4h-.007a8.142 8.142 0 0 0-6.145 2.79A8.198 8.198 0 0 0 9.76 3.998a7.36 7.36 0 0 0-7.359 7.446c0 5.116 4.64 9.276 11.6 15.596l2 1.76 2-1.76c6.96-6.32 11.6-10.48 11.6-15.6v-.08A7.36 7.36 0 0 0 22.241 4h-.085z">
                      </path>
                   </svg>
                </button>
            </div>
        `
        });

        $ul.append(text);
    }



    //TOP btn offset Show Hide
    $(window).scroll(function () {
        if ($(this).scrollTop() > 0) {
            button.fadeIn();
        } else {
            button.fadeOut();
        }
    });


    //sort btns
    $('.OrderSelectDesktop_sortItem__12TKi').click(function () {
        //   클릭한 버튼 활성화
        $(this).addClass('OrderSelectDesktop_active__YTP2K').siblings().removeClass('OrderSelectDesktop_active__YTP2K');
    });


    // 카테고리
    $('.category_lists button').click(function () {
        // 클릭한 버튼 활성화
        $(this).addClass('ImageTab_active__BGdXu').parent().siblings()
            .find('.ImageTab_tab__3siCY').removeClass('ImageTab_active__BGdXu');
    });

    let type = searchParam('type');
    // let href = window.location.href
    // $(".fAzCXd a").removeClass("eWDpEZ").addClass("ehJwom");

        if (type == null) {
            $(".all").addClass('ImageTab_active__BGdXu').parent().siblings()
                .find('.ImageTab_tab__3siCY').removeClass('ImageTab_active__BGdXu');
        } else {
            $("." + type).addClass('ImageTab_active__BGdXu').parent().siblings()
                .find('.ImageTab_tab__3siCY').removeClass('ImageTab_active__BGdXu');
        }


    function searchParam(key) {
        return new URLSearchParams(location.search).get(key);
    };

    $('.RecentView_container__1boAT').on("click", function () {
        history.replaceState({}, null, location.pathname);
    });

    //
    // $('.category_lists button').on("click", function (e) {
    //     e.preventDefault();
    //     let type = this.classList[0];
    //     location.href = `/datas/list?type=${type}`;
    // });

    $('.category_lists button').on("click", function () {
        let type = $(this).attr('id');
        load(type);
    })


    function load(categoryType) {
        $.ajax({
            url: `/datas/computer-list/1/${categoryType}`,
            contentType : "application/json; charset=UTF-8;",
            success:  function (datas) {
                text="";
                $ul.html("");
                showList(datas)
            }
        })
    }


    //TOP btn
    var button = $(".FloatingTopButton_pageTop__2gqm9");
    button.hide();

    // TOP 버튼 클릭시 페이지 위로 이동
    button.click(function () {
        $("html, body").animate({scrollTop: 0}, "slow");
        return false;
    });


}); //E