$(function(){
    $.get("movie_findMovie",{"pageNum":1}, function(result){
        addTable(result.list);
        $("#page").pagination(result.rowCount,{
            callback:findPageList,//点击页码发起的分页查询请求
            items_per_page:result.maxResult,//每页显示多少记录
            next_text:">",//下一页图标
            prev_text:"<",//上一页图标
            num_display_entries:2,//中间的主体显示页数
            num_edge_entries:1//边缘显示页数
        });
    });
    //findPage();
    add();
});
/*function findPage(){
    $("#findPageNum").on("click", function(){
        var pageNum  = $("#pageNum").val();
        if(pageNum == "" && pageNum == 0){
            alert("不能为空！");
        }else{
            findPageList(--pageNum);
        }
    });
}*/
//分页查询方法 ,分页控件在调用这个方法时会传入一个当前页的下表进来
function findPageList(pageNum){
    $.get("movie_findMovie",{"pageNum":++pageNum},function(result){
        addTable(result.list);
    });
}

function addTable(result){
    $("#movie_info").empty();
    $.each(result, function(index, obj){
        var types = "";
        var languages = "";
        $.each(obj.movieTypes, function(index, obj){
            types+=obj.movieTypeName+"/";
        });
        $.each(obj.movieLanguages, function(index, obj){
            languages+=obj.movieLanguageName+"/";
        });
        types = types.substring(0,types.length-1);
        languages = languages.substring(0,languages.length-1);
        $("#movie_info").append(
            "<div id='movie_div'>"+
            "<img src='../images/"+obj.moviePhoto+"' />"+
            "<p class='pho_name first-p'>"+obj.movieName+ "<span>["+types+"]</span></p>"+
            "<p class='dao'>◎导演：<span>"+obj.movieDirect+"</span></p>"+
            "<p class='yan'>◎演员：<span >"+obj.movieActor+"</span></p>"+
            "<p class='all'><span>◎地区："+obj.movieArea.movieAreaName+"</span><span>◎语言："+languages+"</span><span>◎年代："+obj.movieDate.movieDateName+"</span><span>◎时长："+obj.movieTime+"分钟</span></p>"+
            "<p class='hpo_desc'>◎描述："+obj.movieDesc+"</p>"+
            "<input type='button' alt='"+obj.movieId+"' class='btn-info' value='操作'/>"+
            "</div>");

    });

    buttonClick();
};

//给添加按钮绑定click事件
function add(){
    $("#addMovie").on("click", function(){
        $("#f1 :input").val("");
        //显示模式对话框
        $("#addMovieView").modal("show");

        //查询全部电影类型
        $.get("type_findType", function(result){
            $("#movieTypeName").empty();
            $.each(result, function(index, obj){
                $("#movieTypeName").append("    <input type='checkbox' value='"+
                    obj.movieTypeId+"' name='type' />"+obj.movieTypeName)
            });
        });

        //查询全部电影地区
        $.get("area_findArea", function(result){
            $("#movieAreaName").empty();
            $.each(result, function(key, obj){
                $("#movieAreaName").append("<option value="+obj.movieAreaId+">"+obj.movieAreaName+"</option>");
            });
        });

        //查找全部电影语言
        $.get("language_findLanguage", function(result){
            $("#movieLanguageName").empty();
            $.each(result, function(index, obj){
                $("#movieLanguageName").append("    <label><input type='checkbox' value='"+
                    obj.movieLanguageId+"' name='language' />"+obj.movieLanguageName+"</label>")
            });
        });

        //查询全部电影年代
        $.get("date_findDate", function(result){
            $("#movieDateName").empty();
            $.each(result, function(key, obj){
                $("#movieDateName").append("<option value="+obj.movieDateId+">"+obj.movieDateName+"</option>");
            });
        });

    });
    save();
}

//给保存按钮添加事件
function save(){
    $("#save").on("click",function(){
        //序列化表单
        var formData = new FormData(document.getElementById("f1"));
        $.ajax({
            url : "movie_addMovie",//请求的url
            type : "post",//请求类型
            data : formData,//表单数据
            processData: false,//让jquery不处理发送的数据
            contentType: false,//让Jquery不设置Content——Type请求头
            success : function(result){
                alert(result);
                location.href = "movieInfo.html";
            }
        });
    });
}


