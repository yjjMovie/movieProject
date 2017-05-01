$(function(){
    buttonClick();
});

//给编辑按钮绑定事件
function buttonClick(){
    $("#tab :button").on("click", function(){
        $("#updateCinemaView").modal("show");
        var id = $(this).prop("alt");
        $.get("cinema_findCinemaById",{"cinema.cinemaId":id}, function(result){
            $("#cinemaId").val(result.cinemaId);
            $("#cinemaName").val(result.cinemaName);
            $("#cinemaAddr").val(result.cinemaAddr);
            $("#cinemaTel").val(result.cinemaTel);

            var areaName = result.area.areaName;

            $.get("areas_findArea", function(result){
                $("#areaName").empty();
                $.each(result, function(key, obj){
                    if(obj.areaName == areaName){
                        $("#areaName").append("<option value="+obj.areaId+" selected='selected'>"+obj.areaName+"</option>");
                    }else{
                        $("#areaName").append("<option value="+obj.areaId+">"+obj.areaName+"</option>");
                    }
                });
            });
        });

        update();
    });
}


//给编辑事件的保存按钮添加事件
function update(){
    $("#update").off("click").on("click",function(){
        //序列化表单
        var params=$("#f2").serialize();
        //提交到后台更新
        $.post("cinema_updateCinema", params ,function(result){
            //更新列表数据
            alert(result);
            location.href = "cinema.jsp";
        });
    });
}
