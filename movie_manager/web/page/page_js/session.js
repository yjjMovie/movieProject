$(function(){

    buttonClick();
    add();
});

//给添加按钮绑定click事件
function add(){
    $("#addSession").on("click", function(){
        $("#f1 :input").val("");

        var cinemaId = $("#cinemaName option").val();
        findHallAndMovieInfo(cinemaId);
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
                $("#movieName").append("<option value='"+obj.movieId+"'>"+obj.movieName+"</option>");
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

            var hallName = result.movieHall.movieHallName;
            var movieName = result.movie.movieName;

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
                    if(obj.movieName == movieName){
                        $("#movie").append("<option value='"+obj.movieId+"' selected='selected'>"+obj.movieName+"</option>");
                    }else{
                        $("#movie").append("<option value='"+obj.movieId+"'>"+obj.movieName+"</option>");
                    }
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
            $("#movie").append("<option value='"+obj.movieId+"'>"+obj.movieName+"</option>");
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