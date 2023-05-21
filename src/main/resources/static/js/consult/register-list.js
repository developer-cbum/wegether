$('.select-menu__control').on('click', function () {
    if (!$(this).hasClass('select-menu__control--menu-is-open')) {
        $(this).addClass('select-menu__control--menu-is-open');
    } else {
        $(this).removeClass('select-menu__control--menu-is-open');
    }

    $('.select-menu__menu').toggle();
});

$('.select-menu__option').hover(
    function () {
        $(this).addClass('css-1n7v3ny-option');
    },
    function () {
        $(this).removeClass('css-1n7v3ny-option');
    }
);

$('.select-menu__option').on('click', function () {
    let id = $(this).attr('id').split('-')[4];
    console.log(id);
    console.log($(this).eq(id).text());
    $('.select-menu__single-value').text(`${$.trim($('.select-menu__option').eq(id).text())}`);
    $('.select-menu__menu').hide();
});
