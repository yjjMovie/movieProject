$(function(){

    buttonClick();
    add();
});


//给添加按钮绑定click事件
function add(){
    $("#addHall").on("click", function(){
        $("#f1 :input").val("");
        //显示模式对话框
        $("#addHallView").modal("show");
    });
    save();
}

//给保存按钮添加事件
function save(){
    $("#save").on("click",function(){
        //序列化表单
        var params = $("#f1").serialize();
        $.post("hall_addHall", params, function(result){
            alert(result);
            window.location.reload();
        });
    });
}


//给编辑按钮绑定事件
function buttonClick(){
    $("#tab :button").on("click", function(){
        $("#updateHallView").modal("show");
        var id = $(this).prop("alt");
        $.get("hall_findHallById",{"hall.movieHallId":id}, function(result){
            $("#movieHallId").val(result.movieHallId);
            $("#movieHallName").val(result.movieHallName);
            $("#movieHallColumn").val(result.seatColumn);
            $("#movieHallRow").val(result.seatRow);
            $("#movieHallNum").val(result.seatingNum);
        });

        update();
        deleteHall();
    });
}


//给编辑事件的保存按钮添加事件
function update(){
    $("#update").off("click").on("click",function(){
        //序列化表单
        var params=$("#f2").serialize();
        //提交到后台更新
        $.post("hall_updateHall", params ,function(result){
            //更新列表数据
            alert(result);
            window.location.reload();
        })
    });
}

function deleteHall(){
    $("#delete").on("click", function(){
        var params = $("#f2").serialize();
        $.post("hall_removeHall", params, function(result){
            alert(result);
            window.location.reload();
        })
    });
}