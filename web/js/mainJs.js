// $().ready(function () {
//     $.ajax({
//         type: "get",
//         url: "/operationServlet",
//         data:{
//
//         },
//         beforeSend: function () {
//
//         },
//         success: function (data) {
//             var json = JSON.parse(data);
//             alert(data);
//
//         },
//         complete: function (XMLHttpRequest, textStatus) {
//             // alert("请求完成！");
//
//         },
//
//         error: function (XMLHttpRequest, textStatus, thrownError) {
//             alert("请求失败！")
//         }
//     });
// });


$("#logout").click(function () {
    $.ajax({
        type: "POST",
        url: "/logoutServlet",
        data: {
            //"username=" + $('#username').val() + "&password=" + $('#password').val()
        },
        beforeSend: function () {

        },
        success: function (data) {
            var json = JSON.parse(data);
            if (json.code == 1) {
                $(window).attr('location', '/index.html');
            }

        },
        complete: function (XMLHttpRequest, textStatus) {

        },

        error: function (XMLHttpRequest, textStatus, thrownError) {
            alert("请求失败！")
        }
    });
});