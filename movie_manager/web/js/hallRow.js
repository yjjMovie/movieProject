$(function(){

    $.get("cinema_findCinema", function(result){
        $("#selectCinema").empty();
        $.each(result, function(index, obj){
            $("#selectCinema").append("<option value='"+obj.cinemaId+"'>"+obj.cinemaName+"</option>");
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

        var hid = $("#selectHall").val();
        addTable(hid);
    });

    $("#selectHall").change(function(){
        var hid = $(this).val();
        addTable(hid);
    });
}

function addTable(hid){
    $.post("row_findRowByHallId", {"movieHall.movieHallId":hid}, function(result){
        $("#tab tr:not(:first)").empty();
        $.each(result, function(index, obj){
            $("table").append("<tr>" +
                "<td>"+(++index)+"</td>"+
                "<td>"+obj.hallRowName+"</td>"+
                "<td><input  alt='"+obj.hallRowId+"' type='button' class='btn btn-danger btn-sm' value='编辑'></td>");
        });
        buttonClick();
    });

}

//给添加按钮绑定click事件
function add(){
    $("#addHallRow").on("click", function(){
        $("#f1 :input").val("");
        $.get("cinema_findCinema", function(result){
            $("#cinema").empty();
            $.each(result, function(index, obj){
                $("#cinema").append("<option value='"+obj.cinemaId+"'>"+obj.cinemaName+"</option>");
            });
            var cinemaId = $("#cinema").val();
            findHall(cinemaId);
        });
        //显示模式对话框
        $("#addHallRowView").modal("show");
    });
    $("#cinema").change(function(){
        var cid = $(this).val();
        findHall(cid);
    });
    save();
}
function findHall(cinemaId){

    $.post("hall_findHallByCinemaId", {"cinema.cinemaId":cinemaId}, function(result){
        $("#hall").empty();
        if(result.message != undefined){
            alert(result.message);
        }else{
            $.each(result, function(index, obj){
                $("#hall").append("<option value='"+obj.movieHallId+"'>"+obj.movieHallName+"</option>");
            });
        }
    });
}

//给保存按钮添加事件
function save(){
    $("#save").on("click",function(){
        //序列化表单
        var params = $("#f1").serialize();
        $.post("row_addRow", params, function(result){
            alert(result);
            window.location.reload();
        });
    });
}


//给编辑按钮绑定事件
function buttonClick(){
    $("#tab :button").on("click", function(){
        $("#updateHallRowView").modal("show");
        var id = $(this).prop("alt");
        $.post("row_findRowById",{"hallRow.hallRowId":id}, function(result){
            $("#hallRowId").val(result.hallRowId);
            $("#hallRowName").val(result.hallRowName);

            var cinemaName = result.movieHall.cinema.cinemaName;
            var hallName = result.movieHall.movieHallName;

            $.get("cinema_findCinema", function(result){
                $("#cinemaName").empty();
                $.each(result, function(key, obj){
                    if(obj.cinemaName == cinemaName){
                        $("#cinemaName").append("<option value="+obj.cinemaId+" selected='selected'>"+obj.cinemaName+"</option>");
                    }else{
                        $("#cinemaName").append("<option value="+obj.cinemaId+">"+obj.cinemaName+"</option>");
                    }
                });

                var cinemaId = $("#cinemaName").val();
                $.get("hall_findHallByCinemaId",{"cinema.cinemaId":cinemaId}, function(result){
                    $("#hallName").empty();
                    $.each(result, function(index,obj){
                        if(obj.movieHallName == hallName){
                            $("#hallName").append("<option value='"+obj.movieHallId+"' selected='selected'>"+obj.movieHallName+"</option>");
                        }else{
                            $("#hallName").append("<option value='"+obj.movieHallId+"'>"+obj.movieHallName+"</option>");
                        }
                    });
                });
            });
        });

        $("#cinemaName").change(function(){
            var cinemaId = $(this).val();
            updateRow(cinemaId);
        });
        update();
        deleteHall();
    });
}

function updateRow(cinemaId) {
    $.post("hall_findHallByCinemaId", {"cinema.cinemaId":cinemaId}, function(result){
        $("#hallName").empty();
        $.each(result, function(index, obj){
            $("#hallName").append("<option value='"+obj.movieHallId+"'>"+obj.movieHallName+"</option>");
        });
    });
}


//给编辑事件的保存按钮添加事件
function update(){
    $("#update").off("click").on("click",function(){
        //序列化表单
        var params=$("#f2").serialize();
        //提交到后台更新
        $.post("row_updateRow", params ,function(result){
            //更新列表数据
            alert(result);
            window.location.reload();
        })
    });
}

function deleteHall(){
    $("#delete").on("click", function(){
        var params = $("#f2").serialize();
        $.post("row_removeRow", params, function(result){
            alert(result);
            window.location.reload();
        })
    });
}