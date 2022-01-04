
$(function (){
    let url=window.location.href;
    let urls= url.split('/');
    let id=urls[5];
    view(urls,id);
    like(urls,id);
    loadComment(urls,id);
    addComment(urls,id);
    hasCollection(urls,id);
    update(urls,id);
})
/*点赞*/
function like(urls,id) {
    layui.use('layer',function (){
        var layer=layui.layer;
        let like=$("#like");
        if ($.cookie("likeid")!=null&&$.cookie("likeid")==id) like.css("color","#1E9FFF");
        else {
            like.on("click",function (){
                let _this=$(this);
                $.post("/api/"+urls[3]+"/like/"+id,function (res){
                    if (res.status==0){
                        layer.msg(res.msg,{
                            time:2000
                        });
                        $.cookie("likeid",id)
                        _this.css("color","#1E9FFF");
                    }
                });
            })
        }
    });
}
//收藏
function collection(urls,id) {
    layui.use('layer',function (){
        var layer=layui.layer;
        let collection=$("#collection");
        collection.on("click",function (){
            let _this=$(this);
            $.post("/api/collection/add/"+urls[3]+"/"+id,function (res){
                layer.msg(res.msg,{
                    time:2000
                });
                if (res.status==0){
                    collection.removeClass("layui-icon-rate");
                    collection.addClass("layui-icon-rate-solid");
                    collection.css("color","#1E9FFF");
                }
            });
        });
    });
}
function hasCollection(urls,id){
    $.get("/api/collection/get/"+urls[3]+"/"+id,function (res){
        if (res.status==0){
            $("#collection").removeClass("layui-icon-rate");
            $("#collection").addClass("layui-icon-rate-solid");
            $("#collection").css("color","#1E9FFF");
        }else collection(urls,id);
    });
}
function view(urls,id) {
    layui.use('layer',function (){
        let layer=layui.layer;
        $.post("/api/"+urls[3]+"/view/"+id,function (res){
            if (res.status!=0){
                layer.msg(res.msg);
            }
        });
    });
}

//流加载评论
function loadComment(urls,id){
    layui.use('flow', function(){
        var $ = layui.jquery; //不用额外加载jQuery，flow模块本身是有依赖jQuery的，直接用即可。
        var flow = layui.flow;
        flow.load({
            elem: '#demo' //指定列表容器
            ,done: function(page, next){ //到达临界点（默认滚动触发），触发下一页
                var lis = [];
                //以jQuery的Ajax请求为例，请求下一页数据（注意：page是从2开始返回）
                $.get('/api/comment/'+urls[3]+'/'+id+'?page='+page, function(res){
                    //假设你的列表返回在data集合中
                    layui.each(res.data, function(index, item){
                        lis.push(
                            '<li className="layui-panel" style="display: flex;justify-content: flex-start;height: 100px;margin: 20px;" data-id="'+item.commentId+'">'+
                                '<div>' +'<img src="'+item.commentUserAvatar+'" style="height: 100px;width: 100px;">'+ '</div>'+
                                    '<div style="width: 100%;">' +
                                        '<div>' +item.commentUserNickname+ '</div>'+
                                        '<hr >'+
                                        '<div style="display: flex;flex-direction: column;justify-content: space-between;height: 60%;">'+
                                            '<div>'+item.commentContent+'</div>'+
                                            '<div style="align-self: flex-end;">'+item.commentTime+'</div>'+
                                        '</div>'+
                                    '</div>'+
                            '</li>');
                    });
                    //执行下一页渲染，第二参数为：满足“加载更多”的条件，即后面仍有分页
                    //pages为Ajax返回的总页数，只有当前页小于总页数的情况下，才会继续出现加载更多
                    next(lis.join(''), page < res.count);
                });
            }
        });
    });
}
//添加评论
function addComment(urls,id){
    layui.use('layer',function (){
        var layer=layui.layer;
        $("#sumbit").on('click',function (){
            var text=$("#text").val();
            $.post('/api/comment/'+urls[3]+'/'+id,{
                commentContent:text
            },function (res) {
                var data = eval('(' + res.data + ')');
                if (res.status==0){
                    layer.msg(res.msg,{
                        time:2000
                    },function (){
                        location.reload();
                    });
                }else if (res.status==1){
                    msg='';
                    for (let i=0;i<data.length;i++){
                        msg+=data[i].msg;
                    }
                    layer.open({
                        type: 1,
                        area: ['500px', '300px'],
                        content:msg
                    });
                }
            });
        });
    });
}
//更新
function update(urls,id){
    console.log(id);
    console.log(urls)
    layui.use('layer', function(){
        var layer = layui.layer;
        $("#update").on('click',function (){
            layer.open({
                type: 2,
                area: ['600px','600px'],
                content: 'https://localhost:8443/'+urls[3]+"/update/"+id //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
            });
        });
    });
}