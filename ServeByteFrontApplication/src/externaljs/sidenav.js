$(document).ready(function() {
    let currPath = location.pathname;
    $('#sidebarCollapse').on('click', function () {
        $('#sidebar').toggleClass('active');
        $('#content').toggleClass('active');
        $('#navbar').toggleClass('active');
        $('#menu-title').toggleClass('active');
        $('#about-title').toggleClass('active');
        $('#contact-title').toggleClass('active');
        $('#navbar').width($(this).width()-250);
        $(this).toggleClass('active');
    });

    function urlChanged() {
        return currPath !== location.pathname;
    };
    function checkActive() {
        if (urlChanged()) {
            currPath = location.pathname;
            setActive();
        }
    }
    function setActive() {
        $("ul.components li.active").toggleClass("active");
        $(`ul.components li div a[routerLink^="${location.pathname.split("/")[1]}"]`).parent().parent().toggleClass('active');
    }
    setActive();
    setInterval(checkActive, 3);
})