$(function(){
    $.get("areafindArea", function(result){
        addTable(result);

        buttonClick();
    });
    add();
});
function addTable(result){
    $("#tab tr:not(:first)").empty();

    $.each(result, function(index, obj){

        $("table").append("<tr>" +
            "<td>"+(++index)+"</td>"+
            "<td>"+obj.movieAreaName+"</td>"+
            "<td><input  alt='"+obj.movieAreaId+"' type='button' class='btn btn-danger btn-sm' value='编辑'></td>");
    });
}

//给添加按钮绑定click事件
function add(){
    $("#addArea").on("click", function(){
        //显示模式对话框
        $("#addAreaView").modal("show");
    });
    save();
}

//给保存按钮添加事件
function save(){
    $("#save").on("click",function(){
        //序列化表单
        var params = $("#f1").serialize();
        $.post("areaaddArea", params, function(result){
            alert(result);
            location.href = "movieArea.html";
        });
    });
}


//给编辑按钮绑定事件
function buttonClick(){
    $("#tab :button").on("click", function(){
        $("#updateAreaView").modal("show");
        var id = $(this).prop("alt");
        $.get("areafindAreaById",{"area.movieAreaId":id}, function(result){
            $("#movieAreaId").val(result.movieAreaId);
            $("#movieAreaName").val(result.movieAreaName);
        });

        updateArea();
        deleteArea();
    });
}


//给编辑事件的保存按钮添加事件
function updateArea(){
    $("#update").off("click").on("click",function(){
        //序列化表单
        var params=$("#f2").serialize();
        //提交到后台更新
        $.post("areaupdateArea", params ,function(result){
            //更新列表数据
            alert(result);
            location.href = "movieArea.html";
        });
    });
}

function deleteArea(){
    $("#delete").on("click", function(){
        var params = $("#f2").serialize();
        $.post("arearemoveArea", params, function(result){
            alert(result);
            location.href = "movieArea.html";
        });
    });
}