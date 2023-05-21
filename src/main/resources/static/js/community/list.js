$(document).ready(function(){
    const $block = $(".block_extended");

    console.log("들옴");

    let text = "";
    communities.forEach(community => {
        text += `
           <article
                 id="post-364941"
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
                             ><img
                                 width="1024"
                                 height="600"
                                 src="https://blog.wadiz.kr/wp-content/uploads/sites/2/2023/05/planning-note_5th_1-1024x600.png"
                                 class="et_pb_post_main_image no-lazyload skip-lazy wp-post-image"
                                 alt="진국월드 기획노트 별책부록"
                                 decoding="async"
                                 loading="lazy"
                                 srcset="
                                     https://blog.wadiz.kr/wp-content/uploads/sites/2/2023/05/planning-note_5th_1-1024x600.png 1024w,
                                     https://blog.wadiz.kr/wp-content/uploads/sites/2/2023/05/planning-note_5th_1-980x574.png   980w,
                                     https://blog.wadiz.kr/wp-content/uploads/sites/2/2023/05/planning-note_5th_1-480x281.png   480w
                                 "
                                 sizes="(min-width: 0px) and (max-width: 480px) 480px, (min-width: 481px) and (max-width: 980px) 980px, (min-width: 981px) 1024px, 100vw"
                         /></a>
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
             </article>

        `
    });

    $block.html(text);

    console.log($block)
});