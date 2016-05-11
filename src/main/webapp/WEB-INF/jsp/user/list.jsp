<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../inc/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>
    <meta name="format-detection" content="telephone=no">
    <meta charset="UTF-8">
    <meta name="description" content="Violate Responsive Admin Template">
    <meta name="keywords" content="Super Admin, Admin, Template, Bootstrap">
    <title>Super Admin Responsive Template</title>
    <!-- CSS -->
    <%@ include file="../inc/new/css.jsp" %>
</head>
<body id="skin-cloth">
<%@ include file="../inc/new/header.jsp" %>
<div class="clearfix"></div>
<section id="main" class="p-relative" role="main">
    <%@ include file="../inc/new/menu.jsp" %>
    <section id="content" class="container">
        <!-- 查询条件 -->
        <div class="block-area" id="search">
            <div class="row">
                <div class="col-md-2 form-group">
                    <label>Text feild</label>
                    <input type="text" class="input-sm form-control" placeholder="...">
                </div>
                <div class="col-md-2 form-group">
                    <label>Text feild</label>
                    <input type="text" class="input-sm form-control" placeholder="...">
                </div>
                <div class="col-md-2 form-group">
                    <label>Text feild</label>
                    <input type="text" class="input-sm form-control" placeholder="...">
                </div>
                <div class="col-md-2 form-group">
                    <label>Text feild</label>
                    <input type="text" class="input-sm form-control" placeholder="...">
                </div>
                <div class="col-md-2 form-group">
                    <label>Password</label>
                    <input type="password" class="input-sm form-control" placeholder="...">
                </div>
                <div class="col-md-2 form-group">
                    <label>Select</label>
                    <select class="select">
                        <option>Default</option>
                        <option>Toyota Avalon</option>
                        <option>Toyota Crown</option>
                        <option>Lexus LX570</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="block-area" id="alternative-buttons">
            <button class="btn btn-alt m-r-5">Search</button>
        </div>
        <hr class="whiter m-t-20"/>
        <!-- form表格 -->
        <div class="block-area" id="tableHover">
            <table class="table table-bordered table-hover tile" id="dataTables" cellspacing="0" width="100%">
                <thead>
                <tr>
                    <th><input type="checkbox" class="pull-left list-parent-check"/></th>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>生日</th>
                    <th>身高</th>
                    <th>体重</th>
                    <th>手机号码</th>
                    <th>邮箱</th>
                    <th>注册时间</th>
                    <th>操作</th>
                </tr>
                </thead>
            </table>
        </div>
    </section>
    <br/><br/>
</section>
<!-- JS -->
<%@ include file="../inc/new/foot.jsp" %>
<script>
    $user = {
        v: {
            list: [],
            dTable: null
        },
        fn: {
            init: function () {
                $user.fn.dataTableInit();
            },
            dataTableInit: function () {
                $user.v.dTable = $leoman.dataTable($('#dataTables'), {
                    "processing": true,
                    "serverSide": true,
                    "searching": false,
                    "ajax": {
                        "url": "${contextPath}/admin/aoluser/getUsersDataList",
                        "type": "POST"
                    },
                    "columns": [
                        {
                            "data": "userId",
                            "render": function (data) {
                                var checkbox = "<div class=\"icheckbox_minimal\" aria-checked=\"false\" aria-disabled=\"false\" style=\"position: relative;\"><input type=\"checkbox\" value="+ data +" class=\"pull-left list-check\" style=\"position: absolute; top: -20%; left: -20%; display: block; width: 140%; height: 140%; margin: 0px; padding: 0px; border: 0px; opacity: 0; background: rgb(255, 255, 255);\"></div>";
//                                var checkbox = "<input type='checkbox' class='pull-left list-check' value=''>";
                                return checkbox;
                            }
                        },
                        {"data": "name"},
                        {"data": "sex"},
                        {"data": "birthday"},
                        {"data": "height"},
                        {"data": "weight"},
                        {"data": "mobile"},
                        {"data": "email"},
                        {
                            "data": "bak5",
                            render: function (data) {
                                return new Date(data).format("yyyy-MM-dd hh:mm:ss")
                            }
                        },
                        {
                            "data": "",
                            "render": function (data) {
                                var detail = "<a  title='查看' href='${contextPath}/admin/aoluser/detail' class='btn btn-primary btn-circle add'>" +
                                        "<i class='fa fa-edit'></i></a>";
                                return detail;
                            }
                        }
                    ],
                    "createdRow": function (row, data, index) {
                        $user.v.list.push(data);
//                        $('td', row).eq(0).html("<input type='checkbox' value=" + data.id + ">");
                    },
                    rowCallback: function (row, data) {
                        var items = $user.v.list;
                    },
                    "fnServerParams": function (aoData) {
//                        aoData.title = $("#title").val();
                    },
                    "fnDrawCallback": function (row) {
                        $leoman.uiform();
                    }
                });
            },
            responseComplete: function (result, action) {
                if (result.status == "0") {
                    if (action) {
                        $user.v.dTable.ajax.reload(null, false);
                    } else {
                        $user.v.dTable.ajax.reload();
                    }
                    $leoman.notify(result.msg, "success");
                } else {
                    $leoman.notify(result.msg, "error");
                }
            }
        }
    }
    $(function () {
        $user.fn.init();
    })
</script>
</body>
</html>

