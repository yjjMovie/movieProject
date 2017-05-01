$(function(){

    $.get("city_findCity", function(result){
        $("#selectCity").empty();
        $.each(result, function(index, obj){
            $("#selectCity").append("<option value='"+obj.cityId+"'>"+obj.cityName+"</option>")
        });
        var cid = $("#selectCity").val();
        getAreaByCityId(cid);
    });

    $("#selectCity").change(function(){
        var cid = $(this).val();
        getAreaByCityId(cid);
    });

    add();
});


function getAreaByCityId(cid){

    $.post("areas_findAreaByCityId", {"city.cityId":cid}, function(result){
        if(result.message != undefined){
            $("#tab tr:not(:first)").empty();
            alert(result.message);
        }else{
            addTable(result);
            buttonClick();
        }
    });
}
function addTable(result){
    $("#tab tr:not(:first)").empty();

    $.each(result, function(index, obj){

        $("table").append("<tr>" +
            "<td>"+(++index)+"</td>"+
            "<td>"+obj.areaName+"</td>"+
            "<td><input  alt='"+obj.areaId+"' type='button' class='btn btn-danger btn-sm' value='编辑'></td>");
    });
}

//给添加按钮绑定click事件
function add(){
    $("#addArea").on("click", function(){
        $("#f1 :input").val("");
        $.get("city_findCity", function(result){
            $.each(result, function(index, obj){
                $("#city").append("<option value='"+obj.cityId+"'>"+obj.cityName+"</option>");
            });
        });
        //显示模式对话框
        $("#addAreaView").modal("show");
    });
    save();
}

//给保存按钮添加事件
function save(){
    $("#save").on("click",function(){
        //序列化表单
        var params = $("#f1").serialize();
        $.post("areas_addArea", params, function(result){
            alert(result);
            location.href = "area.html";
        });
    });
}


//给编辑按钮绑定事件
function buttonClick(){
    $("#tab :button").on("click", function(){
        $("#updateAreaView").modal("show");
        var id = $(this).prop("alt");
        $.get("areas_findAreaById",{"area.areaId":id}, function(result){
            $("#areaId").val(result.areaId);
            $("#areaName").val(result.areaName);


            var cityName = result.city.cityName;

            $.get("city_findCity", function(result){
                $("#cityName").empty();
                $.each(result, function(key, obj){
                    if(obj.cityName == cityName){
                        $("#cityName").append("<option value="+obj.cityId+" selected='selected'>"+obj.cityName+"</option>");
                    }else{
                        $("#cityName").append("<option value="+obj.cityId+">"+obj.cityName+"</option>");
                    }

                });
            });
        });

        updateArea();
        deleteArea();
    });
}


//给编辑事件的保存按钮添加事件
function updateArea(){
    $("#update").off("click").on("click",function(){
        //序列化表单
        var params=$("#f2").serialize();
        //提交到后台更新
        $.post("areas_updateArea", params ,function(result){
            //更新列表数据
            alert(result);
            location.href = "area.html";
        });
    });
}

function deleteArea(){
    $("#delete").on("click", function(){
        var params = $("#f2").serialize();
        $.post("areas_removeArea", params, function(result){
            alert(result);
            location.href = "area.html";
        });
    });
}