//작성시간 함수
function elapsedTime(date) {
    const start = new Date(date);
    const end = new Date();

    const diff = (end - start) / 1000;

    const times = [
        {name: '년', milliSeconds: 60 * 60 * 24 * 365},
        {name: '개월', milliSeconds: 60 * 60 * 24 * 30},
        {name: '일', milliSeconds: 60 * 60 * 24},
        {name: '시간', milliSeconds: 60 * 60},
        {name: '분', milliSeconds: 60},
    ];

    for (const value of times) {
        const betweenTime = Math.floor(diff / value.milliSeconds);

        if (betweenTime > 0) {
            return `${betweenTime}${value.name} 전`;
        }
    }
    return '방금 전';
}

//무한 스크롤 함수
let page = 1;

$(window).scroll(function () {
    if (Math.ceil(window.innerHeight + window.scrollY) >= document.body.scrollHeight) {
        page++;
        showList();
    }
});

// 상단바 고정 js
window.addEventListener("scroll", () => {
    if (window.scrollY > 60) {
        $(".style__HeaderContentLayout-zxsodr-12").removeClass("elXgTt").addClass("iziaon");
    } else {
        $(".style__HeaderContentLayout-zxsodr-12").removeClass("iziaon").addClass("elXgTt");
    }
});

/*시작하자마자 현제 페이지 확인하기*/
$(document).ready(function () {
    let order = searchParam('order');
    let keyword = searchParam('keyword');

    if (keyword != "") {
        $("#input_search").val(keyword);
    }
    if (order == "trand") {
        $(".new label a").removeClass("font_label_bold_xl content_primary").addClass("font_label_regular_xl content_quaternary");
        $(".trand label a").removeClass("font_label_regular_xl content_quaternary").addClass("font_label_bold_xl content_primary");
    } else {
        $(".new label a").removeClass("font_label_regular_xl content_quaternary").addClass("font_label_bold_xl content_primary");
        $(".trand label a").removeClass("font_label_bold_xl content_primary").addClass("font_label_regular_xl content_quaternary");
    }
})

$(document).ready(function () {
    let type = searchParam('type');
    let href = window.location.href
    $(".fAzCXd a").removeClass("eWDpEZ").addClass("ehJwom");
    if (href.split('/')[3] == 'main') {
        $(".main").removeClass("ehJwom").addClass("eWDpEZ");
    } else if (href.split('/')[3] == 'post') {
        if (type == null) {
            $(".writing").removeClass("ehJwom").addClass("eWDpEZ");
        } else {
            $("." + type).removeClass("ehJwom").addClass("eWDpEZ");
        }
    }
})


//게시판 li태그 뿌리기
// $(document).ready(showList);
$.ajax({
    url: `/post/list`,
    type: 'post',
    data: JSON.stringify({type: type}),
    success: function(posts){
        showList(posts);
    }
});

