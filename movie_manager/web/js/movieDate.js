$(function(){
    $.get("datefindDate", function(result){
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
            "<td>"+obj.movieDateName+"</td>"+
            "<td><input  alt='"+obj.movieDateId+"' type='button' class='btn btn-danger btn-sm' value='编辑'></td>");
    });
}

//给添加按钮绑定click事件
function add(){
    $("#addDate").on("click", function(){
        //显示模式对话框
        $("#addDateView").modal("show");
    });
    save();
}

//给保存按钮添加事件
function save(){
    $("#save").on("click",function(){
        //序列化表单
        var params = $("#f1").serialize();
        $.post("dateaddDate", params, function(result){
            alert(result);
            location.href = "movieDate.html";
        });
    });
}


//给编辑按钮绑定事件
function buttonClick(){
    $("#tab :button").on("click", function(){
        $("#updateDateView").modal("show");
        var id = $(this).prop("alt");
        $.get("datefindDateById",{"date.movieDateId":id}, function(result){
            $("#movieDateId").val(result.movieDateId);
            $("#movieDateName").val(result.movieDateName);
        });

        update();
        deleteDate();
    });
}


//给编辑事件的保存按钮添加事件
function update(){
    $("#update").off("click").on("click",function(){
        //序列化表单
        var params=$("#f2").serialize();
        //提交到后台更新
        $.post("dateupdateDate", params ,function(result){
            //更新列表数据
            alert(result);
            location.href = "movieDate.html";
        });
    });
}

function deleteDate(){
    $("#delete").on("click", function(){
        var params = $("#f2").serialize();
        $.post("dateremoveDate", params, function(result){
            alert(result);
            location.href = "movieDate.html";
        });
    });
}