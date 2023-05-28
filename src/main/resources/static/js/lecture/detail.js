
let $container = $("#container");
let text ="";

 text +=`
  <div class="school-container">
        <div class="school-sub-con">
          <div class="school-title">
            <h3>[Wegether Lecture] ${lecture.lectureTitle}</h3>
            <p class="sub-text">교육 통합 커뮤니티 NO.1은 위게더</p>
          </div>
          <div class="school-summary">
            <div class="school-img-con">
            `
lecture.files.forEach((file) => {
    if(file.fileType == "NON_REPRESENTATIVE"){
        text += `
          <img src="/lecture-files/display?fileName=${file.filePath}/${file.fileUuid}_${file.fileName}" height="390" width="540"/>
          `
    }

})
    
  text+=`
            </div>

            <div class="school-sum-info">
              <dl>
                <dt>강의 날짜</dt>
                <dd>${lecture.lectureDate}</dd>
              </dl>
              <dl>
                <dt>강의 시간</dt>
                <dd>${lecture.lectureTime}</dd>
              </dl>
              <dl>
                <dt>강의 장소</dt>
                <dd style="overflow: hidden; white-space: nowrap; text-overflow: ellipsis">
                  ${lecture.lectureLocation}
                </dd>
              </dl>
              <dl>
                <dt>수강 인원</dt>
                <dd>${lecture.lectureTotalPersonnel}명</dd>
              </dl>
              <dl class="long set-num">
            <img src="/image/lecture/wegether_detail_banner.png">
              </dl>

            </div>
          </div>

          <div class="school-con">
            <ul class="school-tab">


              <div class="detailview">상세</div>
            </ul>
            <!-- 강의소개 -->
            <div id="tab-con1" class="tab-con" style="display: block; line-height: 27px"> `


            lecture.files.forEach(file => {
    if (file.fileType == "CONTENT_REPRESENTATIVE") {

        text += `
          <img src="/lecture-files/display?fileName=${file.filePath}/${file.fileUuid}_${file.fileName}" style="
                  width: 800px;
                  display: block;
                  vertical-align: top;
                  margin: 0px auto;
                  text-align: center;
                  border: none;
                  cursor: pointer;
                "/>
                <br><h3>${lecture.lectureContent}</h3>
          `
    }
})
          text+= `
            </div>
            <!-- 강사 소개 -->
            <div id="tab-con2" class="tab-con" style="line-height: 27px"></div>
            <!-- 오시는길 -->
            <style>
              #tab-con3 > table {
                width: auto;
              }
            </style>
            <div id="tab-con3" class="tab-con" style="line-height: 27px"></div>
          </div>
        </div>
      </div>
`

$container.html(text);