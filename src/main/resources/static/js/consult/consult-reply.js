/*댓글*/

// 일단 댓글 등록버튼

const $div = $(".reply-content");
let page = 1;
let count = 0;
let text = "";
$(window).ready(function (){
    page= 1;
    load()
});

// textarea 값 넣기
$('.content-textarea').on("input", function () {
    $('.consult-content').val(`${$.trim($(this).val())}`)
})

//버튼 이벤트

$('.reply-button').on("click", function () {
    if ($('.content-textarea').val() == '') {
        showWarnModal("내용을 입력해주세요")
        return;
    }

    //댓글 등록
    registerReply();
    $(".total").text(`${total}`);
    $('.content-textarea').val("");

})

// 댓글 등록
function registerReply() {
    $.ajax({
        url  : '/replies/register',
        type : "post",
        data : JSON.stringify({
            "replyContent": $('#replyContent').val(),
            "consultingId": consultingId
        }),
        contentType: "application/json; charset=UTF-8;",
        success    : function (total) {
            $('.reviewWrite').hide();
                //댓글이 없습니다 숨기기
            $('.no-reply').hide();
                //    댓글 최신화
                text=""
                $(".total").text(`${total}`);
                page= 1;
                $div.html("");
                load()
        }
    })
}

//확인 버튼누를떄 대댓글등록
$(document).on('click', '.register-again-reply', function () {

    let $againReply = $(this).closest('.CommunityCommentItem_container__BOufe').find('.replyAgain-text-area');
    let $replyGroup = $(this).closest('.CommunityCommentItem_container__BOufe').find('.replyGroup');
    let $reviewWrite = $(this).closest('.CommunityCommentItem_container__BOufe').find('.reviewReviewWrite');
    let replyContent = $againReply.val();
    let replyGroup = $replyGroup.val();

    let id = $(this).attr("id");

    if(session == null){
        showWarnModal("로그인후 이용해주세요");
        return;
    }

    if($againReply.val()==""){
        showWarnModal("내용을 작성해주세요");
        return;
    }


    $.ajax({
        url        : '/replies/register-again',
        type       : "post",
        data       : JSON.stringify({
            "replyContent": replyContent,
            "consultingId": consultingId,
            "replyGroup"  : replyGroup
        }),
        contentType: "application/json; charset=UTF-8;",
        success    : function (total) {
            if(total == 0){
                $('.no-reply').show();
            }
            $againReply.val("");
            //    댓글 최신화
            text=""
            $div.html("");
            page= 1;
            $(".total").text(`${total}`);
            // 대댓글써도 댓글폼 유지
            load(id); //폼다시생성

        }

    });

});

//댓글 리스트


/*댓글 불러오기 ajax 함수*/
function load(id) {
    $.ajax({
        url     : `/replies/list/${consultingId}/${page}`,
        type    : 'get',
        success : function (result) {

            if(result.length == 0){
                $('.more-button').hide();
            }
            if (result) {
                console.log(result);
                $.ajax({
                    url     : `/replies/again-list/${consultingId}`,
                    type    : 'get',
                    success : function (resultResult) {

                        showList(result, resultResult, id);
                    }
                });
            }
        }
    });
}

//댓글 수정 버튼
$(document).on('click', '.modify-button-reply', function () {
    let id = $(this).attr("id");
    //수정폼
    let $replyForm = $(this).closest('.CommunityCommentItem_container__BOufe').find('.reply-form');
    //수정 내용 박스
    let $modifyReplyText = $(this).closest('.CommunityCommentItem_container__BOufe').find('.modify-reply-text');
    //수정버튼
    let $reviewWriteModify = $(this).closest('.CommunityCommentItem_container__BOufe').find('.reviewWrite-modify');
    //확인버튼
    let $modifyOkButton= $(this).closest('.CommunityCommentItem_container__BOufe').find('.modify-ok-button');
    //취소 버튼
    let $modifyButtonBack = $(this).closest('.CommunityCommentItem_container__BOufe').find('.modify-button-back');


    //수정폼 보이게 & 원래폼 숨기기
    $replyForm.hide();
    $reviewWriteModify.show();

    // 수정폼 숨기기
    $modifyButtonBack.on("click", ()=>{$replyForm.show(); $reviewWriteModify.hide();})

    //확인버튼 누르면 수정
    $modifyOkButton.on("click",function () {
        //수정된 내용
        let replyContent = $modifyReplyText.val();
        $.ajax({
            url : "/replies/modify",
            type: "put",
            data: JSON.stringify({
                replyContent :replyContent,
                id : id
            }),
            contentType: "application/json; charset=UTF-8;",
            success : function () {
                text=""
                $div.html("");
                page= 1;
                load();
                showWarnModal("수정되었습니다")
            }
        })

    })

});

