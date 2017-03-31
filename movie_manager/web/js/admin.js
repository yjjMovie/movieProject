$(function(){
    $.get("admin_findAdmin", function(result){
        addTable(result);

        buttonClick();
    });
    add();
});
function addTable(result){
    $("#tab tr:not(:first)").empty();
    $.each(result, function(index, obj){
        var ver = "";
        if(obj.ver == 1){
            ver = "可用";
        }else{
            ver = "禁用";
        }
        $("table").append("<tr>" +
            "<td>"+(++index)+"</td>"+
            "<td>"+obj.adminName+"</td>"+
            "<td>"+obj.adminPassword+"</td>"+
            "<td>"+ver+"</td>"+
            "<td><input  alt='"+obj.adminId+"' type='button' class='btn btn-danger btn-sm' value='编辑'></td>");
    });
}

//给添加按钮绑定click事件
function add(){
    $("#addAdmin").on("click", function(){
        $("#f1 :input").val("");
        //显示模式对话框
        $("#addAdminView").modal("show");
    });
    save();
}

//给保存按钮添加事件
function save(){
    $("#save").on("click",function(){
        //序列化表单
        var params = $("#f1").serialize();
        $.post("admin_addAdmin", params, function(result){
            alert(result);
            location.href = "admin.html";
        });
    });
}


//给编辑按钮绑定事件
function buttonClick(){
    $("#tab :button").on("click", function(){
        $("#updateAdminView").modal("show");
        var id = $(this).prop("alt");
        var verOne = $("#ver option").eq(0).val();
        var verTwo = $("#ver option").eq(1).val();
        var verName1 = "可用";
        var verName2 = "禁用";

        $("#ver").empty();
        $.get("admin_findAdminById",{"admin.adminId":id}, function(result){

            $("#adminId").val(result.adminId);
            $("#adminName").val(result.adminName);
            $("#adminPwd").val(result.adminPassword);
            if(verOne == result.ver){
                $("#ver").append("<option value="+result.ver+" selected='selected'>"+verName1+"</option>"+
                    "<option value="+verTwo+">"+verName2+"</option>");
            }else{
                $("#ver").append("<option value="+result.ver+" selected='selected'>"+verName2+"</option>"+
                    "<option value="+verOne+">"+verName1+"</option>");
            }
        });

        update();
        deleteAdmin();
    });
}


//给编辑事件的保存按钮添加事件
function update(){
    $("#update").off("click").on("click",function(){
        //序列化表单
        var params=$("#f2").serialize();
        //提交到后台更新
        $.post("admin_updateAdmin", params ,function(result){
            //更新列表数据
            alert(result);
            location.href = "admin.html";
        });
    });
}

function deleteAdmin(){
    $("#delete").on("click", function(){
        var params = $("#f2").serialize();
        $.post("admin_deleteAdmin", params, function(result){
            alert(result);
            location.href = "admin.html";
        })
    });
}