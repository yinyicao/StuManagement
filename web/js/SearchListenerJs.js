var layer;
var table;
layui.use('table', function () {
    layer = layui.layer;
    table = layui.table;
});

$().ready(function () {

    $("#search").click(function () {
        var searchIndex = $("#searchIndex  option:selected").val();
        var searchContent = $("#searchContent").val().trim();
        if (searchIndex === "" || searchContent === "") {
            layer.msg("您未输入索引或搜索内容，将进行全局搜索", {
                time: 3000
            }, function () {
                var index = layer.load(2, {time: 10 * 1000}); //设定最长等待10秒
                var isClickSearchButton = 1;
                table.reload('dataTable', { //重新加载表格
                    url: '/getDataServlet'
                    , where: {} //设定异步数据接口的额外参数，
                    //,height: 300
                    , done: function (res, curr, count) {
                        //如果是异步请求数据方式，res即为你接口返回的信息。
                        //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
                        // console.log(res);

                        //得到当前页码
                        // console.log(curr);

                        //得到数据总量
                        // console.log(count);


                        if (isClickSearchButton == 1) {
                            //关闭加载
                            layer.close(index);

                            layer.msg("共搜索到【" + count + "】条数据！", {
                                time: 1500
                            }, function () {
                                isClickSearchButton = 0;
                            })
                        }


                    }

                });

                //关闭加载
                layer.close(index);
            })
        } else {

            var index = layer.load(2, {time: 10 * 1000}); //设定最长等待10秒
            var isClickSearchButton = 1;
            table.reload('dataTable', { //重新加载表格
                url: '/getDataServlet'
                , where: {
                    searchIndex: searchIndex,
                    searchContent: searchContent
                } //设定异步数据接口的额外参数
                //,height: 300
                , done: function (res, curr, count) {
                    //如果是异步请求数据方式，res即为你接口返回的信息。
                    //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
                    // console.log(res);

                    //得到当前页码
                    // console.log(curr);

                    //得到数据总量
                    // console.log(count);


                    if (isClickSearchButton == 1) {
                        //关闭加载
                        layer.close(index);

                        layer.msg("共搜索到【" + count + "】条数据！", {
                            time: 1500
                        }, function () {
                            isClickSearchButton = 0;
                        })
                    }


                }

            });

            //关闭加载
            layer.close(index);

        }
    })

})