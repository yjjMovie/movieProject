$(function(){

    $.get("cinema_findCinema", function(result){
        $("#selectCinema").empty();
        $.each(result, function(index, obj){
            $("#selectCinema").append("<option value='"+obj.cinemaId+"'>"+obj.cinemaName+"</option>")
        });
        var cid = $("#selectCinema").val();
        getSessionByCinemaId(cid);
    });

    $("#selectCinema").change(function(){
        var cid = $(this).val();
        getSessionByCinemaId(cid);
    });
    add();
});

function getSessionByCinemaId(cid){

    $.post("session_findSessionByCinemaId", {"cinema.cinemaId":cid}, function(result){
        addTable(result);
        buttonClick();
    });
}
function addTable(result){
    $("#tab tr:not(:first)").empty();
    $.each(result, function(index, obj){
        $("table").append("<tr>" +
            "<td>"+(++index)+"</td>"+
            "<td>"+obj.movie.movieName+"</td>"+
            "<td>"+obj.startTime+"</td>"+
            "<td>"+obj.endTime+"</td>"+
            "<td>"+obj.cinema.cinemaName+"</td>"+
            "<td>"+obj.movieHall.movieHallName+"</td>"+
            "<td>"+obj.sessionPrice+"</td>"+
            "<td><input  alt='"+obj.sessionId+"' type='button' class='btn btn-danger btn-sm' value='编辑'></td>");
    });
}

//给添加按钮绑定click事件
function add(){
    $("#addSession").on("click", function(){
        $("#f1 :input").val("");

        $.get("cinema_findCinema", function(result){
            $("#cinemaName").empty();
            $.each(result, function(index,obj){
                $("#cinemaName").append("<option value='"+obj.cinemaId+"'>"+obj.cinemaName+"</option>");
            });
            var cinemaId = $("#cinemaName option").val();
            findHallAndMovieInfo(cinemaId);
        });
        //显示模式对话框
        $("#addSessionView").modal("show");
    });
    $("#cinemaName").change(function(){
        var cid = $(this).val();
        findHallAndMovieInfo(cid);
    });
    save();
}
function findHallAndMovieInfo(cinemaId){

    $.post("hall_findHallByCinemaId", {"cinema.cinemaId":cinemaId}, function(result){
        $("#hallName").empty();
        if(result.message != undefined){
            alert(result.message);
        }else{
            $.each(result, function(index, obj){
                $("#hallName").append("<option value='"+obj.movieHallId+"'>"+obj.movieHallName+"</option>");
            });
        }
    });
    $.post("showing_findShowingByCinemaId", {"cinema.cinemaId":cinemaId}, function(result){
        $("#movieName").empty();
        if(result.message != undefined){
            alert(result.message);
        }else{
            $.each(result, function(index, obj){
                $("#movieName").append("<option value='"+obj.movie.movieId+"'>"+obj.movie.movieName+"</option>");
            });
        }
    });
}

//给保存按钮添加事件
function save(){
    $("#save").on("click",function(){
        //序列化表单
        var params = $("#f1").serialize();
        $.post("session_addSession", params, function(result){
            alert(result);
            window.location.reload();
        });
    });
}


//给编辑按钮绑定事件
function buttonClick(){
    $("#tab :button").on("click", function(){
        $("#updateSessionView").modal("show");
        var id = $(this).prop("alt");
        $.get("session_findSessionById",{"movieSession.sessionId":id}, function(result){
            $("#sessionId").val(result.sessionId);
            $("#startTime").val(result.startTime);
            $("#endTime").val(result.endTime);
            $("#sessionPrice").val(result.sessionPrice);

            var cinemaName = result.cinema.cinemaName;
            var hallName = result.movieHall.movieHallName;
            var movieName = result.movie.movieName;
            $.get("cinema_findCinema", function(result){
                $("#cinema").empty();
                $.each(result, function(index,obj){
                    if(obj.cinemaName == cinemaName){
                        $("#cinema").append("<option value='"+obj.cinemaId+"' selected='selected'>"+obj.cinemaName+"</option>");
                    }else{
                        $("#cinema").append("<option value='"+obj.cinemaId+"'>"+obj.cinemaName+"</option>");
                    }
                });

                var cinemaId = $("#cinema option:selected").val();
                $.get("hall_findHallByCinemaId",{"cinema.cinemaId":cinemaId}, function(result){
                    $("#hall").empty();
                    $.each(result, function(index,obj){
                        if(obj.movieHallName == hallName){
                            $("#hall").append("<option value='"+obj.movieHallId+"' selected='selected'>"+obj.movieHallName+"</option>");
                        }else{
                            $("#hall").append("<option value='"+obj.movieHallId+"'>"+obj.movieHallName+"</option>");
                        }
                    });
                });

                $.get("showing_findShowingByCinemaId", {"cinema.cinemaId":cinemaId}, function(result){
                    $("#movie").empty();
                    $.each(result, function(index,obj){
                        if(obj.movie.movieName == movieName){
                            $("#movie").append("<option value='"+obj.movie.movieId+"' selected='selected'>"+obj.movie.movieName+"</option>");
                        }else{
                            $("#movie").append("<option value='"+obj.movie.movieId+"'>"+obj.movie.movieName+"</option>");
                        }
                    });
                });
            });

        });

        $("#cinema").change(function(){
            var cid = $(this).val();
            updateHallAndMovieInfo(cid);
        });

        update();
        deleteSession();
    });
}

function updateHallAndMovieInfo(cinemaId){

    $.post("hall_findHallByCinemaId", {"cinema.cinemaId":cinemaId}, function(result){
        $("#hall").empty();
        $.each(result, function(index, obj){
            $("#hall").append("<option value='"+obj.movieHallId+"'>"+obj.movieHallName+"</option>");
        });
    });
    $.post("showing_findShowingByCinemaId", {"cinema.cinemaId":cinemaId}, function(result){
        $("#movie").empty();
        $.each(result, function(index, obj){
            $("#movie").append("<option value='"+obj.movie.movieId+"'>"+obj.movie.movieName+"</option>");
        });
    });
}


//给编辑事件的保存按钮添加事件
function update(){
    $("#update").off("click").on("click",function(){
        //序列化表单
        var params=$("#f2").serialize();
        //提交到后台更新
        $.post("session_updateSession", params ,function(result){
            //更新列表数据
            alert(result);
            window.location.reload();
        });
    });
}

function deleteSession(){
    $("#delete").on("click", function(){
        var params = $("#f2").serialize();
        $.post("session_deleteSession", params, function(result){
            alert(result);
            window.location.reload();
        })
    });
}