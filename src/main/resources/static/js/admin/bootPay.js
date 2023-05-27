/**
 *
 *//**
 *
 */


$('.payButton').on(
    "click",
    function () {

        if ($('#deliveryAddress').is(':visible')) {
            if ($('#deliveryAddress').val() == ''
                || $('#deliveryAddressDetail').val() == '') {
                showWarnModal("배송 주소를 입력해주세요");
                return;
            }
        }

        if ($('#receiver-input1').val() == '') {
            showWarnModal("받으실 분 성함을 입력해주세요");
            return;
        }

        if ($('#receiver-input2').val() == '') {
            showWarnModal("휴대폰을 입력해주세요");
            return;
        }

        if ($('#receiver-input3').val() == '') {
            showWarnModal("받으실 장소를 입력해주세요.");
            return;
        }

        BootPay.request({
            price: 100,
            application_id: "644829ab922c3400216cdcc2",
            name: "좋아",
            pg: 'nicepay',
            method: 'card',
            show_agree_window: 0,
            items: [
                {
                    item_name: "좋아",
                    qty: 5,
                    unique: '1234',
                    price: 100,
                }
            ],
            user_info: {
                username: "김인진",
                email: "injin0318@gmail.com",
                addr: "집주소",
                phone: "01088943132"
            },
            order_id: '1234',
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
            console.log(data);
        }).cancel(function (data) {
            console.log(data);
        }).ready(function (data) {
            console.log(data);
        }).confirm(function (data) {
            console.log(data);
            var enable = true;
            if (enable) {
                BootPay.transactionConfirm(data);
            } else {
                BootPay.removePaymentWindow();
            }
        }).close(function (data) {
            console.log(data);
        }).done(function (data) {
            document.getElementById("payForm").submit();
            console.log(data);
        });


        /*결제 완료되면 결제 정보 테이블에 담기위한 프론트컨트롤러로 이동*/


    });