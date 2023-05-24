const $div = $(".reply-content");
let page = 1;
let count = 0;
let text = "";
$(window).ready(function (){
    page= 1;
    load()
});

//버튼 이벤트

$('.reply-button').on("click", function () {
    if ($('.content-textarea').val() == '') {
        showWarnModal("내용을 입력해주세요")
        return;
    }

    //댓글 등록
    registerReply();
    // $(".total").html(`${total}`);


})

// 댓글 등록
function registerReply() {
    $.ajax({
        url  : '/community-replies/register',
        type : "post",
        data : JSON.stringify({
            "replyContent": $('#replyContent').val(),
            "communityId": communityId
        }),
        contentType: "application/json; charset=UTF-8;",
        success    : function (int) {
            $('#replyContent').val("");
            $('.reviewWrite').hide();
            //    댓글 최신화
            text=""
            $(".total").text(`${total}`);
            page= 1;
            $div.html("");
            load()
        }
    })
}

function load() {
    $.ajax({
        url     : `/community-replies/list/${communityId}/${page}`,
        type    : 'get',
        success : function (result) {
            if(result.length == 0){
                $('.more-button').hide();
            }
            if (result) {
                console.log(result);
                $.ajax({
                    url     : `/community-replies/again-list/${communityId}`,
                    type    : 'get',
                    success : function (resultResult) {
                        console.log(resultResult)
                        showList(result, resultResult);

                    }
                });
            }
        }
    });
}


function showList(result, replyResult) {
    result.forEach(reply => {
        console.log(replyResult)
        if(reply.replyDepth == 0){
            text += `
        <div class="CommunityCommentItem_container__BOufe">
                <div class="CommunityCommentItem_content__2N4Mb">
                    <div class="CommentUserWrapper_container__10Bt- CommunityCommentContent_container__25oHX" style="margin-bottom: 15px">
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
                                <div class="CommunityCommentContent_moreWrap__3ans8">
                                    <svg viewBox="0 0 40 40" focusable="false" role="presentation"  class="withIcon_icon__3VTbq" aria-hidden="true">
                                        <path
                                                d="M24.52 5A4.52 4.52 0 1 0 20 9.57 4.53 4.53 0 0 0 24.52 5zm0 30A4.52 4.52 0 1 0 20 39.48 4.53 4.53 0 0 0 24.52 35zm0-15A4.52 4.52 0 1 0 20 24.52 4.53 4.53 0 0 0 24.52 20z"
                                        ></path>
                                    </svg>
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
                </div>
            <div class="CommunityCommentItem_replyContent__3UQ-7 reviewReviewWrite" style="display: none"
            >`
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