// 대댓글 수정버튼
$(document).on('click', '.reply-again-modify', function () {
    let id = $(this).attr("id");
    //수정폼
    let $replyForm = $(this).closest('.CommunityCommentItem_container__BOufe').find('.reply-form');
    //수정 내용 박스
    let $modifyReplyText = $(this).closest('.CommunityCommentItem_container__BOufe').find('.modify-reply-text');
    //수정버튼
    let $reviewWriteModify = $(this).closest('.CommunityCommentItem_container__BOufe').find('.reviewWrite-modify');
    //확인버튼
    let $modifyOkButton= $(this).closest('.CommunityCommentItem_container__BOufe').find('.modify-ok-button');
    //취소 버튼
    let $modifyButtonBack = $(this).closest('.CommunityCommentItem_container__BOufe').find('.modify-button-back');

});


//댓글 삭제 삭제버튼
$(document).on('click', '.remove-button', function () {
    let id = $(this).attr("id");
    let secondId = $(this).attr("class").split(' ')[1];
    $.ajax({
        url     : `/replies/remove/${id}`,
        type    : 'delete',
        success : function (total) {
            console.log(total);
            text=""
            $div.html("");
            page= 1;
            $(".total").text(`${total}`);
            if(total == 0){
                $('.no-reply').show();
            }
            load(secondId);
            showWarnModal("삭제되었습니다");
        }

    });

});












/*밑에 긴 함수들-------------------------------*/

