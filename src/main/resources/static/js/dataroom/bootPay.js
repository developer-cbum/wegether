$(function () {

    console.log("------------부트페이 테스트-------------");

    // var BootPay = require('bootpay-js');

   $('#payButton').on(
         "click",
       function() {
           console.log("------------버튼 클릭-------------");
           console.log(dataDTO);
             BootPay.request({
                 price: `${dataDTO.dataPrice}` - `${payVO.payPointUse}`,
                 application_id: "64711afd922c3400236cddb9",
                 name: `${dataDTO.dataTitle}`,
                 phone: `${dataDTO.memberPhoneNumber}`,
                 order_id: '1234',
                 pg: 'nicepay',
                 method: 'card',
                 show_agree_window: 0,
                 items: [
                     {
                         item_name: `${dataDTO.dataTitle}`,
                         qty: 1,
                         unique: `${dataDTO.id}`,
                         price:  `${dataDTO.dataPrice}` - `${payVO.payPointUse}`,
                     }
                 ],
                 user_info: {
                     username: `${dataDTO.memberName}`,
                     email: `${dataDTO.memberEmail}`,
                     phone: `${dataDTO.memberPhoneNumer}`
                 },

               params: {callback1: '그대로 콜백받을 변수 1', callback2: '그대로 콜백받을 변수 2', customvar1234: '변수명도 마음대로'},
               account_expire_at: '2020-10-25',
               extra: {
                   start_at: '2019-05-10',
                   end_at: '2022-05-10',
                   vbank_result: 1,
                   quota: '0,2,3',
                   theme: 'purple',
                   custom_background: '#00a086',
                   custom_font_color: '#ffffff'
               }
        }).error(function (data) {
                // 결제가 실패했을 때 호출되는 함수입니다.
                var msg = "결제 에러입니다.: " + JSON.stringify(data);
                alert(msg);
                console.log(data);
            }).cancel(function (data) {
                // 결제창에서 결제 진행을 하다가 취소버튼을 눌렀을때 호출되는 함수입니다.
                var msg = "결제 취소입니다.: " + JSON.stringify(data);
                alert(msg);
                console.log(data);
            }).confirm(function (data) {
                // 결제가 진행되고 나서 승인 이전에 호출되는 함수입니다.
                // 일부 결제는 이 함수가 호출되지 않을 수 있습니다. ex) 가상계좌 및 카드 수기결제는 호출되지 않습니다.
                // 만약 이 함수를 정의하지 않으면 바로 결제 승인이 일어납니다.
                if (confirm('결제를 정말 승인할까요?')) {
                    console.log("do confirm data: " + JSON.stringify(data));
                    // 이 함수를 반드시 실행해야 결제가 완전히 끝납니다.
                    // 부트페이로 서버로 결제를 승인함을 보내는 함수입니다.
                    this.transactionConfirm(data);
                } else {
                    var msg = "결제가 승인거절되었습니다.: " + JSON.stringify(data);
                    alert(msg);
                    console.log(data);
                }
            }).done(function (data) {
                // 결제가 모두 완료되었을 때 호출되는 함수입니다.
                 $("#payment-submit").submit();
                alert("결제가 완료되었습니다.");
                console.log(data);
            }).ready(function (data) {
                // 가상계좌 번호가 체번(발급) 되었을 때 호출되는 함수입니다.
                console.log(data);
            });

});

}); //E