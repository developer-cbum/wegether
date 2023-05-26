

    // let page = 1;
    // // let count = 1; //한번만 실행할수있게하는 flag
    // let loading = false;
    // $(window).ready(next_load());
    // showList();
    //
    // $(window).scroll(function(){
    //     if (Math.ceil(window.innerHeight + window.scrollY) >= document.body.scrollHeight) {
    //         showList();
    //     }
    // });

    // //게시글 불러오기
    // function next_load(){
    // $.ajax({
    //     url: `/community/list?page=${page}`,
    //     success: function (result) {
    //         if (result) {
    //             console.log(result);
    //             // if (result.length == 0) {
    //             //     $('.wrap-loading').addClass('display-none');
    //             //     showWarnModal("마지막 이용후기입니다");
    //             //     return;
    //             // }
    //             showList(result);
    //             loading = false;    //실행 가능 상태로 변경
    //         }
    //     }})}
    // $(window).scroll(function() {
    //     // console.log(Math.round($(window).scrollTop()));
    //     // console.log($(document).height() - $(window).height());
    //     if (Math.round($(window).scrollTop()) >= $(document).height() - $(window).height()) {
    //         page++;
    //         console.log(page)
    //         if (!loading)    //실행 가능 상태라면?
    //         {
    //             loading = true; //실행 불가능 상태로 변경
    //             //    스크롤 이벤트
    //             console.log(page)
    //             next_load();
    //             return;
    //         }
    //     }
    // });

    let page = 1;
    let keyword = $("input[name=keyword]").val();
    alert(keyword)
    console.log(keyword)
    showList();

    $(window).scroll(function(){
        if (Math.ceil(window.innerHeight + window.scrollY) >= document.body.scrollHeight) {
            page++;
            console.log(page);
            showList();
        }
    });


    function showList(){
        $.ajax({
            url: `/community/list`,
            type: `post`,
            data: JSON.stringify(
                {page: page, keyword: keyword}),
            contentType: "application/json;charset=utf-8",
            success: function(communities){
                let text = "";
                communities.forEach(community => {
                    text += `
           <article
                 class="et_pb_post et_pb_post_extra et_pb_text_align_left et-waypoint et_pb_animation_off el_dbe_block_extended image-top post-364941 post type-post status-publish format-standard has-post-thumbnail hentry category-planning-note category-platform-story tag-475 tag-478 tag-485 tag-517 tag-356 tag-363 et-animated"
             >
                 <div class="post-categories">
                     <a
                         href="/community/detail?id=${community.id}"
                         target="_self"
                         rel="category term tag"
                         class="el_category_term el_term_planning-note"
                         style="visibility: hidden"
                     ></a>
                 </div>
                 <div class="post-media-container">
                     <div class="post-media">
                         <a
                             href="/community/detail?id=${community.id}"
                             target="_self"
                             class="entry-featured-image-url"
                             >`
                    community.files.forEach(file => {
                        if (file.fileType == "REPRESENTATIVE") {
                            text += `<img
                                 width="1024"
                                 height="600"
                                src="/files/display?fileName=${file.filePath}/${file.fileUuid}_${file.fileName}" class="preview">`;
                        }
                    })
                    text += ` </a>
                     </div>
                 </div>
                 <div class="post-content">
                     <a
                         href="/community/detail?id=${community.id}"
                         target="_self"
                         class="abs-url"
                         >${community.communityTitle}</a
                     >
                     <h6 class="entry-title">
                         <a
                             href="/community/detail?id=${community.id}"
                             target="_self"
                             >${community.communityTitle}</a
                         >
                     </h6>
                     <div class="post-data">
                         <p>${community.communitySubtitle}</p>
                     </div>
                 </div>
             </article>`

                })
                $(".block_extended").append(text);
            }
        })
        }

    //목록 생성
    // function showList(result) {
    //     console.log("들옴");
    //             let text = "";
    //             communities.forEach(community => {
    //                 text += `
    //        <article
    //              class="et_pb_post et_pb_post_extra et_pb_text_align_left et-waypoint et_pb_animation_off el_dbe_block_extended image-top post-364941 post type-post status-publish format-standard has-post-thumbnail hentry category-planning-note category-platform-story tag-475 tag-478 tag-485 tag-517 tag-356 tag-363 et-animated"
    //          >
    //              <div class="post-categories">
    //                  <a
    //                      href="/community/detail?id=${community.id}"
    //                      target="_self"
    //                      rel="category term tag"
    //                      class="el_category_term el_term_planning-note"
    //                      style="visibility: hidden"
    //                  ></a>
    //              </div>
    //              <div class="post-media-container">
    //                  <div class="post-media">
    //                      <a
    //                          href="/community/detail?id=${community.id}"
    //                          target="_self"
    //                          class="entry-featured-image-url"
    //                          >`
    //                 community.files.forEach(file => {
    //                     if (file.fileType == "REPRESENTATIVE") {
    //                         text += `<img
    //                              width="1024"
    //                              height="600"
    //                             src="/files/display?fileName=${file.filePath}/${file.fileUuid}_${file.fileName}" class="preview">`;
    //                     }
    //                 })
    //                 text += ` </a>
    //                  </div>
    //              </div>
    //              <div class="post-content">
    //                  <a
    //                      href="/community/detail?id=${community.id}"
    //                      target="_self"
    //                      class="abs-url"
    //                      >${community.communityTitle}</a
    //                  >
    //                  <h6 class="entry-title">
    //                      <a
    //                          href="/community/detail?id=${community.id}"
    //                          target="_self"
    //                          >${community.communityTitle}</a
    //                      >
    //                  </h6>
    //                  <div class="post-data">
    //                      <p>${community.communitySubtitle}</p>
    //                  </div>
    //              </div>
    //          </article>`
    //
    //             })
    //             $(".block_extended").append(text);
    // }

// if($(".et-animated").Array.length){
//     $(".ajax-pagination").show()
// }else{$(".ajax-pagination").hide()}
