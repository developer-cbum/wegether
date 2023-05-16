// const banner = document.querySelector("div.banner");
// const image_divs = document.querySelectorAll("div.banner div.image");
// const first_div = document.querySelector("#first-temp");
// const last_div = document.querySelector("#last-temp");
// const prev = document.querySelector("div.prev");
// const next = document.querySelector("div.next");
// const dots = document.querySelectorAll("div.dot");
const $banner = $("div.banner");
const $image_divs = $("div.banner div.image");
const $first_div = $("#first-temp");
const $last_div = $("#last-temp");
const $prev = $("div.prev");
const $next = $("div.next");
const $dots = $("div.dot");
let count = 1;
let check = true;
let clickCheck = false;

// image_divs.forEach((image_div, i) => image_div.style.backgroundImage = `url(00${i + 1}.png)`);
// first_div.style.backgroundImage = `url(006.png)`;
// last_div.style.backgroundImage = `url(001.png)`;

$image_divs.each((i, image_div) => {$(image_div).css("background-image", `url(img/00${i + 1}.jpeg)`)});
$first_div.css("background-image", `url(img/00${$image_divs.length}.jpeg)`);
$last_div.css("background-image", `url(img/001.jpeg)`);

//인터벌 설정
// 인터벌 실행 될 때마다 count 증가, 슬라이드배너 실행(changeBanner)
// changeBanner를 정방향으로 실행(0)
// 2초 간격으로 인터벌 실행
let slide = setInterval(() => {++count, changeBanner(0)}, 2000);

changeButtonStyle();

// function changeButtonStyle(){
//     if(temp){
//         temp.style.background = "none";
//     }
//     temp = dots[count - 1];
//     dots[count - 1].style.background = "#313131";
//     clickCheck = true; //선택 버튼이 변경되는 순간 mouseout 이벤트 막기
// }

// 배너 하단부 도트 버튼 스타일 설정
function changeButtonStyle(){
    // 도트 색상 none으로 초기화
    $dots.css("background", "none");
    // 현재 위치한(count - 1 일때) 도트의 색상을 짙은회색으로 변경
    $dots.eq(count - 1).css("background-color", "#313131");
    clickCheck = true; //선택 버튼이 변경되는 순간 mouseout 이벤트 막기
}

// dots.forEach((dot, i) => {
//     dot.addEventListener("mouseover", () => {
//         clickCheck = dot.style.background == "rgb(49, 49, 49)";
//         dot.style.background = "#313131"
//     });
//     dot.addEventListener("mouseout", () => {
//         if(clickCheck){return;} 
//         dot.style.background = "none"
//     });

//     dot.addEventListener("click", () =>{
//         clickCheck = true;
//         clearInterval(slide);
//         count = dot.classList[1];
//         banner.style.transform = `translate(${-1500 * count}px)`;
//         banner.style.transition = "transform 0.7s"
//         changeButtonStyle();
//         slide = setInterval(() => autoSlide(), 2000);
//     });
// });

// $dots.each((i, dot) => {
//     let $dot = $(dot);

//     $dot.on("mouseover", () => {
//         clickCheck = $dot.css("background-color") == "rgb(49, 49, 49)";
//         $dot.css("background", "#313131");
//     });

//     $dot.on("mouseout", () => {
//         if(clickCheck){return;} 
//         $dot.css("background", "none");
//     });

//     $dot.on("click", () =>{
//         clickCheck = true;
//         clearInterval(slide);
//         count = $dot.prop("classList")[1];
//         $banner.css("transform", `translate(${-1500 * count}px)`);
//         $banner.css("transition", "transform 0.7s");
//         changeButtonStyle();
//         slide = setInterval(() => autoSlide(), 2000);
//     });
// });

// 도트에 마우스를 올렸다가 다시 뺐을 때(hover)
$dots.hover(function(){
    // clickCheck 초기화(true는 background-color가 짙은 회색일 때)
    clickCheck = $(this).css("background-color") == "rgb(49, 49, 49)";
    // 마우스를 올릴 때 색상 변경
    $(this).css("background", "#313131");
}, function(){
    // clickCheck이 true일 경우 아래 코드 실행 차단
    if(clickCheck){return;} 
    // background를 none으로 변경
    $(this).css("background", "none");
});

// $dots.on("click", function(){
//     clickCheck = true;
//     clearInterval(slide);
//     count = $(this).prop("classList")[1];
//     console.log(count);
//     $banner.css("transform", `translate(${-1500 * count}px)`);
//     $banner.css("transition", "transform 0.7s");
//     changeButtonStyle();
//     slide = setInterval(() => {++count, changeBanner(0)}, 2000);
// });

