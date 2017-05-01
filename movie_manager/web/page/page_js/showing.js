$(function(){
    buttonClick();
    add();
});

//给添加按钮绑定click事件
function add(){
    $("#addShowing").on("click", function(){
        $("#f1 :input").val("");
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
            window.location.reload();
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
            });
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
            window.location.reload();
        })
    });
}

function deleteShowing(){
    $("#delete").on("click", function(){
        var params = $("#f2").serialize();
        $.post("showing_deleteShowing", params, function(result){
            alert(result);
            window.location.reload();
        })
    });
}