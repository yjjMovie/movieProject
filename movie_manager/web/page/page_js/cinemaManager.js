$(function(){
    buttonClick();
    add();
});

//给添加按钮绑定click事件
function add(){
    $("#addCinemaManager").on("click", function(){
        $("#f1 :input").val("");
        //显示模式对话框
        $("#addCinemaManagerView").modal("show");
    });
    save();
}

//给保存按钮添加事件
function save(){
    $("#save").on("click",function(){
        var params = $("#f1").serialize();
        $.post("cinemaManager_addCinemaManager", params, function(result){
            if(result.message != undefined){
               alert(result.message);
            }else{
               alert(result);
               window.location.reload();
            }
        });
    });
}


//给编辑按钮绑定事件
function buttonClick(){
    $("#tab :button").on("click", function(){
        $("#updateCinemaManagerView").modal("show");
        var id = $(this).prop("alt");

        var verOne = $("#ver option").eq(0).val();
        var verTwo = $("#ver option").eq(1).val();
        var verName1 = "可用";
        var verName2 = "禁用";
        $("#ver").empty();

        $.get("cinemaManager_findCinemaManagerById",{"cinemaManager.cinemaManagerId":id}, function(result){
            $("#cinemaManagerId").val(result.cinemaManagerId);
            $("#cinemaManagerName").val(result.cinemaManagerName);
            $("#cinemaManagerPwd").val(result.cinemaManagerPwd);

            if(verOne == result.ver){
                $("#ver").append("<option value="+result.ver+" selected='selected'>"+verName1+"</option>"+
                    "<option value="+verTwo+">"+verName2+"</option>");
            }else{
                $("#ver").append("<option value="+result.ver+" selected='selected'>"+verName2+"</option>"+
                    "<option value="+verOne+">"+verName1+"</option>");
            }

        });

        update();
        deleteCinemaManager();
    });
}


//给编辑事件的保存按钮添加事件
function update(){
    $("#update").off("click").on("click",function(){
        //序列化表单
        var params=$("#f2").serialize();
        //提交到后台更新
        $.post("cinemaManager_updateCinemaManager", params ,function(result){
            //更新列表数据
            if(result.message != undefined){
                alert(result.message);
            }else{
                alert(result);
                window.location.reload();
            }
        });
    });
}

function deleteCinemaManager(){
    $("#delete").on("click", function(){
        var params = $("#f2").serialize();
        $.post("cinemaManager_removeCinemaManager", params, function(result){
            alert(result);
            window.location.reload();
        })
    });
}
