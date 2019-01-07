//必须加载layui.form,如果不加载form模块，select、checkbox、radio等将无法显示，并且无法使用form相关功能
layui.use('form', function () {
    var form = layui.form;

    //各种基于事件的操作
});
layui.use('layer', function () {
    var layer = layui.layer;

    layer.ready(function () {//页面一开始就执行
        layer.open({
            type: 2,
            title: ["学生管理系统-登录", "font-size:20px;margin:0 auto"],
            closeBtn: 0,
            shade: 0,
            // move:false,
            moveOut: true,
            resize: false,
            // offset: '165px',
            area: ['380px', '250px'],
            content: ['html/login.html', 'no'], //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
            success: function (layero, index) {//成功弹出后回调
                var body = layer.getChildFrame('body', index);

                //console.log(body.html()) //得到iframe页的body内容
                //给弹出的iframe页填值
                body.find('#username').val("user");
                body.find('#password').val("123");


                //需要更新表单渲染，不然radio,select等控件无法及时获得值。
                var iframeWin = window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象

                iframeWin.login(location);//调用iframe页的登录方法,把当前页的location传过去方便跳转

            }
        });
    });
});