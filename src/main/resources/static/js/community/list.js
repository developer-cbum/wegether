$(document).ready(function() {

    let page = 1;
    // let count = 1; //한번만 실행할수있게하는 flag
    showList();

    $(window).scroll(function(){
        if (Math.ceil(window.innerHeight + window.scrollY) >= document.body.scrollHeight) {
            page++;
            showList();
        }
    });

    $.ajax({
        url: "/community/list?page=${page}",
        success: function (communities) {
            console.log("들어옴")
            showList()
        }
    })


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
    }
})

// if($(".et-animated").Array.length){
//     $(".ajax-pagination").show()
// }else{$(".ajax-pagination").hide()}
