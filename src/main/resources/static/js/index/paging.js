// 검색 페이지 이동
$("a.notice-change-page").on("click", function(e){
    e.preventDefault();
    let page = $(this).attr("href");
    let type = $("select[name=type]").val();
    let keyword = $("input[name=keyword]").val();
    location.href = `/index/search-list?page=${page}`;
});

