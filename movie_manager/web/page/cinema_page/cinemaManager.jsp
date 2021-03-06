<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/04/13
  Time: 8:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>影院管理员</title>
    <script src="${pageContext.request.contextPath}/page/js/jquery-1.9.1.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/page/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/page/css/bootstrap.css">
    <script src="${pageContext.request.contextPath}/page/page_js/cinemaManager.js"></script>
</head>
<body>
<div class="container" style="width:98%">
    <h5 class="page-header">影院管理员管理</h5>
    <input id="addCinemaManager" type="button" class="btn btn-primary" value="添加影院管理员">
    <table class="table table-bordered table-hover table-condensed" id="tab">
        <tr>
            <td>编号</td>
            <td>名称</td>
            <td>密码</td>
            <td>所管理影院</td>
            <td>状态</td>
            <td>操作</td>
        </tr>
        <s:iterator value="#cinemaManagerList" var="cm" status="i">
            <tr>
                <td><s:property value="#i.index+1" /></td>
                <td><s:property value="#cm.cinemaManagerName" /></td>
                <td><s:property value="#cm.cinemaManagerPwd" /></td>
                <td><s:property value="#cm.cinema.cinemaName" /></td>
                <s:if test="#cm.ver == 1">
                    <td>可用</td>
                </s:if>
                <s:elseif test="#cm.ver == 0">
                    <td>禁用</td>
                </s:elseif>
                <td><input alt="<s:property value="#cm.cinemaManagerId" />" type="button" class="btn btn-danger btn-sm" value="编辑" /></td>
            </tr>
        </s:iterator>
    </table>
</div>

<!-- 添加影院管理员对话框 -->
<div class="modal fade" id="addCinemaManagerView">
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
                <h3 class="model-title">添加影院管理员</h3>
            </div>

            <!-- 内容主体 -->
            <div class="modal-body">
                <form id="f1">
                    <!-- 影院管理员名称 -->
                    <div class="form-group">
                        名称:
                        <input type="text" class="form-control" name="cinemaManager.cinemaManagerName" />
                    </div>

                    <!-- 影院管理员密码 -->
                    <div class="form-group">
                        密码:
                        <input type="text" class="form-control" name="cinemaManager.cinemaManagerPwd" />
                    </div>

                    <!-- 影院管理员所管理的影院 -->
                    <div class="form-group">
                        所管理影院:
                        <select class="form-control" name="cinema.cinemaId">
                            <option value="${sessionScope.cinemaManager.cinema.cinemaId}">${sessionScope.cinemaManager.cinema.cinemaName}</option>
                        </select>
                    </div>

                    <!-- 影院管理员状态 -->
                    <div class="form-group">
                        状态:
                        <select class="form-control" name="cinemaManager.ver">
                            <option value="1">可用</option>
                            <option value="0">禁用</option>
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

<!-- 编辑影院管理员对话框 -->
<div class="modal fade" id="updateCinemaManagerView">

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
                <h3 class="model-title">编辑影院管理员</h3>
            </div>

            <!-- 内容主体 -->
            <div class="modal-body">
                <form id="f2">
                    <input type="hidden" name="cinemaManager.cinemaManagerId" id="cinemaManagerId" />
                    <!-- 影院管理员名称 -->
                    <div class="form-group">
                        名称:
                        <input type="text" class="form-control" name="cinemaManager.cinemaManagerName" id="cinemaManagerName"/>
                    </div>

                    <!-- 影院管理员密码 -->
                    <div class="form-group">
                        密码:
                        <input type="text" class="form-control" name="cinemaManager.cinemaManagerPwd" id="cinemaManagerPwd">
                    </div>

                    <!-- 影院管理员所管理的影院 -->
                    <div class="form-group">
                        所管理影院:
                        <select class="form-control" name="cinema.cinemaId">
                            <option value="${sessionScope.cinemaManager.cinema.cinemaId}">${sessionScope.cinemaManager.cinema.cinemaName}</option>
                        </select>
                    </div>

                    <!-- 影院管理员状态 -->
                    <div class="form-group">
                        状态:
                        <select class="form-control" name="cinemaManager.ver" id="ver">
                            <option value="1">可用</option>
                            <option value="0">禁用</option>
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