// 도트를 클릭하여 원하는 배너 위치로 이동하기
$dots.on("click", function(){
    // clickCheck을 true로 초기화
    clickCheck = true;
    // 인터벌 제거
    clearInterval(slide);
    // count를 도트의 위치만큼의 숫자로 변경(1~6)
    count = parseInt($(this).prop("classList")[1]);
    // changeBanner 실행
    changeBanner(0);
    // 인터벌 복구
    slide = setInterval(() => {++count, changeBanner(0)}, 2000);
});

// $prev.on("click", function(){
//     if(!check) {return;}
//     check = false;
//     clearInterval(slide);
//     $banner.css("transform", `translate(${-1500 * --count}px)`);
//     $banner.css("transition", "transform 0.7s");

//     if(count == 0) {
//         setTimeout(() => {
//             $banner.css("transition", "transform 0s");
//             $banner.css("transform", `translate(-9000px)`);
//         }, 700);
//         count = 6;
//     }
//     changeButtonStyle();
//     slide = setInterval(() => autoSlide(), 2000);
//     setTimeout(() => {check = true}, 700);
// });

// $next.on("click", function(){
//     if(!check) {return;}
//     check = false;
//     clearInterval(slide);
//     $banner.css("transform", `translate(${-1500 * ++count}px)`);
//     $banner.css("transition", "transform 0.7s");

//     if(count == 7) {
//         setTimeout(() => {
//             $banner.css("transition", "transform 0s");
//             $banner.css("transform", `translate(-1500px)`);
//         }, 700);
//         count = 1;
//     }
//     changeButtonStyle();
//     slide = setInterval(() => autoSlide(), 2000);
//     setTimeout(() => {check = true}, 700);
// });

// function autoSlide(){
//     check = false;
//     $banner.css("transform", `translate(${-1500 * ++count}px)`);
//     $banner.css("transition", "transform 0.7s");
    
//     if(count == 7) {
//         setTimeout(() => {
//             $banner.css("transition", "transform 0s");
//             $banner.css("transform", `translate(-1500px)`);
//         }, 700);
//         count = 1;
//     }
//     changeButtonStyle();
//     setTimeout(() => {
//         check = true;
//     }, 700);
// }

// 앞, 뒤 버튼
$(".arrow").on("click", function(){
    // check가 false면 이래 코드 실행 차단
    if(!check) {return;}
    // 다음 슬라이드로 넘어갈 때까지 앞,뒤로가기 버튼을 한 번만 클릭할 수 있도록
    // check를 다시 false로 초기화
    check = false;
    // 0: 정방향, 1: 역방향
    const arrow = {next: 0, prev: 1};
// 역방향 설정
// direction 변수에 next 혹은 prev을 담아준다
    let direction = arrow[$(this).prop("classList")[1]];
    // 인터벌 제거
    clearInterval(slide);
    // 역방향이면 count 1감소, 정방향이면 count 1 증가
    count += direction ? -1 : 1;
    // changeBanner를 next 혹은 prev으로 실행
    changeBanner(direction);
    // 인터벌 복구
    slide = setInterval(() => {++count, changeBanner(0)}, 2000);
});

// 정방향: 0, 역방향: 1
function changeBanner(direction){
    // check를 false로 초기화
    check = false;
    // 2차원 배열(0번째 방: 정방향, 1번째 방: 역방향)
    const array = [[7, -1500, 1], [0, -1500 * $image_divs.length, $image_divs.length]];
    // count 수만큼 배너를 한 칸씩 이동
    // 역방향일 경우 현재 count에서 -1 만큼 이동
    $banner.css("transform", `translate(${-1500 * count}px)`);
    // 배너 이동 시간 0.7초
    $banner.css("transition", "transform 0.7s");
    
    // count가 array 0번째 방의 0번째 칸과 같다면(7이라면)
    // 역방향의 경우 1번째 방의 0번째 칸과 같다면(0이라면)
    if(count == array[direction][0]) {
        setTimeout(() => {
            // 배너에서 -1500px 위치(array[0][1])로 이동
            // 역방향이라면 배너에서 제일 마지막 칸으로 이동
            $banner.css("transform", `translate(${array[direction][1]}px)`);
            // 0초만에 이동
            $banner.css("transition", "transform 0s");
            // 0.7초의 대기시간 후에
        }, 700);
        // count를 1로 조정(array[0][2])
        // 역방향의 경우 6으로 조정($image_divs.length)
        count = array[direction][2];
    }
    changeButtonStyle();
    // 슬라이드 배너가 실행중일 땐(0.7초) false
    // 넘어가고 나서는 true
    setTimeout(() => {
        check = true;
    }, 700);
}