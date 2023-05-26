$("span.file-size").hide();

const $upload = $("input.upload");
const $thumbnail = $("label.attach img.thumbnail");
// 파일 사이즈
let sizes = new Array(4).fill(0);
//삭제용
const fileIdsForDelete = new Array();

//파일 사이즈 보여주기용 함수
function showSize(span){
    // 사이즈 0이면(파일이 없으면)
    if(span.text() == 0){
        //텍스트를 가린다
        span.hide();
    }else{
        span.show();
    }
}

//불러온 파일 forEach(파일과 인덱스값)
files.forEach((file, i) => {
    // label에 있는 글씨 지운다
    $("label.attach").eq(i).find("h6").hide();
    // i번쨰 x버튼 보이기
    $("div.x").eq(i).show();
    // i번쨰 썸네일 보이기
    $thumbnail.eq(i).show();

    // 파일 이름 선언 = 경로 + t_ + UUID + _ + 파일명
    let fileName = file.filePath + "/t_" + file.fileUuid + "_" + file.fileName;
    // 썸네일 이미지태그 속성에 파일명 추가
    $thumbnail.eq(i).attr("src", `/files/display?fileName=${fileName}`);
    // 기존에 있던 사진 칸에는 클래스명 "original" 추가
    $thumbnail.eq(i).addClass("original")
    // id 추가(데이터 컨트롤러로 넘기기용??"
    $thumbnail.eq(i).attr("data-id", file.id);
    // 각 칸의 파일 사이즈
    sizes[i] = (file.fileSize / 1024).toFixed(2);
    // 스판태그에 파일 사이즈 꽂기(킬로바이트 단위로 계산)
    $("span.file-size").eq(i).text((file.fileSize / 1024).toFixed(2) + "KB");
    //사이즈 보여주기 함수 호출
    showSize($("span.file-size").eq(i));
});

// 인풋태그 체인지 이벤트
$upload.on("change", function(e){
    // i = 업로드 인풋태그의 인덱스값
    let i = $upload.index($(this));
    let files = $(this)[0].files;
    // 인덱스에 있는 파일의 이름
    let name = files[0].name;
    //폼데이터
    let formData = new FormData();

    //파일 사이즈 정의
    sizes[i] = (files[0].size / 1024).toFixed(2);
    //킬로바이트 단위로 썸네일쪽 스판태그에서 보여주기
    $("span.file-size").eq(i).text(sizes[i] + "KB");
    //사이즈 보여주기 함수 호출
    showSize($("span.file-size").eq(i));

    //파일 반복문
    $(files).each((i, file) => {
        //업로드할  파일 불러오기
        formData.append("uploadFile", file);
    });

    //ajax 파일 업로드
    $.ajax({
        //경로 파일 업로드 컨트롤러로
        url: "/files/upload",
        //포스트 타입
        type: "post",
        //보낼 데이터: formData
        data: formData,
        contentType: false,
        processData: false,
        //uuid 뿌려주기
        success: function(uuids){
            //문구 숨기기
            $("label.attach").eq(i).find("h6").hide();
            //x버튼 보이기
            $("div.x").eq(i).show();
            //썸네일 보이기
            $("img.thumbnail").eq(i).show();

            //날짜(경로 관련)
            let now = new Date();
            let year = now.getFullYear();
            let month = now.getMonth() + 1;
            let date = now.getDate();

            month = month < 10 ? "0" + month : month;
            date = date < 10 ? "0" + date : date;

            // 날짜, uuid, 파일명 붙여넣기
            let fileName = year + "/" + month + "/" + date + "/t_" + uuids[0] + "_" + name;
            // 썸네일 src에 파일 경로 꽂기
            $("img.thumbnail").eq(i).attr("src", `/files/display?fileName=${fileName}`);
        }
    });
});

// x버튼 눌렀을 때
$("div.x").on("click", function(e){
    //이벤트 일단 막기
    e.preventDefault();
    // i = x쪽 배열 인덱스에 있는 값
    let i = $("div.x").index($(this));
    //파일 사이즈
    sizes[i] = 0;
    //스판태그에 있는 사이즈 0으로 초기화
    $("span.file-size").eq(i).text(sizes[i]);
    // 사이즈 보여주기
    showSize($("span.file-size").eq(i));
    // 업로드 밸류 비우기
    $upload.eq(i).val("")
    //사진 없는 상태로 원상복구
    $("label.attach").eq(i).find("h6").show();
    $("div.x").eq(i).hide();
    $thumbnail.eq(i).attr('src', "");
    $thumbnail.eq(i).hide();

    //썸네일에 original 클래스가 있다면
    if($thumbnail.eq(i).hasClass("original")){
        fileIdsForDelete.push($thumbnail.eq(i).data("id"));
    }
    //"original" 클래스 없애기
    $thumbnail.eq(i).removeClass("original");
});

// 제출 버튼
$("button.ok-button").on("click", function(){
    //썸네일에 있는 사진 반복, 이미지 src 속성이면서 original 클래스가 아닌 것(기존 사진)
    const imgs = $("img.thumbnail").filter((i, img) => $(img).attr("src") && !$(img).hasClass("original"));
    let text = ``;
    // 업로드할 파일 input태그 생성하기
    imgs.each((i, img) => {
        let fullPath = $(img).attr("src");
        let datas = fullPath.split("_");
        let filePath = datas[0].split("=")[1].replace("/t", "");
        let fileUuid = datas[1];
        let fileName = datas[2];
        let fileSize = sizes[i];
        console.log(sizes[i]);

        text += `
            <input type="hidden" name="files[${i}].filePath" value="${filePath}">
            <input type="hidden" name="files[${i}].fileUuid" value="${fileUuid}">
            <input type="hidden" name="files[${i}].fileName" value="${fileName}">
            <input type="hidden" name="files[${i}].fileSize" value="${fileSize}">
        `;
        //0번째 방에 대표사진 넣기
        if(i == 0){
            text +=`<input type="hidden" name="files[${i}].fileType" value="REPRESENTATIVE">`
        }
    });
    // 삭제할 파일들
    // 삭제용 태그 생성하여 담기
    fileIdsForDelete.forEach((id, i) => {
        text += `<input type="hidden" name="fileIdsForDelete[${i}]" value="${id}">`;
    })

    //작성폼에 어펜드
    $(writeForm).append(text);
    //제출
    $(writeForm).submit();
});
