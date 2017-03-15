$(function(){
    $.get("hallfindHall", function(result){
        addTable(result);

        buttonClick();
    });
    add();
});
function addTable(result){
    $("#tab tr:not(:first)").empty();

    $.each(result, function(index, obj){

        $("table").append("<tr>" +
            "<td>"+obj.movieHallId+"</td>"+
            "<td>"+obj.movieHallName+"</td>"+
            "<td>"+obj.seatColumn+"</td>"+
            "<td>"+obj.seatRow+"</td>"+
            "<td>"+obj.seatingNum+"</td>"+
            "<td>"+obj.cinema.cinemaName+"</td>"+
            "<td><input  alt='"+obj.movieHallId+"' type='button' class='btn btn-danger btn-sm' value='编辑'></td>");
    });
}

//给添加按钮绑定click事件
function add(){
    $("#addHall").on("click", function(){
        $("#f1 :input").val("");
        $.get("findCinema", function(result){
            $.each(result, function(index, obj){
                $("#cinema1").append("<option value='"+obj.cinemaId+"'>"+obj.cinemaName+"</option>");
            });
        });
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
        $.post("halladdHall", params, function(result){
            alert(result);
            location.href = "movieHall.html";
        });
    });
}


//给编辑按钮绑定事件
function buttonClick(){
    $("#tab :button").on("click", function(){
        $("#updateHallView").modal("show");
        var id = $(this).prop("alt");
        $.get("hallfindHallById",{"hall.movieHallId":id}, function(result){
            $("#movieHallId").val(result.movieHallId);
            $("#movieHallName").val(result.movieHallName);
            $("#movieHallColumn").val(result.seatColumn);
            $("#movieHallRow").val(result.seatRow);
            $("#movieHallNum").val(result.seatingNum);

            var cinemaName = result.cinema.cinemaName;

            $.get("findCinema", function(result){
                $("#cinema2").empty();
                $.each(result, function(key, obj){
                    if(obj.cinemaName == cinemaName){
                        $("#cinema2").append("<option value="+obj.cinemaId+" selected='selected'>"+obj.cinemaName+"</option>");
                    }else{
                        $("#cinema2").append("<option value="+obj.cinemaId+">"+obj.cinemaName+"</option>");
                    }

                });
            });

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
        $.post("hallupdateHall", params ,function(result){
            //更新列表数据
            alert(result);
            location.href = "movieHall.html";
        })
    });
}

function deleteHall(){
    $("#delete").on("click", function(){
        var params = $("#f2").serialize();
        $.post("hallremoveHall", params, function(result){
            alert(result);
            location.href = "movieHall.html";
        })
    });
}