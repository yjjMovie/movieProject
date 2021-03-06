$(function(){

    $.get("cinema_findCinema", function(result){
        $("#selectCinema").empty();
        $.each(result, function(index, obj){
            $("#selectCinema").append("<option value='"+obj.cinemaId+"'>"+obj.cinemaName+"</option>")
        });
        var cid = $("#selectCinema").val();
        getHallByCinemaId(cid);
    });

    $("#selectCinema").change(function(){
        var cid = $(this).val();
        getHallByCinemaId(cid);
    });
    add();
});

function getHallByCinemaId(cid){

    $.post("hall_findHallByCinemaId", {"cinema.cinemaId":cid}, function(result){

        $("#selectHall").empty();
        $.each(result, function(index, obj){
            $("#selectHall").append("<option value='"+obj.movieHallId+"'>"+obj.movieHallName+"</option>");
        });
        addTable(result);
        buttonClick();
    });
}
function addTable(result){
    $("#tab tr:not(:first)").empty();
    var length = 0;
    $.each(result, function(index, obj){
        $.each(obj.hallRows, function(index, obj){
            var indexs = index;
            $("#tab").append("<div id='row"+indexs+"' class='hall_row' title='"+obj.hallRowId+"'>"+obj.hallRowName+"</div>");
            length = obj.hallColumns.length;
            $.each(obj.hallColumns,function (index,x) {
                $("#row"+indexs+"").append("<span><div class='colDiv'>"+x.hallColumnName+"</div></span>");
            });
            $("#row"+indexs+" span:gt("+(length-1)+")").empty();
        });
    });
}

//给添加按钮绑定click事件
function add(){
    $("#addHall").on("click", function(){
        $("#f1 :input").val("");
        $.get("cinema_findCinema", function(result){
            $("#cinema1").empty();
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
        $.post("hall_addHall", params, function(result){
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
        $.get("hall_findHallById",{"hall.movieHallId":id}, function(result){
            $("#movieHallId").val(result.movieHallId);
            $("#movieHallName").val(result.movieHallName);
            $("#movieHallColumn").val(result.seatColumn);
            $("#movieHallRow").val(result.seatRow);
            $("#movieHallNum").val(result.seatingNum);

            var cinemaName = result.cinema.cinemaName;

            $.get("cinema_findCinema", function(result){
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
        $.post("hall_updateHall", params ,function(result){
            //更新列表数据
            alert(result);
            location.href = "movieHall.html";
        })
    });
}

function deleteHall(){
    $("#delete").on("click", function(){
        var params = $("#f2").serialize();
        $.post("hall_removeHall", params, function(result){
            alert(result);
            location.href = "movieHall.html";
        })
    });
}