$(function(){
    $.get("comment_findComment", function(result){
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
            "<td>"+obj.commentDesc+"</td>"+
            "<td>"+obj.commentTime+"</td>"+
            "<td>"+obj.user.userName+"</td>"+
            "<td>"+obj.movie.movieName+"</td>"+
            "<td><input  alt='"+obj.commentId+"' type='button' class='btn btn-danger btn-sm' value='编辑'></td>");
    });
}

//给添加按钮绑定click事件
function add(){
    $("#addComment").on("click", function(){
        $("#f1 :input").val("");
        $.get("findUser", function(result){
            $.each(result, function(index, obj){
                $("#user").append("<option value='"+obj.userId+"'>"+obj.userName+"</option>");
            });
        })
        $.get("moviefindMovieList", function(result){
            $.each(result, function(index, obj){
                $("#movie").append("<option value='"+obj.movieId+"'>"+obj.movieName+"</option>");
            });
        })
        //显示模式对话框
        $("#addCommentView").modal("show");
    });
    save();
}

//给保存按钮添加事件
function save(){
    $("#save").on("click",function(){
        //序列化表单
        var params = $("#f1").serialize();
        $.post("comment_addComment", params, function(result){
            alert(result);
            location.href = "comment.html";
        });
    });
}


//给编辑按钮绑定事件
function buttonClick(){
    $("#tab :button").on("click", function(){
        $("#updateCommentView").modal("show");
        var id = $(this).prop("alt");

        $.get("comment_findCommentById",{"comment.commentId":id}, function(result){
            $("#commentId").val(result.commentId);
            $("#commentDesc").val(result.commentDesc);
            $("#commentTime").val(result.commentTime);
            var userName = result.user.userName;
            var movieName = result.movie.movieName;


            $.get("findUser", function(result){
                $("#userName").empty();
                $.each(result, function(index, obj){
                    if(obj.userName == userName){
                        $("#userName").append("<option value='"+obj.userId+"' selected='selected'>"+obj.userName+"</option>");
                    }else{
                        $("#userName").append("<option value='"+obj.userId+"'>"+obj.userName+"</option>");
                    }
                });
            })

            $.get("moviefindMovieList", function(result){
                $("#movieName").empty();
                $.each(result, function(index, obj){
                    if(obj.movieName == movieName){
                        $("#movieName").append("<option value='"+obj.movieId+"' selected='selected'>"+obj.movieName+"</option>");

                    }else{
                        $("#movieName").append("<option value='"+obj.movieId+"'>"+obj.movieName+"</option>");
                    }
                });
            })

        });

        update();
        deleteComment();
    });
}


//给编辑事件的保存按钮添加事件
function update(){
    $("#update").off("click").on("click",function(){
        //序列化表单
        var params=$("#f2").serialize();
        //提交到后台更新
        $.post("comment_updateComment", params ,function(result){
            //更新列表数据
            alert(result);
            location.href = "comment.html";
        })
    });
}

function deleteComment(){
    $("#delete").on("click", function(){
        var params = $("#f2").serialize();
        $.post("comment_deleteComment", params, function(result){
            alert(result);
            location.href = "comment.html";
        })
    });
}
