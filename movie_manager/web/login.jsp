<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/03/29
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-1.9.1.min.js"></script>
    <link rel="stylesheet" href="css/login.css">
    <script src="js/login.js"></script>

</head>
<body>

<div id="all">
    <div id="title">
        &nbsp&nbsp登录(Login)
    </div>
    <form id="f1">
        <table>
            <tr>
                <td class="Ye">用&nbsp户&nbsp名：</td>
                <td><input type="text" name="admin.adminName" id="name" placeholder="请输入用户名"></td>
                <td width="40%"><div id="checkName"></div></td>
            </tr>
            <tr>
                <td class="Ye">密&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp码：</td>
                <td><input type="password" name="admin.adminPassword" id="pwd" placeholder="请输入密码"></td>
                <td><div id="checkPwd"></div></td>
            </tr>
            <tr>
                <td colspan="3"><input type="button" name="submit" value="登录" id="submit"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
