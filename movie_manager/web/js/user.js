$(function(){
    $.get("findUser", function(result){
        addTable(result);

        buttonClick();
    });
    add();
});
function addTable(result){
    $("#tab tr:not(:first)").empty();

    $.each(result, function(index, obj){
        var sex = "";
        if(obj.userSex == 1){
            sex = "男";
        }else{
            sex = "女";
        }

        $("table").append("<tr>" +
            "<td>"+(++index)+"</td>"+
            "<td>"+obj.userName+"</td>"+
            "<td>"+obj.userPassword+"</td>"+
            "<td>"+sex+"</td>"+
            "<td>"+obj.userAge+"</td>"+
            "<td>"+obj.userTel+"</td>"+
            "<td><input  alt='"+obj.userId+"' type='button' class='btn btn-danger btn-sm' value='编辑'></td>");
    });
}

//给添加按钮绑定click事件
function add(){
    $("#addUser").on("click", function(){
        $("#f1 :input").val("");
        //显示模式对话框
        $("#addUserView").modal("show");
    });
    save();
}

//给保存按钮添加事件
function save(){
    $("#save").on("click",function(){
        //序列化表单
        var params = $("#f1").serialize();
        $.post("addUser", params, function(result){
            alert(result);
            location.href = "user.html";
        });
    });
}


//给编辑按钮绑定事件
function buttonClick(){
    $("#tab :button").on("click", function(){
        $("#updateUserView").modal("show");
        var id = $(this).prop("alt");
        var verOne = $("#userSex option").eq(0).val();
        var verTwo = $("#userSex option").eq(1).val();
        var man = "男";
        var woman = "女";

        $("#userSex").empty();
        $.get("findUserById",{"user.userId":id}, function(result){

            $("#userId").val(result.userId);
            $("#userName").val(result.userName);
            $("#userPassword").val(result.userPassword);
            if(verOne == result.userSex){
                $("#userSex").append("<option value="+result.userSex+" selected='selected'>"+man+"</option>"+
                    "<option value="+verTwo+">"+woman+"</option>");
            }else{
                $("#userSex").append("<option value="+result.userSex+" selected='selected'>"+woman+"</option>"+
                    "<option value="+verOne+">"+man+"</option>");
            }
            $("#userAge").val(result.userAge);
            $("#userTel").val(result.userTel);
        });

        update();
        deleteUser();
    });
}


//给编辑事件的保存按钮添加事件
function update(){
    $("#update").off("click").on("click",function(){
        //序列化表单
        var params=$("#f2").serialize();
        //提交到后台更新
        $.post("updateUser", params ,function(result){
            //更新列表数据
            alert(result);
            location.href = "user.html";
        })
    });
}

function deleteUser(){
    $("#delete").on("click", function(){
        var params = $("#f2").serialize();
        $.post("deleteUser", params, function(result){
            alert(result);
            location.href = "user.html";
        })
    });
}