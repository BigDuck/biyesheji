/*
 * Copyright (c) 2016 - 1 - 19  11 : 44 :13
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

/**
 * 删除
 * @param listid
 */
function btn_delClick(listid) {
    var row = this;
    //var index = layer.load(0, {shade: false}); //0代表加载的风格，支持0-2
    layer.confirm('你确定删除？', {
        btn: ['取消', '确定'] //按钮
    }, function () {
        layer.msg('取消成功', {icon: 1});
    }, function () {
        var index = layer.load(0, {shade: false}); //0代表加载的风格，支持0-2

        $.ajax({
            type: "POST",
            url: '../admin/delete',
            data:{"id":listid},
            dataType:'json',
            cache: false,
            success: function (res) {
                layer.close(index);
                if(res=="1"){
                    layer.alert('删除成功!', {
                        icon: 6,
                        skin: 'layer-ext-moon'
                    });
                    $("#row_" + listid).remove();
                }else{
                    layer.alert('删除失败!', {
                        icon: 2,
                        skin: 'layer-ext-moon'
                    });
                }
            },
            error: function (res) {
                layer.close(index);
                layer.alert('删除失败!', {
                    icon: 2,
                    skin: 'layer-ext-moon'
                });
            }
        });

    });

}
function btn_look(listId) {
    location.href = "/admin/main/list/" + listId;
}
function listMainAdd(){
    location.href="/admin/main/list/add";
}
function btn_view(id){
    location.href="/admin/main/list/"+id+"?type="+'view';
}

