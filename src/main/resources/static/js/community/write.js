$upload.on("change", function(e){
    let i = $upload.index($(this));
    var reader = new FileReader();
    reader.readAsDataURL(e.target.files[0]);
    reader.onload = function(e){
        let url = e.target.result;
        if(url.includes('image')){
            $("label.attach").eq(i).find("h6").hide();
            $("div.x").eq(i).show();
            $thumbnail.eq(i).show();
            $thumbnail.eq(i).attr('src', url);
        }else{
            showWarnModal("이미지 파일만 등록 가능합니다.");
        }
    }
});