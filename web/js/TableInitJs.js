layui.use('table', function () {
    var table = layui.table;

    //表格的初始化与加载
    table.render({
        elem: '#dataTable'
        , height: 525
        // ,width:500
        , limit: 10
        , limits: [1, 3, 5, 10, 20, 30, 40, 50]
        // ,skin: 'line' //行边框风格
        // ,totalRow:true
        // ,even: true //开启隔行背景
        , url: '/getDataServlet' //数据接口
        , page: true //开启分页   //开启分页后，前端会给后端发page和limit两个数据
        , toolbar: "<div>" +
            "<a class=\"layui-btn layui-btn-xs\" lay-event=\"add\">添加</a>" +
            "<a class=\"layui-btn layui-btn-danger layui-btn-xs\" lay-event=\"delete\">删除</a>" +
            "</div>"
        , defaultToolbar: ['filter', 'exports', 'print']
        , loading: true//切换分页加载条
        , title: "学生管理系统-学生表"//定义 table 的大标题（在文件导出等地方会用到）
        , cols: [[ //表头
            {field: '', title: '选择', width: 50, type: "checkbox", fixed: 'left'}
            , {field: 'studentId', title: '学号', width: 140, sort: true, fixed: 'left'}
            , {field: 'studentName', title: '姓名', width: 80}
            , {field: 'studentGender', title: '性别', width: 80, sort: true}
            , {field: 'studentAge', title: '年龄', width: 80, sort: true}
            , {field: 'studentInstitute', title: '学院', width: 160, sort: true}
            , {field: 'studentInstitureExplain', title: '学院详细信息', width: 200}
            , {field: 'studentEnterScore', title: '入学成绩', width: 120, sort: true}
            , {field: 'studentPoliticalStatus', title: '政治面貌', width: 135}
            , {field: 'studentHomeplace', title: '籍贯', width: 135}
            , {
                templet: '<div id="bar"><a class="layui-btn layui-btn-xs" lay-event="detail">查看</a><a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a><a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a></div>',
                title: '操作',
                type: "space",
                width: 135,
                fixed: 'right'
            }
        ]]
    });

    table.render({ //绑定列工具条
        cols: [[
            {field: 'id', title: 'ID', width: 100}
            , {fixed: 'right', width: 150, align: 'center', toolbar: '#bar'} //这里的toolbar值是模板元素的选择器
        ]]
    });

});