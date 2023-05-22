
// 자료 페이지 이동
$("a.data-change-page").on("click", function(e){
    e.preventDefault();
    let page = $(this).attr("href");
    let type = $("select[name=type]").val();
    let keyword = $("input[name=keyword]").val();
    location.href = `/admins/data/list?page=${page}`;
});

// 프로젝트 페이지 이동
$("a.project-change-page").on("click", function(e){
    e.preventDefault();
    let page = $(this).attr("href");
    let type = $("select[name=type]").val();
    let keyword = $("input[name=keyword]").val();
    location.href = `/admins/project/list?page=${page}`;
});

// 강연 페이지 이동
$("a.lecture-change-page").on("click", function(e){
    e.preventDefault();
    let page = $(this).attr("href");
    let type = $("select[name=type]").val();
    let keyword = $("input[name=keyword]").val();
    location.href = `/admins/lecture/list?page=${page}`;
});

// 회원 페이지 이동
$("a.member-change-page").on("click", function(e){
    e.preventDefault();
    let page = $(this).attr("href");
    let type = $("select[name=type]").val();
    let keyword = $("input[name=keyword]").val();
    location.href = `/admins/member/list?page=${page}`;
});

// 공지사항 페이지 이동
$("a.notice-change-page").on("click", function(e){
    e.preventDefault();
    let page = $(this).attr("href");
    let type = $("select[name=type]").val();
    let keyword = $("input[name=keyword]").val();
    location.href = `/admins/notice/list?page=${page}`;
});

// 공지사항 페이지 이동
$("a.inquiry-change-page").on("click", function(e){
    e.preventDefault();
    let page = $(this).attr("href");
    let type = $("select[name=type]").val();
    let keyword = $("input[name=keyword]").val();
    location.href = `/admins/inquiry/list?page=${page}`;
});