<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/03/28
  Time: 20:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <link href="${pageContext.request.contextPath}/page/css/public.css" type="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/page/css/houtai.css" type="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/page/css/smartMenu.css" type="text/css" rel="stylesheet">
    <title>猫眼后台管理</title>
</head>
<body>
<div id="admin">
    <div class="ad-menu" id="ad-menu">
        <div class="ad-logo"><img src="${pageContext.request.contextPath}/page/image/logo.jpg" height="103" width="103"></div>
        <div class="ad-list">
            <ul>
                <li>
                    <div class="li-item"><em class="scm li-ico ic1"></em>地区管理<span class="scm arrow"></span></div>
                    <dl>
                        <dd>
                            <a href="${pageContext.request.contextPath}/page/city.html" target="iframe0" class="dd-item">城市管理<span class="scm dd-ar"></span></a>
                        </dd>
                        <dd>
                            <a href="${pageContext.request.contextPath}/page/area.html" target="iframe0" class="dd-item">区域管理<span class="scm dd-ar"></span></a>
                        </dd>
                    </dl>
                </li>
                <li>
                    <div class="li-item"><em class="scm li-ico ic1"></em>影院管理<span class="scm arrow"></span></div>
                    <dl>
                        <dd>
                            <a href="${pageContext.request.contextPath}/page/cinema.html" target="iframe0" class="dd-item">电影院管理<span class="scm dd-ar"></span></a>
                        </dd>
                        <dd>
                            <a href="${pageContext.request.contextPath}/page/movieHall.html" target="iframe0" class="dd-item">影厅管理<span class="scm dd-ar"></span></a>
                        </dd>
                        <dd>
                            <a href="${pageContext.request.contextPath}/page/hallRow.html" target="iframe0" class="dd-item">影厅座位行管理<span class="scm dd-ar"></span></a>
                        </dd>
                        <dd>
                            <a href="${pageContext.request.contextPath}/page/hallColumn.html" target="iframe0" class="dd-item">影厅座位列管理<span class="scm dd-ar"></span></a>
                        </dd>
                        <dd>
                            <a href="${pageContext.request.contextPath}/page/movieSession.html" target="iframe0" class="dd-item">场次管理<span class="scm dd-ar"></span></a>
                        </dd>
                    </dl>
                </li>
                <li>
                    <div class="li-item"><em class="scm li-ico ic3"></em>电影上映管理<span class="scm arrow"></span></div>
                    <dl>
                        <dd>
                            <a href="${pageContext.request.contextPath}/page/showing.html" target="iframe0" class="dd-item">影片上映管理<span class="scm dd-ar"></span></a>
                        </dd>
                    </dl>
                </li>
                <li>
                    <div class="li-item"><em class="scm li-ico ic3"></em>电影信息管理<span class="scm arrow"></span></div>
                    <dl>
                        <dd>
                            <a href="${pageContext.request.contextPath}/page/movieType.html" target="iframe0" class="dd-item">电影类型管理<span class="scm dd-ar"></span></a>
                        </dd>
                        <dd>
                            <a href="${pageContext.request.contextPath}/page/movieDate.html" target="iframe0" class="dd-item">电影年代管理<span class="scm dd-ar"></span></a>
                        </dd>
                        <dd>
                            <a href="${pageContext.request.contextPath}/page/movieArea.html" target="iframe0" class="dd-item">电影地区管理<span class="scm dd-ar"></span></a>
                        </dd>
                        <dd>
                            <a href="${pageContext.request.contextPath}/page/movieLanguage.html" target="iframe0" class="dd-item">电影语言管理<span class="scm dd-ar"></span></a>
                        </dd>
                        <dd>
                            <a href="${pageContext.request.contextPath}/page/movieInfo.html" target="iframe0" class="dd-item">电影信息管理<span class="scm dd-ar"></span></a>
                        </dd>
                    </dl>
                </li>
                <li>
                    <div class="li-item"><em class="scm li-ico ic4"></em>业务人员管理<span class="scm arrow"></span></div>
                    <dl>
                        <dd>
                            <a href="${pageContext.request.contextPath}/page/admin.html" target="iframe0" class="dd-item">系统管理员管理<span class="scm dd-ar"></span></a>
                        </dd>
                        <dd>
                            <a href="${pageContext.request.contextPath}/page/cinemaManager.html" target="iframe0" class="dd-item">影院管理员管理<span class="scm dd-ar"></span></a>
                        </dd>
                    </dl>
                </li>
                <li>
                    <div class="li-item"><em class="scm li-ico ic4"></em>用户管理<span class="scm arrow"></span></div>
                    <dl>
                        <dd>
                            <a href="${pageContext.request.contextPath}/page/user.html" target="iframe0" class="dd-item">用户信息管理<span class="scm dd-ar"></span></a>
                        </dd>
                    </dl>
                </li>
                <li>
                    <div class="li-item"><em class="scm li-ico ic6"></em>订单管理<span class="scm arrow"></span></div>
                    <dl>
                        <dd>
                            <a href="${pageContext.request.contextPath}/page/orderItem.html" target="iframe0" class="dd-item">订单项管理<span class="scm dd-ar"></span></a>
                        </dd>
                        <%--<dd>
                            <a href="javascript:;" target="iframe0" class="dd-item">电影订单管理<span class="scm dd-ar"></span></a>
                        </dd>--%>
                    </dl>
                </li>
                <li>
                    <div class="li-item"><em class="scm li-ico ic5"></em>评论管理<span class="scm arrow"></span></div>
                    <dl>
                        <dd>
                            <a href="${pageContext.request.contextPath}/page/comment.html" target="iframe0" class="dd-item">用户评论管理<span class="scm dd-ar"></span></a>
                        </dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>
    <div class="ad-comment-box" id="ad-comment">
        <div class="ad-top-comment">
            <div class="ad-message">
                <div class="ad-top-left">
                    <div class="ad-change-btn"><a id="ad-list" href="javascript:;" class="scm ad-list-btn"></a></div>
                </div>
                <div class="ad-top-right">
                    <div class="ad-welcom">
                        <div class="ad-wel-img"><img src="${pageContext.request.contextPath}/page/image/logo.jpg" height="36" width="36"></div>
                        <div class="ad-wel-text">
                            <div class="font-wel">欢迎您！<strong>${sessionScope.admin.adminName}</strong></div>
                            <div class="font-wel"><a href="javascript:;"><strong>【退出】</strong></a></div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="ad-sub-nav-box content-tabs">
                <div class="ad-sub-wraper page-tabs J_menuTabs">
                    <ul class="ad-sub-list page-tabs-content">
                        <a target="iframe0" href="${pageContext.request.contextPath}/page/tip.html" style="color: whitesmoke">
                            <li class="active J_menuTab" data-id="index.html">首页</li>
                        </a>
                    </ul>
                </div>
            </div>
        </div>
        <div class="ad-main-comment">
            <iframe class="J_iframe" name="iframe0" width="100%" height="542px" src="${pageContext.request.contextPath}/page/tip.html" frameborder="0" seamless></iframe>
        </div>
    </div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/js/contabs.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/js/maintabs.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/js/jquery-smartMenu-min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/js/jquery.nicescroll.min.js"></script>
<script type="text/javascript">
    $(function(){
        $(".ad-menu").niceScroll({cursorborder:"0 none",cursorcolor:"#1a1a19",cursoropacitymin:"0",boxzoom:false});
    })
</script>
</body>
</html>
