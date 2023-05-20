

let titleCheck = false;
let contentCheck= false;
let categoryCheck= false;

//input value 값주기
$(document).on("click", function () {
    $('.value').val(`${$.trim($('.menu-value').text())}`);
})

// textarea 값 넣기
$('.content-textarea').on("input", function () {
    $('.consult-content').val(`${$.trim($(this).val())}`)
})


// 유효성 버튼 검사
 $('#consultingTitle').on("keyup", function () {
     if($('.consult-content').val() != ''){
         categoryCheck =true;
     }else{
         categoryCheck =false;
     }

     if($(this).val() == ''){
         titleCheck=false;
     }else{
         titleCheck=true;
     }
     consultingFlag()


 })

$('.content-textarea').on("keyup", function () {

    if($('.consult-content').val() != ''){
        categoryCheck =true;
    } else{
        categoryCheck =false;
    }

    if($(this).val() == ''){
        contentCheck=false;
    }else{
        contentCheck=true;
    }

    consultingFlag()
})



function consultingFlag() {
    if(categoryCheck && contentCheck && titleCheck){
        $('.button_save').attr("disabled", false);
    }else{
        $('.button_save').attr("disabled", true);
    }
}

if($('.button_save').attr("disabled")){
    $('.button_save').on("click", function () {
        showWarnModal("상담이 등록되었습니다");

    })
}

$('.modal').on("click", function () {
    console.log("들어옴")
    $('.consulting-form').submit();
})




function lastok() {
    location.href = "./consult-main.html";
    // 마이페이지 이동
}
