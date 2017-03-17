$(function(){
    $.get("typefindType", function(result){
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
            "<td>"+obj.movieTypeName+"</td>"+
            "<td><input  alt='"+obj.movieTypeId+"' type='button' class='btn btn-danger btn-sm' value='编辑'></td>");
    });
}

//给添加按钮绑定click事件
function add(){
    $("#addType").on("click", function(){
        //显示模式对话框
        $("#addTypeView").modal("show");
    });
    save();
}

//给保存按钮添加事件
function save(){
    $("#save").on("click",function(){
        //序列化表单
        var params = $("#f1").serialize();
        $.post("typeaddType", params, function(result){
            alert(result);
            location.href = "movieType.html";
        });
    });
}


//给编辑按钮绑定事件
function buttonClick(){
    $("#tab :button").on("click", function(){
        $("#updateTypeView").modal("show");
        var id = $(this).prop("alt");
        $.get("typefindTypeById",{"type.movieTypeId":id}, function(result){
            $("#movieTypeId").val(result.movieTypeId);
            $("#movieTypeName").val(result.movieTypeName);
        });

        update();
        deleteType();
    });
}


//给编辑事件的保存按钮添加事件
function update(){
    $("#update").off("click").on("click",function(){
        //序列化表单
        var params=$("#f2").serialize();
        //提交到后台更新
        $.post("typeupdateType", params ,function(result){
            //更新列表数据
            alert(result);
            location.href = "movieType.html";
        });
    });
}

function deleteType(){
    $("#delete").on("click", function(){
        var params = $("#f2").serialize();
        $.post("typeremoveType", params, function(result){
            alert(result);
            location.href = "movieType.html";
        });
    });
}