<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<aside id="sidebar">
    <!-- Sidbar Widgets -->
    <div class="side-widgets overflow">
        <!-- Profile Menu -->
        <div class="text-center s-widget m-b-25 dropdown" id="profile-menu">
            <a href="" data-toggle="dropdown">
                <img class="profile-pic animated" src="${contextPath}/html/img/profile-pic.jpg" alt="">
            </a>
            <ul class="dropdown-menu profile-menu">
                <li><a href="${contextPath}/admin/logout">退&nbsp;&nbsp;&nbsp;出</a> <i class="icon left">&#61903;</i><i class="icon right">&#61815;</i></li>
            </ul>
        </div>
        
        <!-- Calendar -->
        <div class="s-widget m-b-25">
            <div id="sidebar-calendar"></div>
        </div>
        
        <!-- Feeds -->
        <%--<div class="s-widget m-b-25">--%>
            <%--<h2 class="tile-title">--%>
               <%--热门新闻--%>
            <%--</h2>--%>

            <%--<div class="s-widget-body">--%>
                <%--<div id="news-feed"></div>--%>
            <%--</div>--%>
        <%--</div>--%>
    </div>
    
    <!-- Side Menu -->
    <ul class="list-unstyled side-menu">
        <li class="dropdown">
            <a class="sa-side-form" href="">
                <span class="menu-item">用户管理</span>
            </a>
            <ul class="list-unstyled menu-item">
                <li><a href="${contextPath}/admin/aoluser/userslist">用户信息查询</a></li>
                <li><a href="${contextPath}/admin/cuser/index">子女用户信息查询</a></li>
            </ul>
        </li>
        <li class="dropdown">
            <a class="sa-side-chart" href="">
                <span class="menu-item">测量结果</span>
            </a>
            <ul class="list-unstyled menu-item">
                <li><a href="${contextPath}/admin/measure/xtlist">血糖预警</a></li>
                <li><a href="${contextPath}/admin/measure/xylist">血压预警</a></li>
            </ul>
        </li>
        <li class="dropdown">
            <a class="sa-side-ui" href="">
                <span class="menu-item">医师管理</span>
            </a>
            <ul class="list-unstyled menu-item">
                <li><a href="${contextPath}/admin/doctor/index">医师列表</a></li>
                <li><a href="${contextPath}/admin/pg2/index">医生讲座计划</a></li>
                <li><a href="${contextPath}/admin/sign/index">签约列表</a></li>
            </ul>
        </li>
        <li class="dropdown">
            <a class="sa-side-table" href="">
                <span class="menu-item">系统管理</span>
            </a>
            <ul class="list-unstyled menu-item">
                <li><a href="${contextPath}/admin/info/index">资讯列表</a></li>
                <li><a href="${contextPath}/admin/novice/index">新手指导列表</a></li>
                <li><a href="${contextPath}/admin/cq/index">常见问题列表</a></li>

            </ul>
        </li>
        <%--<li class="dropdown">--%>
            <%--<a class="sa-side-folder" href="">--%>
                <%--<span class="menu-item">新手指导管理</span>--%>
            <%--</a>--%>
            <%--<ul class="list-unstyled menu-item">--%>

            <%--</ul>--%>
        <%--</li>--%>
        <%--<li class="dropdown">--%>
            <%--<a class="sa-side-page" href="">--%>
                <%--<span class="menu-item">病理讲座管理</span>--%>
            <%--</a>--%>
            <%--<ul class="list-unstyled menu-item">--%>
                <%--<li><a href="${contextPath}/admin/pg2/index">医生讲座计划</a></li>--%>
            <%--</ul>--%>
        <%--</li>--%>
        <%--<li class="dropdown">--%>
            <%--<a class="sa-side-typography" href="">--%>
                <%--<span class="menu-item">常见问题管理</span>--%>
            <%--</a>--%>
            <%--<ul class="list-unstyled menu-item">--%>

            <%--</ul>--%>
        <%--</li>--%>
        <%--<li class="dropdown">--%>
            <%--<a class="sa-side-ui" href="">--%>
                <%--<span class="menu-item">签约管理</span>--%>
            <%--</a>--%>

        <%--</li>--%>
        <li class="dropdown">
            <a class="sa-side-page" href="">
                <span class="menu-item">反馈管理</span>
            </a>
            <ul class="list-unstyled menu-item">
                <li><a href="${contextPath}/admin/feedback/index">反馈列表</a></li>
                <li><a href="${contextPath}/admin/comp/index">医生投诉列表</a></li>
            </ul>
        </li>
        <%--<li class="dropdown">--%>
            <%--<a class="sa-side-ui" href="">--%>
                <%--<span class="menu-item">医生投诉管理</span>--%>
            <%--</a>--%>
            <%--<ul class="list-unstyled menu-item">--%>

            <%--</ul>--%>
        <%--</li>--%>
    </ul>
</aside>