function showList(posts) {
    const $ul = $("#content-wrap");
    let text = "";
    posts.forEach(post => {
        text += `
                <a href="/post/detail?id=${post.id}">
                    <li class="py-[20px] pb-[0px] border-t first:pt-[8px] first:border-0 border_secondary">
                        <div>
                            <button type="button" class="block text-left w-full">
                                <div class="flex gap-x-[16px]">
                                    <div class="w-full h-[73px] xl:h-auto break-all">
                                        <!-- 제목 -->
                                        <h2 class="overflow-hidden font_title_bold_md xl:font_title_bold_lg content_secondary text-ellipsis-1">
                                            ${post.postName}
                                        </h2>
                                        <!-- 내용 -->
                                        <p class="mt-[4px] mb-[18px] xl:mt-[6px] overflow-hidden font_label_regular_lg content_quaternary text-ellipsis-1 xl:text-ellipsis-2">
                                            ${post.postContent}
                                        </p>
                                    </div>
                                    <!-- 섬네일 (없을때는 div가 없어짐) -->
                                    <div class="shrink-0 relative w-[72px] md:w-[102px] h-[72px] md:h-[102px] rounded-[8px]">
                                        <span style="box-sizing: border-box; display: block; overflow: hidden; width: initial; height: initial; background: none; opacity: 1; border: 0px; margin: 0px; padding: 0px; position: absolute; inset: 0px;">
`
        post.postFiles.forEach(file => {
            if (file.fileType == "REPRESENTATIVE") {
                text += `<img src="/files/display?fileName=${file.filePath}/t_${file.fileUuid}_${file.fileName}" class="rounded-[8px]" style="position: absolute; inset: 0px; box-sizing: border-box; padding: 0px; border: none; margin: auto; display: block; width: 0px; height: 0px; min-width: 100%; max-width: 100%; min-height: 100%; max-height: 100%; object-fit: cover; object-position: center center;">`;
            }
        })
        text += `
                                        </span>
                                    </div>
                                </div>
                                <!-- 프로필 -->
                                <div class="flex items-center mt-[12px]">
                                    <div class="relative shrink-0 rounded-full shadow-[inset_0_0_0_1px_rgba(0,0,0,0.1)]" style="width: 18px; height: 18px; background : url(https://steadio.imgix.net/profiles/81babe73-f3d3-4c5b-9ef8-1f101e6af53b/profileImage/a5134490-09e0-464c-800a-6f118c3b3d1f.jpeg?auto=format%2Ccompress&h=300&lossless=true&w=300) center center / cover no-repeat, rgb(255, 255, 255);"></div>
                                    <div class="ml-[6px] font_label_regular_md flex items-center gap-x-[2px]">
                                        <!-- 작성자 정보 -->
                                        <span class="content_secondary break-all line-clamp-1 lg:max-w-full max-w-[115px]">${post.memberName}</span>
                                        <svg viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" class="w-[8px] h-[8px] content_disabled">
                                            <circle cx="12" cy="12" r="4"></circle>
                                        </svg>
                                        <!-- 작성 시간 -->
                                        <span class="shrink-0 content_quaternary">` + elapsedTime(post.postRegisterDate) + ` </span>
                                        <svg viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" class="w-[8px] h-[8px] content_disabled">
                                            <circle cx="12" cy="12" r="4"></circle>
                                        </svg>
                                        <!-- 조회수 -->
                                        <span class="shrink-0 content_quaternary">
                                            조회수
                                            ${post.postViewCount}
                                        </span>
                                    </div>
                                </div>
                            </button>
                        </div>
                    </li>
                  </a>
        `
    });
    $ul.html(text);
}

function searchParam(key) {
    return new URLSearchParams(location.search).get(key);
};

$(".new").click(function () {
    let type = searchParam('type');
    $(".new label a").removeClass("font_label_regular_xl content_quaternary").addClass("font_label_bold_xl content_primary");
    $(".trand label a").removeClass("font_label_bold_xl content_primary").addClass("font_label_regular_xl content_quaternary");
    $.ajax({
        url: `/post/list?type=${type}&order=new`,
        type: 'post',
        success: function(posts){
            showList(posts);
        }
    })
});

$(".trand").click(function () {
    let type = searchParam('type');
    $(".new label a").removeClass("font_label_bold_xl content_primary").addClass("font_label_regular_xl content_quaternary");
    $(".trand label a").removeClass("font_label_regular_xl content_quaternary").addClass("font_label_bold_xl content_primary");
    $.ajax({
        url: `/post/list?type=${type}&order=trand`,
        type: 'post',
        success: function(posts) {
            showList(posts)
        }
    })
});

$(".fAzCXd a").on("click", function () {
    let type = this.classList[0];
    if (type == "main") {
        location.href = `/main`;
    } else {
        $.ajax({
            url: `/post/list?type=${type}`,
            type: 'post',
            success: function(posts) {
                alert(type);
                $(".fAzCXd a").removeClass("eWDpEZ").addClass("ehJwom");
                if (type == null) {
                    $(".writing").removeClass("ehJwom").addClass("eWDpEZ");
                } else {
                    $("." + type).removeClass("ehJwom").addClass("eWDpEZ");
                }
                showList(posts)
            }
        })
    }
})


// function addFunc() {
//     let keyword = $("#input_search").val();
//     let type = searchParam('type');
//     let order = searchParam('order');
//     if (type == null) {
//         location.href = `/post/list?&type=writing&order=new&keyword=${keyword}`;
//     } else {
//         if (order == null) {
//             location.href = `/post/list?&type=${type}&order=new&keyword=${keyword}`;
//         } else {
//             location.href = `/post/list?&type=${type}&order=${order}&keyword=${keyword}`;
//         }
//