/*목록생성*/
function showList(result, replyResult, id) {

    //더보기 만들기
        if(result.length >= 5){
            console.log(result.length);
            console.log(result);
            $('.more-container').show();
        }else {
            $('.more-container').hide();
        }


    result.forEach(reply => {
        if(reply.replyDepth == 0){
        text += `
        <div class="CommunityCommentItem_container__BOufe">
                <div class="CommunityCommentItem_content__2N4Mb">
                    <div id="${reply.id}" class="CommentUserWrapper_container__10Bt- CommunityCommentContent_container__25oHX reply-form" style="margin-bottom: 15px">
                        <div class="CommentUserWrapper_avatar__1MYTO">
                            <a href="/web/wmypage/myprofile/fundinglist/732152617">
                                <div class="Avatar_avatar__1d9Wt" style="width: 40px; height: 40px">
                                    <span class="Avatar_hasImage__2TKl6" style="
                                            background-image:
                                                url('data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iODAiIGhlaWdodD0iODAiIHZpZXdCb3g9IjAgMCA4MCA4MCIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB4bWxuczp4bGluaz0iaHR0cDovL3d3dy53My5vcmcvMTk5OS94bGluayI+CiAgICA8ZGVmcz4KICAgICAgICA8cGF0aCBpZD0iYzl1cmF3eHIyYSIgZD0iTTAgMGg4MHY4MEgweiIvPgogICAgPC9kZWZzPgogICAgPGcgZmlsbD0ibm9uZSIgZmlsbC1ydWxlPSJldmVub2RkIj4KICAgICAgICA8Zz4KICAgICAgICAgICAgPG1hc2sgaWQ9IjZ2emt3OXN5NWIiIGZpbGw9IiNmZmYiPgogICAgICAgICAgICAgICAgPHVzZSB4bGluazpocmVmPSIjYzl1cmF3eHIyYSIvPgogICAgICAgICAgICA8L21hc2s+CiAgICAgICAgICAgIDxwYXRoIGQ9Ik04MCA0MGMwIDIyLjA5Mi0xNy45MDkgNDAtNDAgNDBTMCA2Mi4wOTIgMCA0MCAxNy45MDkgMCA0MCAwczQwIDE3LjkwOCA0MCA0MCIgZmlsbD0iI0U5RUNFRiIgbWFzaz0idXJsKCM2dnprdzlzeTViKSIvPgogICAgICAgIDwvZz4KICAgICAgICA8cGF0aCBkPSJtMjIuMzA1IDI2LjkxNC4yMyAyLjEyMWMtLjAxLjI5LjA0OS41NTkuMTgxLjgwNy4wODUuMjYxLjIyOC40ODUuNDMzLjY3Ni4xOS4yMDMuNDEzLjM0OC42NzQuNDMyLjI0OS4xMzIuNTE5LjE5MS44MDYuMThsLjU1Ny0uMDc1Yy4zNTUtLjA5OS42NjMtLjI3OS45MjQtLjUzN2wuMzI4LS40MjVjLjE5LS4zMjYuMjg1LS42OC4yODctMS4wNTgtLjA3OC0uNzA2LS4xNTQtMS40MTUtLjIzLTIuMTIxLjAxLS4yOS0uMDUtLjU1OS0uMTgtLjgwN2ExLjU3IDEuNTcgMCAwIDAtLjQzNC0uNjc1IDEuNTUzIDEuNTUzIDAgMCAwLS42NzQtLjQzMyAxLjU4NCAxLjU4NCAwIDAgMC0uODA3LS4xOGMtLjE4NS4wMjYtLjM3Mi4wNS0uNTU3LjA3NWEyLjA4MyAyLjA4MyAwIDAgMC0uOTI1LjUzOGwtLjMyNi40MjRjLS4xOS4zMjctLjI4NS42NzktLjI4NyAxLjA1OE01My44ODIgMjcuMzI4djIuNTIyYzAgLjUzOC4yMzMgMS4xMDIuNjEzIDEuNDgyLjE5LjIwMy40MTQuMzQ4LjY3NC40MzMuMjUuMTMuNTE4LjE5LjgwNy4xOC41NDItLjAyNCAxLjEwNC0uMjAyIDEuNDgxLS42MTMuMzc2LS40MS42MTQtLjkxNC42MTQtMS40ODJ2LTIuNTIyYzAtLjUzNi0uMjM0LTEuMS0uNjE0LTEuNDhhMS41NzYgMS41NzYgMCAwIDAtLjY3NC0uNDM0IDEuNTczIDEuNTczIDAgMCAwLS44MDctLjE4Yy0uNTQyLjAyNC0xLjEwNC4yMDItMS40ODEuNjE0LS4zNzYuNDA5LS42MTMuOTEzLS42MTMgMS40OE0zNi4yOTcgMjUuOTQ1Yy0uNzQzIDQuMzM1LTEuNDg0IDguNjczLTIuMjI1IDEzLjAxLS4xODQgMS4wNzUuMjg1IDIuMzA3IDEuNDYzIDIuNTc2IDEuMDE0LjIzIDIuMzc4LS4zMDkgMi41NzYtMS40NjJsMi4yMjUtMTMuMDExYy4xODQtMS4wNzUtLjI4NS0yLjMwOC0xLjQ2My0yLjU3Ny0xLjAxNS0uMjMtMi4zOC4zMDgtMi41NzYgMS40NjRNNDUuMTU4IDUwLjM4NmMtLjE2LS4zMy0uMTAxLS40NzctLjA0NS0uODA2LS4xMTEuMTc1LS4xMjUuMjAxLS4wNDIuMDc3YS4zNy4zNyAwIDAgMSAuMjAzLS4xNzhjLS4yMi4xMTctLjIzNS4xMzgtLjA0Ny4wNjRhMy40MyAzLjQzIDAgMCAxLS4zOTMuMTE2Yy0uMDgyLjAyLS42NTkuMS0uMjY1LjA1Ny0xLjExNS4xMjQtMi4yNC4xOS0zLjM2LjI4NWwtNi44NzcuNTc3Yy0xLjA4OS4wOTItMi4xNDguODk3LTIuMDk1IDIuMDk0LjA0OCAxLjA1Ni45MjYgMi4xOTIgMi4wOTUgMi4wOTNsOC44NC0uNzRjMS40NS0uMTIzIDMuMDQxLS4xMyA0LjI4Ny0uOTggMS42LTEuMDkzIDIuMTYzLTMuMDI4IDEuMzE2LTQuNzcyLS40OC0uOTktMS45NjYtMS4zMzMtMi44NjYtLjc1Mi0xLjAxMy42NTQtMS4yNjMgMS44MDctLjc1IDIuODY1IiBmaWxsPSIjQ0REM0Q4Ii8+CiAgICA8L2c+Cjwvc3ZnPgo=');
                                            border: 1px solid
                                                rgb(221, 226, 230);
                                        " ></span>
                                        </div>
                            </a>
                        </div>
                        <div class="CommentUserWrapper_main__2oHy1">
                            <div class="CommunityCommentContent_header__2y2W0">
                                    <div class="CommunityCommentContent_userInfo__2veqg CommentUserInfo_container__2G0cq">
                                        <span class="CommentUserInfo_name__3WGGI">
                                            <a href="/web/wmypage/myprofile/fundinglist/732152617">
                                                <strong>${reply.memberNickname}</strong>
                                            </a>
                                        </span>
                                        <span class="Badge_container__9G9PS Badge_visible__3LNXv CommentUserInfo_waffleBadge__2Oqhl">
                                        </span>
                                    <span class="CommentUserInfo_date__1ggwf">
                                                ${elapsedTime(reply.replyRegisterDate)}
                                    </span>
                                    </div>
                                <div class="CommunityCommentContent_moreWrap__3ans8">`
                                   // 수정 삭제 버튼
                                   if(reply.memberId == session){
                                       text+=     `<div class="PurchaseSummaryCard_detailText__2GWWi" style="display: flex">
                                                         <button id="${reply.id}" class="modify-button-reply">수정</button>
                                                         <span>&nbsp | &nbsp</span>
                                                         <button id="${reply.id}" class="remove-button">삭제</button>
                                                    </div>`
                                   }

                         text+=     `        
                                </div>
                            </div>
                            <div>
                                <div class="CommentTextContent_container__3EM7N">
                                    <div class="CommentTextContent_contentBox__uvt_R">
                                        ${reply.replyContent}<br/>
                                    </div>
                                </div>
                            </div>
                            <div class="CommunityCommentContent_bottom__-IKRP CommunityCommentContent_noReply__1c4Cz">
                                <button id="btn" class="Button_button__2FuOU Button_secondary__LNLsN Button_sm__16X6h CommunityCommentContent_replyBtn__2T16c reviewReviewButton" type="button">
                                    <span><span class="Button_children__ilFun">답글 `
                            for(let i = 0; i < replyResult.length; i++) {
                                if (reply.id == replyResult[i].replyGroup && replyResult[i].replyDepth == 1) {
                                    ++count;
                                }
                            }
                                   text+=  `${count}`
                                text+=` </span></span>
                                </button>
                            </div>
                            <div class="CommunityCommentContent_utils__oo7sJ"
                            ></div>
                        </div>
                    </div>
                                          <!--                  수정폼          -->
                         <div class = "CommunityCommentReplyWriteForm_container__10W0O reviewWrite-modify" style = "display: none; margin-bottom:0px">
                                <div class = "CommentUserWrapper_container__10Bt-">
                                    <div class = "CommentUserWrapper_avatar__1MYTO">
                                            <a href = "/web/wmypage/myprofile/fundinglist/">
                                                <div class = "Avatar_avatar__1d9Wt" style = "width: 36px; height: 36px">
                                                    <span class = "Avatar_hasImage__2TKl6" style = "background-image:
                                                            url('data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iODAiIGhlaWdodD0iODAiIHZpZXdCb3g9IjAgMCA4MCA4MCIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB4bWxuczp4bGluaz0iaHR0cDovL3d3dy53My5vcmcvMTk5OS94bGluayI+CiAgICA8ZGVmcz4KICAgICAgICA8cGF0aCBpZD0iYzl1cmF3eHIyYSIgZD0iTTAgMGg4MHY4MEgweiIvPgogICAgPC9kZWZzPgogICAgPGcgZmlsbD0ibm9uZSIgZmlsbC1ydWxlPSJldmVub2RkIj4KICAgICAgICA8Zz4KICAgICAgICAgICAgPG1hc2sgaWQ9IjZ2emt3OXN5NWIiIGZpbGw9IiNmZmYiPgogICAgICAgICAgICAgICAgPHVzZSB4bGluazpocmVmPSIjYzl1cmF3eHIyYSIvPgogICAgICAgICAgICA8L21hc2s+CiAgICAgICAgICAgIDxwYXRoIGQ9Ik04MCA0MGMwIDIyLjA5Mi0xNy45MDkgNDAtNDAgNDBTMCA2Mi4wOTIgMCA0MCAxNy45MDkgMCA0MCAwczQwIDE3LjkwOCA0MCA0MCIgZmlsbD0iI0U5RUNFRiIgbWFzaz0idXJsKCM2dnprdzlzeTViKSIvPgogICAgICAgIDwvZz4KICAgICAgICA8cGF0aCBkPSJtMjIuMzA1IDI2LjkxNC4yMyAyLjEyMWMtLjAxLjI5LjA0OS41NTkuMTgxLjgwNy4wODUuMjYxLjIyOC40ODUuNDMzLjY3Ni4xOS4yMDMuNDEzLjM0OC42NzQuNDMyLjI0OS4xMzIuNTE5LjE5MS44MDYuMThsLjU1Ny0uMDc1Yy4zNTUtLjA5OS42NjMtLjI3OS45MjQtLjUzN2wuMzI4LS40MjVjLjE5LS4zMjYuMjg1LS42OC4yODctMS4wNTgtLjA3OC0uNzA2LS4xNTQtMS40MTUtLjIzLTIuMTIxLjAxLS4yOS0uMDUtLjU1OS0uMTgtLjgwN2ExLjU3IDEuNTcgMCAwIDAtLjQzNC0uNjc1IDEuNTUzIDEuNTUzIDAgMCAwLS42NzQtLjQzMyAxLjU4NCAxLjU4NCAwIDAgMC0uODA3LS4xOGMtLjE4NS4wMjYtLjM3Mi4wNS0uNTU3LjA3NWEyLjA4MyAyLjA4MyAwIDAgMC0uOTI1LjUzOGwtLjMyNi40MjRjLS4xOS4zMjctLjI4NS42NzktLjI4NyAxLjA1OE01My44ODIgMjcuMzI4djIuNTIyYzAgLjUzOC4yMzMgMS4xMDIuNjEzIDEuNDgyLjE5LjIwMy40MTQuMzQ4LjY3NC40MzMuMjUuMTMuNTE4LjE5LjgwNy4xOC41NDItLjAyNCAxLjEwNC0uMjAyIDEuNDgxLS42MTMuMzc2LS40MS42MTQtLjkxNC42MTQtMS40ODJ2LTIuNTIyYzAtLjUzNi0uMjM0LTEuMS0uNjE0LTEuNDhhMS41NzYgMS41NzYgMCAwIDAtLjY3NC0uNDM0IDEuNTczIDEuNTczIDAgMCAwLS44MDctLjE4Yy0uNTQyLjAyNC0xLjEwNC4yMDItMS40ODEuNjE0LS4zNzYuNDA5LS42MTMuOTEzLS42MTMgMS40OE0zNi4yOTcgMjUuOTQ1Yy0uNzQzIDQuMzM1LTEuNDg0IDguNjczLTIuMjI1IDEzLjAxLS4xODQgMS4wNzUuMjg1IDIuMzA3IDEuNDYzIDIuNTc2IDEuMDE0LjIzIDIuMzc4LS4zMDkgMi41NzYtMS40NjJsMi4yMjUtMTMuMDExYy4xODQtMS4wNzUtLjI4NS0yLjMwOC0xLjQ2My0yLjU3Ny0xLjAxNS0uMjMtMi4zOC4zMDgtMi41NzYgMS40NjRNNDUuMTU4IDUwLjM4NmMtLjE2LS4zMy0uMTAxLS40NzctLjA0NS0uODA2LS4xMTEuMTc1LS4xMjUuMjAxLS4wNDIuMDc3YS4zNy4zNyAwIDAgMSAuMjAzLS4xNzhjLS4yMi4xMTctLjIzNS4xMzgtLjA0Ny4wNjRhMy40MyAzLjQzIDAgMCAxLS4zOTMuMTE2Yy0uMDgyLjAyLS42NTkuMS0uMjY1LjA1Ny0xLjExNS4xMjQtMi4yNC4xOS0zLjM2LjI4NWwtNi44NzcuNTc3Yy0xLjA4OS4wOTItMi4xNDguODk3LTIuMDk1IDIuMDk0LjA0OCAxLjA1Ni45MjYgMi4xOTIgMi4wOTUgMi4wOTNsOC44NC0uNzRjMS40NS0uMTIzIDMuMDQxLS4xMyA0LjI4Ny0uOTggMS42LTEuMDkzIDIuMTYzLTMuMDI4IDEuMzE2LTQuNzcyLS40OC0uOTktMS45NjYtMS4zMzMtMi44NjYtLjc1Mi0xLjAxMy42NTQtMS4yNjMgMS44MDctLjc1IDIuODY1IiBmaWxsPSIjQ0REM0Q4Ii8+CiAgICA8L2c+Cjwvc3ZnPgo=');
                                                            border: 1px solid rgb(221, 226, 230);">
                            
                                                    </span>
                                                 </div>
                                              </a>
                                      </div>
                                            <div class="CommentUserWrapper_main__2oHy1">
                                                <div class="CommunityCommentReplyWriteForm_writeForm__2YHmv">
                                                     <form id="reply-modify" action = "" method = "post"
                                                                class="CommentForm_container__2bT5x CommentForm_fold__20KZS">
                                                                <div class="CommunityCommentContent_userInfo__2veqg CommentUserInfo_container__2G0cq">
                                                                    <span class="CommentUserInfo_name__3WGGI">
                                                                        <a href="#">
                                                                            <strong>${reply.memberNickname}</strong>
                                                                        </a>
                                                                    </span>
                                                                </div>
                                                         <div class="CommentForm_textarea__yw5Av" >
                                                                <textarea
                                                                        placeholder = "내용을 입력해 주세요."
                                                                        maxlength = "500"
                                                                        rows = "2"
                                                                        class="Textarea_textarea__2EtST modify-reply-text">${reply.replyContent}</textarea>
                                                        </div>
                                                     </form>
                                                 </div>
                                            </div>
                                        <div style ="display: flex; justify-content: flex-end">
                                            <div style ="text-align: right; margin-top: 10px">
                                                <button class="Button_button__2FuOU Button_primary__2mZni Button_md__46Ai- modify-button"
                                                    type="button">
                                                    <span>
                                                        <span class="Button_children__ilFun modify-ok-button">확인</span>
                                                    </span>
                                                 </button>
                                            </div>
                                         <div style = "text-align: right; margin-top: 10px" >
                                                    <button class="Button_button__2FuOU Button_primary__2mZni Button_md__46Ai- modify-button-back" type = "button"
                                                            style="margin-left: 10px">
                                                            <span>
                                                                <span class ="Button_children__ilFun">취소</span>
                                                            </span>
                                                    </button>
                                          </div>
                                     </div>
                                   </div>
                                </div>
<!--                  ------          -->
                </div>`
                if (id) {
                    console.log("------------------")
                    console.log("아이디")
                    console.log(id)
                    console.log(reply)
                    console.log(replyResult);
                    if (reply.id == id || reply.replyGroup == id) {
                        console.log("1들어옴");
                        text += `<div id="${reply.id}" class="CommunityCommentItem_replyContent__3UQ-7 reviewReviewWrite ${reply.replyGroup}" style="display: block">`;
                    } else {
                        console.log("2들어옴");
                        text += `<div id="${reply.id}" class="CommunityCommentItem_replyContent__3UQ-7 reviewReviewWrite" style="display: none">`;
                    }
                } else {
                    text += `<div id="${reply.id}" class="CommunityCommentItem_replyContent__3UQ-7 reviewReviewWrite" style="display: none">`;
                }


            for(let i = 0; i < replyResult.length; i++) {

                if (reply.id == replyResult[i].replyGroup && replyResult[i].replyDepth == 1) { count=0;
                    text += `
                  <div class="CommunityCommentReplyContent_container__ImfPm"  >
                <div class="CommentUserWrapper_container__10Bt-">
                    <div class="CommentUserWrapper_avatar__1MYTO">
                        <a href="/web/maker/detail/3701904">
                            <div class="Avatar_avatar__1d9Wt" style="
                                    width: 36px;
                                    height: 36px;
                                ">
                                <span class="Avatar_hasImage__2TKl6"></span>
                            </div>
                        </a>
                    </div>
                    <divclass="CommentUserWrapper_main__2oHy1">
                        <div style="display: flex">
                        <div class="CommentUserInfo_container__2G0cq">
                                    <span class="CommentUserInfo_name__3WGGI">
                                            <a href="/web/maker/detail/3701904">
                                                <strong
                                                >${replyResult[i].memberNickname}
                                                </strong>
                                            </a>
                                     </span>
                                         <span
                                            class="Badge_container__9G9PS Badge_visible__3LNXv CommentUserInfo_waffleBadge__2Oqhl">
                                        </span>
                                     <span class="CommentUserInfo_date__1ggwf">${elapsedTime(replyResult[i].replyRegisterDate)}</span>
                            </div>
                            <div>`
                                   //수정버튼
                                   if(replyResult[i].memberId == session){
                                       text+= ` <div class="PurchaseSummaryCard_detailText__2GWWi" style="display: flex">
                                                         <button class="reply-again-modify">수정</button>
                                                         <span>&nbsp | &nbsp</span>
                                                         <button id="${replyResult[i].id}" class="remove-button ${reply.id}">삭제</button>
                                                    </div>`
                                   }
                        text+=  `</div>
                        </div>
                        <div>
                            <div class="CommentTextContent_container__3EM7N">
                                <div class="CommentTextContent_contentBox__uvt_R">
                                   ${replyResult[i].replyContent}
                                </div>
                            </div>
                        </div>
                        <div
                                class="CommunityCommentReplyContent_utils__-Na0q"
                        ></div>
                    </div>
                </div>
           `
                }
                <!--      답글작성창-->
            }
         text+=  `<!--답글작성-->
            <div class="CommunityCommentReplyListContainer_container__1waBy">
                     <div class="CommentReplyList_container__2phlF">
                            <div class="CommunityCommentReplyWriteForm_container__10W0O">
                                <div class="CommentUserWrapper_container__10Bt-">
                                    <div class="CommentUserWrapper_avatar__1MYTO">
                                        <a href="/web/wmypage/myprofile/fundinglist/">
                                            <div class="Avatar_avatar__1d9Wt" style="
                                                    width: 36px;
                                                    height: 36px;
                                                ">
                                                <span></span></div>
                                        </a>
                                    </div>
                                    <div class="CommentUserWrapper_main__2oHy1">
                                        <div class="CommunityCommentReplyWriteForm_writeForm__2YHmv">
                                            <textarea
                                                    name="replyContent"
                                                    placeholder="내용을 입력해 주세요."
                                                    maxlength="2000"
                                                    rows="2"
                                                    class="Textarea_textarea__2EtST replyAgain-text-area"
                                            ></textarea>
                                            <input class="replyGroup" name="replyGroup" type="hidden" value="${reply.replyGroup}">
                                            <div style="
                                                    text-align: right;
                                                    margin-top: 10px;
                                                " >
                                                <div style="
                                                        display: flex;
                                                        justify-content: flex-end;
                                                    ">
                                                    <div style="
                                                            text-align: right;
                                                            margin-top: 10px;
                                                        ">
                                                        <button id="${reply.id}" class="Button_button__2FuOU Button_primary__2mZni Button_md__46Ai- register-again-reply" type="button">
                                                            <span
                                                            ><span
                                                                    class="Button_children__ilFun"
                                                            >확인</span
                                                            ></span
                                                            >
                                                        </button>
                                                    </div>
                                                    <div style="
                                                            text-align: right;
                                                            margin-top: 10px;
                                                        ">
                                                        <button
                                                                class="Button_button__2FuOU Button_primary__2mZni Button_md__46Ai- reviewReviewButtonBack"
                                                                type="button"
                                                                style="
                                                                margin-left: 10px;
                                                            ">
                                                            <span
                                                            ><span class="Button_children__ilFun">취소</span>
                                                            </span >
                                                        </button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <hr class="Divider_divider__ToZaf Divider_horizontal__3W5eD Divider_lightBG__3bAAk Divider_spacing6__8L6D1 Divider_caption2__3b6Dr"
                />
            </div>
            </div>
                ` }



    });

    //답글
    $div.append(text);
}

