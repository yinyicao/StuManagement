$("#submit").click(function () {
    if ($('#role').val() == "") {
        layui.use('layer', function () {
            var layer = layui.layer;

            layer.alert("请选择角色!", {
                type: 0,
                title: "提示",
                icon: 0,
            });
        });
    }
    else if ($('#username').val() == "" || $('#password').val() == "") {

        layui.use('layer', function () {
            var layer = layui.layer;

            layer.alert("用户名或者密码不能为空!", {
                type: 0,
                title: "提示",
                icon: 0,
            });
        });

    }
    else {
        $.ajax({
            type: "POST",
            url: "/loginServlet",
            data: {
                username: $('#username').val(),
                password: $('#password').val(),
                role: $('#role').val()
            },
            beforeSend: function () {
                $("#result").html("");

                layui.use('layer', function () {
                    var layer = layui.layer;

                    layer.alert(" ", {
                        type: 3,
                        icon: 0,
                    });

                });


                // layer.load();

            },
            success: function (data) {
                var json = JSON.parse(data);
                // alert(json.msg);
                $("#result").html(json.msg + "_状态码：" + json.code);

                layui.use('layer', function () {
                    var layer = layui.layer;

                    layer.alert(json.msg, {
                        type: 0,
                        title: "提示",
                        icon: json.code,
                        time: 5000,
                        // btnAlign: 'c'//居中
                    }, function () {
                        console.log("登录结果返回");
                        if (json.code == 1) { //登录成功
                            $(window).attr('location', '/main.html');
                            console.log("登录成功")
                        } else {
                            // $(window).attr('location','/index.html');
                            layer.close(layer.index);
                            console.log("登录失败")
                        }

                    });

                });

            },
            complete: function (XMLHttpRequest, textStatus) {
                $("#result").append("_请求状态：" + textStatus);


                layui.use('layer', function () {
                    var layer = layui.layer;


                    layer.closeAll('loading');

                });

            },

            error: function (XMLHttpRequest, textStatus, thrownError) {
                layui.use('layer', function () {
                    var layer = layui.layer;

                    layer.alert("Code:Error,请求失败", {
                        type: 0,
                        icon: 2,
                    });

                });
            }
        });
    }
})