//给编辑按钮绑定事件
function buttonClick(){
    $("#movie_div .btn-info").on("click", function(){
        var id = $(this).prop("alt");
        $.get("movie_findMovieById",{"movie.movieId":id}, function(result){
            $("#movieId").val(result.movieId);
            $("#movieName").val(result.movieName);
            $("#moviePhoto").val(result.moviePhoto);
            $("#movieDesc").val(result.movieDesc);
            $("#movieTime").val(result.movieTime);
            $("#movieDirect").val(result.movieDirect);
            $("#movieActor").val(result.movieActor);

            var movieArea = result.movieArea.movieAreaName;
            $.get("area_findArea", function(result){
                $("#movieArea").empty();
                $.each(result, function(key, obj){
                    if(obj.movieAreaName == movieArea){
                        $("#movieArea").append("<option value="+obj.movieAreaId+" name='area' selected='selected'>"+obj.movieAreaName+"</option>");
                    }else{
                        $("#movieArea").append("<option value="+obj.movieAreaId+" name='area'>"+obj.movieAreaName+"</option>");
                    }
                });
            });


            var movieDate = result.movieDate.movieDateName;
            $.get("date_findDate", function(result){
                $("#movieDate").empty();
                $.each(result, function(key, obj){
                    if(obj.movieAreaName == movieDate){
                        $("#movieDate").append("<option value="+obj.movieDateId+" name='date' selected='selected'>"+obj.movieDateName+"</option>");
                    }else{
                        $("#movieDate").append("<option value="+obj.movieDateId+" name='date' >"+obj.movieDateName+"</option>");
                    }
                });
            });


            var types = result.movieTypes;
            $.get("type_findType", function(result){
                $("#movieType").empty();
                $.each(result, function(key, obj){
                    var typeName = obj.movieTypeName;
                    var i = 0;
                    $.each(types, function(index, obj){
                        if(obj.movieTypeName == typeName){
                            $("#movieType").append("  <input type='checkbox' checked='checked' name='type' value="+obj.movieTypeId+">"+obj.movieTypeName);
                            i = 1;
                        }
                    });
                    if(i != 1){
                        $("#movieType").append("  <input type='checkbox' name='type' value="+obj.movieTypeId+">"+obj.movieTypeName);
                    }
                });
            });

            var languages = result.movieLanguages;
            $.get("language_findLanguage", function(result){
                $("#movieLanguage").empty();
                $.each(result, function(key, obj){
                    var languageName = obj.movieLanguageName;
                    var i = 0;
                    $.each(languages, function(index, obj){
                        if(obj.movieLanguageName == languageName){
                            $("#movieLanguage").append("  <label><input type='checkbox' checked='checked' name='language' value="+obj.movieLanguageId+">"+obj.movieLanguageName+"</label>");
                            i = 1;
                        }
                    });
                    if(i != 1){
                        $("#movieLanguage").append("  <label><input type='checkbox' name='language' value="+obj.movieLanguageId+">"+obj.movieLanguageName+"</label>");
                    }
                });
            });
        });
        $("#updateMovieView").modal("show");

        updateMovie();
        deleteMovie();
    });
}


//给编辑事件的保存按钮添加事件
function updateMovie(){
    $("#update").off("click").on("click",function(){

        //序列化表单
        var formData = new FormData(document.getElementById("f2"));
        $.ajax({
            url : "movie_updateMovie",//请求的url
            type : "post",//请求类型
            data : formData,//表单数据
            processData: false,//让jquery不处理发送的数据
            contentType: false,//让Jquery不设置Content——Type请求头
            success : function(result){
                alert(result);
                location.href = "movieInfo.html";
            }
        });
    });
}

function deleteMovie(){
    $("#delete").on("click", function(){
        var params = $("#f2").serialize();
        $.post("movie_removeMovie", params, function(result){
            alert(result);
            location.href = "movieInfo.html";
        });
    });
}