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
                    <th><input type="checkbox" onclick="$bluemobi.checkAll(this)" class="checkall"/></th>
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

            },
            dataTableInit: function () {
                $user.v.dTable = $bluemobi.dataTable($('#dataTables'), {
                    "processing": true,
                    "serverSide": true,
                    "searching": false,
                    "ordering": true,
                    "ajax": {
                        "url": "admin/info/list",
                        "type": "POST"
                    },
                    "columns": [
                        {
                            "data": "id",
                            "render" : function(data) {
                                var checkbox = "<input type='checkbox' value=" + data + ">";
                                return checkbox;
                            }
                        },
                        {"data": "name"},
                        {"data": "birthday"},
                        {"data": "height"},
                        {"data": "weight"},
                        {"data": "mobile"},
                        {"data": "email"},
                        {
                            "data": "createDate",
                            render: function (data) {
                                return new Date(data).format("yyyy-MM-dd hh:mm:ss")
                                }
                        },
                        {
                            "data": "",
                            "render" : function(data) {
                                var detail = "<a  title='查看' href='${contextPath}/admin/aoluser/detail' class='btn btn-primary btn-circle add'>" +
                                        "<i class='fa fa-edit'></i></a>";

                                return detail;
                            }
                        }
                    ],
                    "createdRow": function (row, data, index) {
                        $user.v.list.push(data);
                    },
                    rowCallback: function (row, data) {
                        var items = kuserList.v.list;
                    },
                    "fnServerParams": function (aoData) {
                        aoData.title = $("#title").val();
                        aoData.isList = $("#isList").val();
                    },
                    "fnDrawCallback": function (row) {
                        $bluemobi.uiform();
                    }
                });
            }
        }
    }
</script>
</body>
</html>

