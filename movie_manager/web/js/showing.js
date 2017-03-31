$(function(){
    $.get("showing_findShowing", function(result){
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
            "<td>"+obj.movie.movieName+"</td>"+
            "<td>"+obj.showingTime+"</td>"+
            "<td>"+obj.outawayTime+"</td>"+
            "<td>"+obj.cinemas[0].cinemaName+"</td>"+
            "<td><input  alt='"+obj.showingId+"' type='button' class='btn btn-danger btn-sm' value='编辑'></td>");
    });
}

//给添加按钮绑定click事件
function add(){
    $("#addShowing").on("click", function(){
        $("#f1 :input").val("");
        $.get("cinema_findCinema", function(result){
            $("#cinema").empty();
            $.each(result, function(index, obj){
                $("#cinema").append("<option value='"+obj.cinemaId+"'>"+obj.cinemaName+"</option>");
            });
        })
        $.get("movie_findMovieList", function(result){
            $("#movie").empty();
            $.each(result, function(index, obj){
                $("#movie").append("<option value='"+obj.movieId+"'>"+obj.movieName+"</option>");
            });
        })
        //显示模式对话框
        $("#addShowingView").modal("show");
    });
    save();
}

//给保存按钮添加事件
function save(){
    $("#save").on("click",function(){
        //序列化表单
        var params = $("#f1").serialize();
        $.post("showing_addShowing", params, function(result){
            alert(result);
            location.href = "showing.html";
        });
    });
}


//给编辑按钮绑定事件
function buttonClick(){
    $("#tab :button").on("click", function(){
        $("#updateShowingView").modal("show");
        var id = $(this).prop("alt");

        $.get("showing_findShowingById",{"showing.showingId":id}, function(result){
            $("#showingId").val(result.showingId);
            $("#showingTime").val(result.showingTime);
            $("#outawayTime").val(result.outawayTime);
            var cinemaNames = result.cinemas[0].cinemaName;
            var movieName = result.movie.movieName;

            $.get("movie_findMovieList", function(result){
                $("#movieName").empty();
                $.each(result, function(index, obj){
                    if(obj.movieName == movieName){
                        $("#movieName").append("<option value='"+obj.movieId+"' selected='selected'>"+obj.movieName+"</option>");

                    }else{
                        $("#movieName").append("<option value='"+obj.movieId+"'>"+obj.movieName+"</option>");
                    }
                });
            })

            $.get("cinema_findCinema", function(result){
                $("#cinemaName").empty();
                $.each(result, function(index, obj){
                    if(obj.cinemaName == cinemaNames){
                        $("#cinemaName").append("<option value='"+obj.cinemaId+"' selected='selected'>"+obj.cinemaName+"</option>");

                    }else{
                        $("#cinemaName").append("<option value='"+obj.cinemaId+"'>"+obj.cinemaName+"</option>");
                    }
                });
            })
        });
        update();
        deleteShowing();
    });
}


//给编辑事件的保存按钮添加事件
function update(){
    $("#update").off("click").on("click",function(){
        //序列化表单
        var params=$("#f2").serialize();
        //提交到后台更新
        $.post("showing_updateShowing", params ,function(result){
            //更新列表数据
            alert(result);
            location.href = "showing.html";
        })
    });
}

function deleteShowing(){
    $("#delete").on("click", function(){
        var params = $("#f2").serialize();
        $.post("showing_deleteShowing", params, function(result){
            alert(result);
            location.href = "showing.html";
        })
    });
}