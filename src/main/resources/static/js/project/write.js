const $upload = $("input.upload");
const $thumbnail = $("label.attach img.thumbnail");

$("img.preview").each(function(i){
    if(!$(this).attr("src")){
        $(this).hide();
    }
});

let sizes = new Array(4).fill(0);
$upload.on("change", function(e){
    let i = $upload.index($(this));
    let files = $(this)[0].files;
    let name = files[0].name;
    let formData = new FormData();

    sizes[i] = files[0].size;

    $(files).each((i, file) => {
        formData.append("uploadFile", file);
    });

    $.ajax({
        url: "/files/upload",
        type: "post",
        data: formData,
        contentType: false,
        processData: false,
        success: function(uuids){
            $("label.attach").eq(i).find("h6").hide();
            $("div.x").eq(i).show();
            $("img.thumbnail").eq(i).show();

            let now = new Date();
            let year = now.getFullYear();
            let month = now.getMonth() + 1;
            let date = now.getDate();

            month = month < 10 ? "0" + month : month;
            date = date < 10 ? "0" + date : date;

            let fileName = year + "/" + month + "/" + date + "/t_" + uuids[0] + "_" + name;
            $("img.thumbnail").eq(i).attr("src", `/files/display?fileName=${fileName}`);
        }
    });


});

$("div.x").on("click", function(e){
    e.preventDefault();
    let i = $("div.x").index($(this));
    sizes = sizes.splice(i, 1);
    $upload.eq(i).val("");
    $("label.attach").eq(i).find("h6").show();
    $("div.x").eq(i).hide();
    $thumbnail.eq(i).attr('src', "");
    $thumbnail.eq(i).hide();
});

$("span.ok-button").on("click", function(){

    let text = ``;
    if($("img.thumbnail").attr("src")){
        let datas = $("img.thumbnail").attr("src").split("_");
        let filePath = datas[0].split("=")[1].replace("/t", "");
        let fileUuid = datas[1];
        let fileName = datas[2];
        let fileType = $("img.thumbnail").hasClass("representative");
        let fileSize = sizes[0];

        text += `
            <input type="hidden" name="files[0].filePath" value="${filePath}">
            <input type="hidden" name="files[0].fileUuid" value="${fileUuid}">
            <input type="hidden" name="files[0].fileName" value="${fileName}">
            <input type="hidden" name="files[0].fileSize" value="${fileSize}">
        `
        if(fileType){
            text += `<input type="hidden" name="files[0].fileType" value="REPRESENTATIVE">`;
        }
        console.log(text);
        $("form[name='writeForm']").append(text);
        $("form[name='writeForm']").submit();
    }
});

