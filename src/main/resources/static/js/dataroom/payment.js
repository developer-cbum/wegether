$(function () {
    console.log(data);








}); //E





// const firstForm = document.querySelector('.StorePaymentInformation_mobileAuthContainer__2oKm2 form:first-child');
// const secondForm = document.querySelector('.StorePaymentInformation_mobileAuthContainer__2oKm2 form:last-child');
// const phoneInput = firstForm.querySelector('input[name="userPhone"]');
// const authCodeInput = secondForm.querySelector('input[name="authCode"]');
//
//
// // 첫번째 폼 submit 이벤트 리스너
// firstForm.addEventListener('submit', e => {
//     e.preventDefault();
//     const phoneNum = phoneInput.value
//     if (!/^[0-9]{10,11}$/.test(phoneNum)) {
//         phoneInput.classList.add('Input_error__ADOWg'); // 유효성 검사에 실패하면 에러 스타일 적용
//         firstForm.querySelector('.MobileAuthField_error__29I4S').style.display = 'block'; // 에러 메시지 출력
//         firstForm.querySelector('.MobileAuthField_error__29I4S + p').style.display = 'none';
//     } else {
//         secondForm.style.display = 'block'; // 두번째 폼 보이기
//         const seconds = 180; // 인증번호 유효시간
//         let remainSeconds = seconds;
//         const countElem = secondForm.querySelector('.MobileAuthField_count__cBcmt');
//         countElem.innerText = `${Math.floor(remainSeconds / 60)}:${remainSeconds % 60 < 10 ? '0' : ''}${remainSeconds % 60}`;
//         const intervalId = setInterval(() => {
//             remainSeconds--;
//             if (remainSeconds <= 0) {
//                 clearInterval(intervalId);
//                 secondForm.querySelector('.MobileAuthField_helperMessage__3sZnE.MobileAuthField_error__29I4S').style.display = 'block'; // 인증번호 유효시간 초과 메시지 출력
//                 secondForm.querySelector('.MobileAuthField_cta__3SLeA').disabled = true; // 인증하기 버튼 비활성화
//             } else {
//                 countElem.innerText = `${Math.floor(remainSeconds / 60)}:${remainSeconds % 60 < 10 ? '0' : ''}${remainSeconds % 60}`;
//             }
//         }, 1000);
//     }
// });
//
// // 두번째 폼 submit 이벤트 리스너
// secondForm.addEventListener('submit', e => {
//     e.preventDefault();
//     const authCode = authCodeInput.value;
//     if (!/^\d{6}$/.test(authCode)) {
//         authCodeInput.classList.add('Input_error__ADOWg'); // 유효성 검사에 실패하면 에러 스타일 적용
//         secondForm.querySelector('.MobileAuthField_error__29I4S').style.display = 'block'; // 에러 메시지 출력
//     } else {
//         // 인증 성공 처리
//     }
// });
//
// // 전화번호 입력 필드 blur 이벤트 리스너
// phoneInput.addEventListener('blur', () => {
//     const phoneNum = phoneInput.value.replace(/-/g, ''); // 입력된 전화번호에서 '-' 제거
//     if (!/^\d{10,11}$/.test(phoneNum)) {
//         phoneInput.classList.add('Input_error__ADOWg'); // 유효성 검사에 실패하면 에러 스타일 적용
//         firstForm.querySelector('.MobileAuthField_error__29I4S').style.display = 'block'; // 에러 메시지 출력
//     } else {
//         phoneInput.classList.remove('Input_error__ADOWg'); // 유효성 검사에 성공하면 에러 스타일 제거
//         firstForm.querySelector('.MobileAuthField_error__29I4S').style.display = 'none'; // 에러 메시지 감추기
//     }
// });
//
//
