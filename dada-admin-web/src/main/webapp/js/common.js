$(function() {
    var showSide = true;

    var menus = $('#side-menu li a').filter(function(item, index, array){
        var href = $(this).attr('href');
        return typeof href == 'string' && href.indexOf('javascript') != 0 && href.indexOf('#') != 0;
    }).map(function(item, index, array){
        var cur = $(this);
        return {id: cur.attr('href'), text: cur.text()};
    });

    $('.navbar-showside').on('click', function () {
        showSide = !showSide;
        handleShowSide();
    });

    function handleShowSide() {
        if (showSide) {
            $('#side-menu').show();
            $('#wrapper').css('padding-left', '225px');
        } else {
            $('#side-menu').hide();
            $('#wrapper').css('padding-left', '0');
        }

    }

    select2ForPinyinOrChineseCharacters('#side-search', '搜索...', {data: menus}, window.location.pathname + window.location.search);

    $('#side-menu').metisMenu({ toggle: false });

});
