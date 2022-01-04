$=layui.$
/*改变iframe和浏览器url*/
$(function (){
    $(".layui-menu-body-title  a").on("click",function (){
        var address=$(this).attr("data-src");
        console.log(address);
        var iframe = $('iframe');
        iframe.attr("src",address);
        //history.pushState({},null,address);
    });
    $(".layui-nav-item  a").on("click",function (){
        var address=$(this).attr("data-src");
        console.log(address);
        var iframe = $('iframe');
        iframe.attr("src",address);
        //history.pushState({},null,address);
    });
});
