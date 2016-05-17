<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<aside id="sidebar">
    <!-- Sidbar Widgets -->
    <div class="side-widgets overflow">
        <!-- Profile Menu -->
        <div class="text-center s-widget m-b-25 dropdown" id="profile-menu">
            <a href="" data-toggle="dropdown">
                <img class="profile-pic" src="${contextPath}/html/img/profile-pic.jpg" alt="">
            </a>
            
            <h4 class="m-0">Malinda Hollaway</h4>
            @malinda-h
        </div>
        
        <!-- Calendar -->
        <div class="s-widget m-b-25">
            <div id="sidebar-calendar"></div>
        </div>
        
        <!-- Feeds -->
        <div class="s-widget m-b-25">
            <h2 class="tile-title">
               News Feeds
            </h2>
            
            <div class="s-widget-body">
                <div id="news-feed"></div>
            </div>
        </div>
        
        <!-- Projects -->
        <div class="s-widget m-b-25">
            <h2 class="tile-title">
                Projects on going
            </h2>
            
            <div class="s-widget-body">
                <div class="side-border">
                    <small>Joomla Website</small>
                    <div class="progress progress-small">
                         <a href="#" data-toggle="tooltip" title="" class="progress-bar tooltips progress-bar-danger" style="width: 60%;" data-original-title="60%">
                              <span class="sr-only">60% Complete</span>
                         </a>
                    </div>
                </div>
                <div class="side-border">
                    <small>Opencart E-Commerce Website</small>
                    <div class="progress progress-small">
                         <a href="#" data-toggle="tooltip" title="" class="tooltips progress-bar progress-bar-info" style="width: 43%;" data-original-title="43%">
                              <span class="sr-only">43% Complete</span>
                         </a>
                    </div>
                </div>
                <div class="side-border">
                    <small>Social Media API</small>
                    <div class="progress progress-small">
                         <a href="#" data-toggle="tooltip" title="" class="tooltips progress-bar progress-bar-warning" style="width: 81%;" data-original-title="81%">
                              <span class="sr-only">81% Complete</span>
                         </a>
                    </div>
                </div>
                <div class="side-border">
                    <small>VB.Net Software Package</small>
                    <div class="progress progress-small">
                         <a href="#" data-toggle="tooltip" title="" class="tooltips progress-bar progress-bar-success" style="width: 10%;" data-original-title="10%">
                              <span class="sr-only">10% Complete</span>
                         </a>
                    </div>
                </div>
                <div class="side-border">
                    <small>Chrome Extension</small>
                    <div class="progress progress-small">
                         <a href="#" data-toggle="tooltip" title="" class="tooltips progress-bar progress-bar-success" style="width: 95%;" data-original-title="95%">
                              <span class="sr-only">95% Complete</span>
                         </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <!-- Side Menu -->
    <ul class="list-unstyled side-menu">
        <li>
            <a class="sa-side-home" href="${contextPath}/admin/dashboard">
                <span class="menu-item">主页</span>
            </a>
        </li>
        <li class="dropdown">
            <a class="sa-side-form" href="">
                <span class="menu-item">用户管理</span>
            </a>
            <ul class="list-unstyled menu-item">
                <li><a href="${contextPath}/admin/aoluser/userslist">用户信息查询</a></li>
                <li><a href="form-components.html">子女用户信息查询</a></li>
            </ul>
        </li>
        <li class="dropdown">
            <a class="sa-side-ui" href="">
                <span class="menu-item">测量结果</span>
            </a>
            <ul class="list-unstyled menu-item">
                <li><a href="${contextPath}/admin/measure/xtlist">血糖预警</a></li>
            </ul>
        </li>
        <li class="dropdown">
            <a class="sa-side-chart" href="">
                <span class="menu-item">医师管理</span>
            </a>
            <ul class="list-unstyled menu-item">
                <li><a href="${contextPath}/admin/doctor/index">医师列表</a></li>
            </ul>
        </li>
        <li class="dropdown">
            <a class="sa-side-folder" href="">
                <span class="menu-item">设备管理</span>
            </a>
            <ul class="list-unstyled menu-item">
                <li><a href="${contextPath}/admin/devices/deviceslist">设备列表</a></li>
            </ul>
        </li>
        <li>
            <a class="sa-side-calendar" href="calendar.html">
                <span class="menu-item">Calendar</span>
            </a>
        </li>
        <li class="dropdown">
            <a class="sa-side-page" href="">
                <span class="menu-item">Pages</span>
            </a>
            <ul class="list-unstyled menu-item">
                <li><a href="list-view.html">List View</a></li>
                <li><a href="profile-page.html">Profile Page</a></li>
                <li><a href="messages.html">Messages</a></li>
                <li><a href="login.html">Login</a></li>
                <li><a href="404.html">404 Error</a></li>
            </ul>
        </li>
    </ul>
</aside>