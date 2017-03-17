$(function(){
    $.get("findCinema", function(result){
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
            "<td>"+obj.cinemaName+"</td>"+
            "<td>"+obj.cinemaAddr+"</td>"+
            "<td>"+obj.cinemaTel+"</td>"+
            "<td><input  alt='"+obj.cinemaId+"' type='button' class='btn btn-danger btn-sm' value='编辑'></td>");
    });
}

//给添加按钮绑定click事件
function add(){
    $("#addCinema").on("click", function(){
        $("#f1 :input").val("");
        //显示模式对话框
        $("#addCinemaView").modal("show");
    });
    save();
}

//给保存按钮添加事件
function save(){
    $("#save").on("click",function(){
        //序列化表单
        var params = $("#f1").serialize();
        $.post("addCinema", params, function(result){
            alert(result);
            location.href = "cinema.html";
        });
    });
}


//给编辑按钮绑定事件
function buttonClick(){
    $("#tab :button").on("click", function(){
        $("#updateCinemaView").modal("show");
        var id = $(this).prop("alt");
        $.get("findCinemaById",{"cinema.cinemaId":id}, function(result){
            $("#cinemaId").val(result.cinemaId);
            $("#cinemaName").val(result.cinemaName);
            $("#cinemaAddr").val(result.cinemaAddr);
            $("#cinemaTel").val(result.cinemaTel);
        });

        update();
        deleteCinema();
    });
}


//给编辑事件的保存按钮添加事件
function update(){
    $("#update").off("click").on("click",function(){
        //序列化表单
        var params=$("#f2").serialize();
        //提交到后台更新
        $.post("updateCinema", params ,function(result){
            //更新列表数据
            alert(result);
            location.href = "cinema.html";
        })
    });
}

function deleteCinema(){
    $("#delete").on("click", function(){
        var params = $("#f2").serialize();
        $.post("deleteCinema", params, function(result){
            alert(result);
            location.href = "cinema.html";
        })
    });
}