//방금전
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


$(function () {
    <!-- 리뷰 버튼, 답글 버튼 관련 -->
    $('.reviewButton').on('click', function () {
        if (session == null) {
            showWarnModal("로그인 후 이용해주세요");
            return
        }
        $('.reviewWrite').show();
    });

    $('.reviewButtonBack').on('click', function () {
        $('.reviewWrite').hide();
    });
});



//답글 버튼눌렀을때
    $(document).on('click', '.reviewReviewButton', function () {
        let reviewWriteElement = $(this).closest('.CommunityCommentItem_container__BOufe').find('.reviewReviewWrite');
        let $replyGroup = $(this).closest('.CommunityCommentItem_container__BOufe').find('.replyGroup');
        let replyGroup = $replyGroup.val();
        $('.reviewReviewWrite').hide();
        reviewWriteElement.show();



    });

    $(document).on('click', '.reviewReviewButtonBack', function () {
        console.log("들어옴")
        let reviewWriteCancle = $(this).closest('.CommunityCommentItem_container__BOufe').find('.reviewReviewWrite');
        console.log(reviewWriteCancle);
        reviewWriteCancle.hide();
        reviewWriteCancle.val("");
    });



    //더보기클릭
$('.more-button').on("click", function () {
    $div.html("");
    page++;
    load();
})

