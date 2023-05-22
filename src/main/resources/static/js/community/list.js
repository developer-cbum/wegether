$(document).ready(function() {

    let page = 1;
    showList();

    $(window).scroll(function(){
        if (Math.ceil(window.innerHeight + window.scrollY) >= document.body.scrollHeight) {
            page++;
            showList();
        }
    });

    /*게시글 불러오기 ajax 함수*/
    function next_load() {
        $.ajax({
            type: "POST",
            data: { page: page },
            url: "/community/list",
            success: function(communities) {
                if (communities) {
                    console.log(communities);
                    if (result.length == 0) {
                        showWarnModal("마지막 이용후기입니다");
                        return;
                    }
                    showList(communities);
                    loading = false;    //실행 가능 상태로 변경
                }
            },
            complete: function() {
                $('.wrap-loading').addClass('display-none');
            }, error: function(request, status, error) { // 오류가 발생했을 때 호출된다.
                if (error === 'timeout') {
                    showWarnModal("요청한 시간이 지났습니다.<br> 새로고침을 시도해주세요.");
                }
            }, timeout: 20000
        });
    }

    $(window).scroll(function() {
        console.log(Math.round($(window).scrollTop()));
        console.log($(document).height() - $(window).height());
        if (Math.round($(window).scrollTop()) >= $(document).height() - $(window).height()) {
            if (!loading)    //실행 가능 상태라면?
            {
                page++;
                loading = true; //실행 불가능 상태로 변경
                next_load();
                return;
            }
        }
    });



    function showList() {
                console.log("들옴");
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
                                src="/files/display?fileName=${file.filePath}/t_${file.fileUuid}_${file.fileName}" class="preview">`;
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
                $(".block_extended").html(text);

                console.log($block)
    }
})

// if($(".et-animated").Array.length){
//     $(".ajax-pagination").show()
// }else{$(".ajax-pagination").hide()}
