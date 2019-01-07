layui.use('table', function () {
    var table = layui.table;
//监听列工具条
    table.on('tool(allData)', function (obj) { //注：tool是工具条事件名，allData是table原始容器的属性 lay-filter="对应的值"
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
        var tr = obj.tr; //获得当前行 tr 的DOM对象

        switch (layEvent) {
            case 'detail'://查看
                layer.open({
                    type: 2,
                    title: "查看详细信息",
                    area: ['400px', '600px'],
                    content: ['html/viewStudent.html', 'no'], //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
                    success: function (layero, index) {//成功弹出后回调
                        var body = layer.getChildFrame('body', index);
                        //var iframeWin = window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
                        //console.log(body.html()) //得到iframe页的body内容
                        //给弹出的iframe页填值
                        body.find('#studentId').val(data.studentId)
                        body.find('#studentName').val(data.studentName)
                        body.find('#studentGender').val(data.studentGender)
                        body.find('#studentAge').val(data.studentAge)
                        body.find('#studentHomeplace').val(data.studentHomeplace)
                        body.find('#studentEnterScore').val(data.studentEnterScore)
                        body.find('#studentPoliticalStatus').val(data.studentPoliticalStatus)
                        body.find('#studentInstitute').val(data.studentInstitute)
                        body.find('#studentInstitureExplain').val(data.studentInstitureExplain)
                    }
                });
                break;
            case 'edit'://编辑
                layer.open({
                    type: 2,
                    title: "编辑学生信息",
                    area: ['400px', '600px'],
                    content: ['html/updateStudent.html', 'no'], //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
                    success: function (layero, index) {//成功弹出后回调
                        console.log(layero)
                        var body = layer.getChildFrame('body', index);

                        //console.log(body.html()) //得到iframe页的body内容
                        //给弹出的iframe页填值
                        body.find('#studentId').val(data.studentId).attr('readonly', true);
                        body.find('#studentName').val(data.studentName)

                        body.find("input:radio[value=" + data.studentGender + "]").attr("checked", true);  //性别，单选按钮

                        body.find('#studentAge').val(data.studentAge)
                        body.find('#studentHomeplace').val(data.studentHomeplace)
                        body.find('#studentEnterScore').val(data.studentEnterScore)
                        body.find("input:radio[value=" + data.studentPoliticalStatus + "]").attr("checked", true);  //政治面貌，单选按钮
                        body.find("option:contains('" + data.studentInstitute + "')").attr("selected", true);//学院，下拉选择


                        //需要更新表单渲染，不然radio,select等控件无法及时获得值。
                        var iframeWin = window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象
                        iframeWin.updateTableRender();//执行iframe页的方法

                        iframeWin.updateStu();//调用iframe页的更新方法。

                    },
                    end: function () {//层销毁后触发的回调
                        table.reload('dataTable', { //重新加载表格
                            url: '/getDataServlet'
                            , where: {} //设定异步数据接口的额外参数
                            //,height: 300
                        });
                    },
                    cancel: function (index, layero) { //右上角取消按钮回调
                        layer.close(index)
                        return false;
                    }

                });
                // 同步更新缓存对应的值
                // obj.update({
                //     username: '123'
                //     ,title: 'xxx'
                // });
                break;
            case 'del'://删除
                layer.confirm('真的删除' + obj.data.studentId + ':' + obj.data.studentName + '吗？', function (index) {
                    obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                    layer.close(index);
                    //向服务端发送删除指令
                    var jsonstr = {"msg": "deleteData", "data": [{"studentId": data.studentId}]};
                    $.ajax({
                        type: "POST",
                        url: "/operationServlet",
                        contentType: "application/json;charset=utf-8",//设置请求参数类型为json字符串
                        dataType: "json",
                        data: JSON.stringify(jsonstr),
                        success: function (data) {
                            // console.log(data.code === 200)
                            if (data.code === 200) {
                                layer.msg(data.msg, {
                                    time: 1500
                                })
                            } else if (data.code === 500) {
                                layer.msg(data.msg, {
                                    time: 1500
                                })
                            }

                        }

                    });

                });
                break;
        }
    });


    var allStu = [];
    var checkAll = false;
//监听复选框
    table.on('checkbox(allData)', function (obj) {
        // console.log(obj.checked); //当前是否选中状态
        // console.log(obj.data); //选中行的相关数据
        // console.log(obj.type); //如果触发的是全选，则为：all，如果触发的是单选，则为：one
        if (obj.type == "one" && obj.checked === true) {
            allStu.push(obj)
        }
        if (obj.type == "one" && obj.checked === false) {
            var index = allStu.indexOf(obj)
            console.log("removed elem of index :" + index);
            allStu.splice(index, 1);
        }

        if (obj.type == "all" && obj.checked === true) {
            allStu = []; //清空数组
            checkAll = true;
        }
        if (obj.type == "all" && obj.checked === false) {
            checkAll = false;
        }
        console.log(allStu);

    });


//监听头部工具栏（与监听列工具条只有一个参数值的差异，即tool和toolbar）
    table.on('toolbar(allData)', function (obj) { //注：toolbar是表头事件名，allData是table原始容器的属性 lay-filter="对应的值"
        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）

        switch (layEvent) {
            case 'add':
                layer.open({
                    type: 2,
                    title: "添加学生",
                    area: ['400px', '600px'],
                    content: ['html/addStudent.html', 'no'], //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
                    cancel: function (index, layero) { //右上角取消按钮回调
                        // if(confirm('确定要关闭么')){ //只有当点击confirm框的确定时，该层才会关闭
                        //     layer.close(index)
                        // }
                        table.reload('dataTable', { //重新加载表格
                            url: '/getDataServlet'
                            , where: {} //设定异步数据接口的额外参数
                            //,height: 300
                        });
                        layer.close(index);
                        return false;
                    }
                });
                break;
            case 'delete':
                var delNum = allStu.length;
                if (delNum === 0 && checkAll === true) {
                    layer.msg("非法操作!请重新选择！");
                } else if (delNum === 0 && checkAll === false) {
                    layer.msg("请选择条目再操作！");
                } else if (delNum != 0) {
                    layer.confirm('真的删除这' + delNum + '条数据吗?', function (index) {

                        //拼接json串//var jsonstr = {"msg": "deleteData", "data": [{"studentId": allStu[t].data.studentId}]};
                        var jsonstr = '{"msg": "deleteData", "data": [';
                        for (var am = 0; am < delNum; am++) {
                            allStu[am].del();//删除对应行（tr）的DOM结构，并更新缓存

                            jsonstr = jsonstr + '{"studentId": ' + allStu[am].data.studentId + "}";
                            if (am < delNum - 1) {
                                jsonstr = jsonstr + ",";
                            }
                        }
                        jsonstr = jsonstr + "]}";
                        // alert(jsonstr);
                        ////向服务端发送删除指令
                        $.ajax({
                            type: "POST",
                            url: "/operationServlet",
                            contentType: "application/json;charset=utf-8",//设置请求参数类型为json字符串
                            dataType: "json",
                            data: JSON.stringify(jsonstr),
                            success: function (data) {
                                // console.log(data.code === 200)
                                if (data.code === 200) {

                                    layer.msg(data.msg, {
                                        time: 1500
                                    })
                                } else if (data.code === 500) {
                                    layer.msg(data.msg, {
                                        time: 1500
                                    })
                                }

                            }
                        });
                        layer.close(index);


                    });
                }
                break;
        }
    });

});