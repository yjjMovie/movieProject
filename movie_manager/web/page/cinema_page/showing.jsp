<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/04/12
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>MOVIE管理系统</title>

    <script src="${pageContext.request.contextPath}/page/js/jquery-1.9.1.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/page/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/page/css/bootstrap.css">
    <script src="${pageContext.request.contextPath}/page/page_js/showing.js"></script>
</head>
<body>

<div class="container" style="width: 98%;">
    <h5 class="page-header">影片上映管理</h5>
    <input id="addShowing" type="button" class="btn btn-primary" value="添加上映电影">
    <table class="table table-bordered table-hover table-condensed" id="tab">
        <tr>
            <td>编号</td>
            <td>上映电影</td>
            <td>上映时间</td>
            <td>下架时间</td>
            <td>上映所属影院</td>
            <td>操作</td>
        </tr>
        <s:iterator value="#showingList" var="showing" status="i">
            <tr>
                <td><s:property value="#i.index+1" /></td>
                <td><s:property value="#showing.movie.movieName" /></td>
                <td><s:date name="#showing.showingTime" format="yyyy-MM-dd HH:mm:ss" /></td>
                <td><s:date name="#showing.outawayTime" format="yyyy-MM-dd HH:mm:ss" /></td>
                <s:iterator value="#showing.cinemas" var="cinema">
                    <td><s:property value="#cinema.cinemaName" /></td>
                </s:iterator>
                <td><input  alt="<s:property value="#showing.showingId" />" type="button" class="btn btn-danger btn-sm" value="编辑"></td>
            </tr>
        </s:iterator>
    </table>
</div>


<!-- 添加影院对话框 -->
<div class="modal fade" id="addShowingView">

    <!-- 模式对话框的主体，包括一些遮罩层样式 -->
    <div class="modal-dialog">


        <!-- 这个div将涵盖对话框的内容，内容分为三部分，内容头部、内容主体、内容尾部 -->
        <div class="modal-content">
            <!-- 内容头部 -->
            <div class="modal-header">
                <!-- 关闭按钮 -->
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <!-- 标题 -->
                <h3 class="model-title">添加上映电影</h3>
            </div>

            <!-- 内容主体 -->
            <div class="modal-body">
                <form id="f1">

                    <!-- 上映时间-->
                    <div class="form-group">
                        上映时间:
                        <input type="text" class="form-control" name="showing.showingTime"/>
                    </div>
                    <!-- 下映时间-->
                    <div class="form-group">
                        下映时间:
                        <input type="text" class="form-control" name="showing.outawayTime"/>
                    </div>
                    <!-- 上映电影 -->
                    <div class="form-group">
                        上映电影:
                        <select class="form-control" name="movie.movieId" id="movie" />
                        </select>
                    </div>
                    <!-- 上映所属影院 -->
                    <div class="form-group">
                        上映所属影院:
                        <select class="form-control" name="cinema.cinemaId" />
                            <option value="${sessionScope.cinemaManager.cinema.cinemaId}">${sessionScope.cinemaManager.cinema.cinemaName}</option>
                        </select>
                    </div>
                </form>
            </div>

            <!-- 内容尾部 -->
            <div class="modal-footer">
                <input type="button" class="btn btn-default" value="关闭" data-dismiss="modal"/>
                <input type="button" id="save" class="btn btn-primary" value="保存"/>
            </div>
        </div>
    </div>
</div>

<!-- 编辑业务人员对话框 -->
<div class="modal fade" id="updateShowingView">

    <!-- 模式对话框的主体，包括一些遮罩层样式 -->
    <div class="modal-dialog">


        <!-- 这个div将涵盖对话框的内容，内容分为三部分，内容头部、内容主体、内容尾部 -->
        <div class="modal-content">
            <!-- 内容头部 -->
            <div class="modal-header">
                <!-- 关闭按钮 -->
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <!-- 标题 -->
                <h3 class="model-title">编辑上映信息</h3>
            </div>

            <!-- 内容主体 -->
            <div class="modal-body">
                <form id="f2">
                    <input type="hidden" name="showing.showingId" id="showingId" />


                    <!-- 上映时间-->
                    <div class="form-group">
                        上映时间:
                        <input type="text" class="form-control" name="showing.showingTime" id="showingTime"/>
                    </div>
                    <!-- 下映时间-->
                    <div class="form-group">
                        下映时间:
                        <input type="text" class="form-control" name="showing.outawayTime" id="outawayTime"/>
                    </div>
                    <!-- 上映电影 -->
                    <div class="form-group">
                        上映电影:
                        <select class="form-control" name="movie.movieId" id="movieName" />
                        </select>
                    </div>
                    <!-- 上映所属影院 -->
                    <div class="form-group">
                        上映所属影院:
                        <select class="form-control" name="cinema.cinemaId" />
                            <option value="${sessionScope.cinemaManager.cinema.cinemaId}">${sessionScope.cinemaManager.cinema.cinemaName}</option>
                        </select>
                    </div>
                </form>
            </div>

            <!-- 内容尾部 -->
            <div class="modal-footer">
                <input type="button" id="update" class="btn btn-primary" value="保存"/>
                <input type="button" id="delete" class="btn btn-primary" value="删除"/>
            </div>
        </div>
    </div>
</div>
</body>
</html>