// let test =
// `
// <div class = "CommunityCommentReplyWriteForm_container__10W0O reviewWrite" style = "display: none">
//     <div class = "CommentUserWrapper_container__10Bt-">
//         <div class = "CommentUserWrapper_avatar__1MYTO">
//                 <a href = "/web/wmypage/myprofile/fundinglist/">
//                     <div class = "Avatar_avatar__1d9Wt" style = "width: 36px; height: 36px">
//                         <span class = "Avatar_hasImage__2TKl6" style = "background-image:
//                                 url('data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iODAiIGhlaWdodD0iODAiIHZpZXdCb3g9IjAgMCA4MCA4MCIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB4bWxuczp4bGluaz0iaHR0cDovL3d3dy53My5vcmcvMTk5OS94bGluayI+CiAgICA8ZGVmcz4KICAgICAgICA8cGF0aCBpZD0iYzl1cmF3eHIyYSIgZD0iTTAgMGg4MHY4MEgweiIvPgogICAgPC9kZWZzPgogICAgPGcgZmlsbD0ibm9uZSIgZmlsbC1ydWxlPSJldmVub2RkIj4KICAgICAgICA8Zz4KICAgICAgICAgICAgPG1hc2sgaWQ9IjZ2emt3OXN5NWIiIGZpbGw9IiNmZmYiPgogICAgICAgICAgICAgICAgPHVzZSB4bGluazpocmVmPSIjYzl1cmF3eHIyYSIvPgogICAgICAgICAgICA8L21hc2s+CiAgICAgICAgICAgIDxwYXRoIGQ9Ik04MCA0MGMwIDIyLjA5Mi0xNy45MDkgNDAtNDAgNDBTMCA2Mi4wOTIgMCA0MCAxNy45MDkgMCA0MCAwczQwIDE3LjkwOCA0MCA0MCIgZmlsbD0iI0U5RUNFRiIgbWFzaz0idXJsKCM2dnprdzlzeTViKSIvPgogICAgICAgIDwvZz4KICAgICAgICA8cGF0aCBkPSJtMjIuMzA1IDI2LjkxNC4yMyAyLjEyMWMtLjAxLjI5LjA0OS41NTkuMTgxLjgwNy4wODUuMjYxLjIyOC40ODUuNDMzLjY3Ni4xOS4yMDMuNDEzLjM0OC42NzQuNDMyLjI0OS4xMzIuNTE5LjE5MS44MDYuMThsLjU1Ny0uMDc1Yy4zNTUtLjA5OS42NjMtLjI3OS45MjQtLjUzN2wuMzI4LS40MjVjLjE5LS4zMjYuMjg1LS42OC4yODctMS4wNTgtLjA3OC0uNzA2LS4xNTQtMS40MTUtLjIzLTIuMTIxLjAxLS4yOS0uMDUtLjU1OS0uMTgtLjgwN2ExLjU3IDEuNTcgMCAwIDAtLjQzNC0uNjc1IDEuNTUzIDEuNTUzIDAgMCAwLS42NzQtLjQzMyAxLjU4NCAxLjU4NCAwIDAgMC0uODA3LS4xOGMtLjE4NS4wMjYtLjM3Mi4wNS0uNTU3LjA3NWEyLjA4MyAyLjA4MyAwIDAgMC0uOTI1LjUzOGwtLjMyNi40MjRjLS4xOS4zMjctLjI4NS42NzktLjI4NyAxLjA1OE01My44ODIgMjcuMzI4djIuNTIyYzAgLjUzOC4yMzMgMS4xMDIuNjEzIDEuNDgyLjE5LjIwMy40MTQuMzQ4LjY3NC40MzMuMjUuMTMuNTE4LjE5LjgwNy4xOC41NDItLjAyNCAxLjEwNC0uMjAyIDEuNDgxLS42MTMuMzc2LS40MS42MTQtLjkxNC42MTQtMS40ODJ2LTIuNTIyYzAtLjUzNi0uMjM0LTEuMS0uNjE0LTEuNDhhMS41NzYgMS41NzYgMCAwIDAtLjY3NC0uNDM0IDEuNTczIDEuNTczIDAgMCAwLS44MDctLjE4Yy0uNTQyLjAyNC0xLjEwNC4yMDItMS40ODEuNjE0LS4zNzYuNDA5LS42MTMuOTEzLS42MTMgMS40OE0zNi4yOTcgMjUuOTQ1Yy0uNzQzIDQuMzM1LTEuNDg0IDguNjczLTIuMjI1IDEzLjAxLS4xODQgMS4wNzUuMjg1IDIuMzA3IDEuNDYzIDIuNTc2IDEuMDE0LjIzIDIuMzc4LS4zMDkgMi41NzYtMS40NjJsMi4yMjUtMTMuMDExYy4xODQtMS4wNzUtLjI4NS0yLjMwOC0xLjQ2My0yLjU3Ny0xLjAxNS0uMjMtMi4zOC4zMDgtMi41NzYgMS40NjRNNDUuMTU4IDUwLjM4NmMtLjE2LS4zMy0uMTAxLS40NzctLjA0NS0uODA2LS4xMTEuMTc1LS4xMjUuMjAxLS4wNDIuMDc3YS4zNy4zNyAwIDAgMSAuMjAzLS4xNzhjLS4yMi4xMTctLjIzNS4xMzgtLjA0Ny4wNjRhMy40MyAzLjQzIDAgMCAxLS4zOTMuMTE2Yy0uMDgyLjAyLS42NTkuMS0uMjY1LjA1Ny0xLjExNS4xMjQtMi4yNC4xOS0zLjM2LjI4NWwtNi44NzcuNTc3Yy0xLjA4OS4wOTItMi4xNDguODk3LTIuMDk1IDIuMDk0LjA0OCAxLjA1Ni45MjYgMi4xOTIgMi4wOTUgMi4wOTNsOC44NC0uNzRjMS40NS0uMTIzIDMuMDQxLS4xMyA0LjI4Ny0uOTggMS42LTEuMDkzIDIuMTYzLTMuMDI4IDEuMzE2LTQuNzcyLS40OC0uOTktMS45NjYtMS4zMzMtMi44NjYtLjc1Mi0xLjAxMy42NTQtMS4yNjMgMS44MDctLjc1IDIuODY1IiBmaWxsPSIjQ0REM0Q4Ii8+CiAgICA8L2c+Cjwvc3ZnPgo=');
//                                 border: 1px solid rgb(221, 226, 230);">
//
//                         </span>
//                      </div>
//                   </a>
//           </div>
//                 <div class="CommentUserWrapper_main__2oHy1">
//                     <div class="CommunityCommentReplyWriteForm_writeForm__2YHmv">
//                          <form id = "reply" th:action = "@{/replies/register}" method = "post" th:object = "${consultReplyDTO}"
//                                     class="CommentForm_container__2bT5x CommentForm_fold__20KZS">
//                              <div class="CommentForm_textarea__yw5Av" >
//                                     <textarea th:field = "*{replyContent}"
//                                             placeholder = "내용을 입력해 주세요."
//                                             maxlength = "5000"
//                                             rows = "2"
//                                             class="Textarea_textarea__2EtST content-textarea">
//                                     </textarea>
//                             </div>
//                          </form>
//                      </div>
//                 </div>
//             <div style ="display: flex; justify-content: flex-end">
//                 <div style ="text-align: right; margin-top: 10px">
//                     <button class="Button_button__2FuOU Button_primary__2mZni Button_md__46Ai- reply-button"
//                         type="button">
//                         <span>
//                             <span class="Button_children__ilFun">확인</span>
//                         </span>
//                      </button>
//                 </div>
//              <div style = "text-align: right; margin-top: 10px" >
//                         <button class="Button_button__2FuOU Button_primary__2mZni Button_md__46Ai- reviewButtonBack" type = "button"
//                                 style="margin-left: 10px">
//                                 <span>
//                                     <span class ="Button_children__ilFun">취소</span>
//                                 </span>
//                         </button>
//               </div>
//          </div>
//        </div>
//     </div>`
