$(function(){

    //用户名的失焦
    $("#name").blur(function(){
        var reg=/^[\da-zA-Z]{3,15}$/;
        if($("#name").val() == ""){
            $("#checkName").html("!此处不能留空").css({color:"red"});
        }else if(!reg.test($("#name").val())){
            $("#checkName").html("!格式错误").css({color:"red"});
        }else{
            $("#checkName").html("√").css({color:"green"});
        }
    });


    //密码的失焦
    $("#pwd").blur(function(){
        var reg = /^[0-9a-zA-Z]{3,15}$/;
        if($("#pwd").val() == ""){
            $("#checkPwd").html("!此处不能留空").css({color:"red"});
        }else if(!reg.test($("#pwd").val())){
            $("#checkPwd").html("!格式错误").css({color:"red"});
        }else{
            $("#checkPwd").html("√").css({color:"green"});
        }
    });



    /*//按钮提交事件
    $(":button").click(function(){
        if($("#checkName").html() == "√" && $("#checkPwd").html() == "√"){
            var params = $("#f1").serialize();
            $.post("admin_login", params/!*, function(result){
                if(result == "登陆成功"){
                    location.href = "page/index.jsp";
                }else{
                    alert(result);
                }
            }*!/);
        }else{
            alert("验证不通过！");
            return false;
        }
    });*/

});