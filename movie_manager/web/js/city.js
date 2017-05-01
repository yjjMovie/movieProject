$(function(){
    $.get("city_findCity", function(result){
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
            "<td>"+obj.cityName+"</td>"+
            "<td><input  alt='"+obj.cityId+"' type='button' class='btn btn-danger btn-sm' value='编辑'></td>");
    });
}

//给添加按钮绑定click事件
function add(){
    $("#addCity").on("click", function(){
        $("#f1 :input").val("");
        //显示模式对话框
        $("#addCityView").modal("show");
    });
    save();
}

//给保存按钮添加事件
function save(){
    $("#save").on("click",function(){
        //序列化表单
        var params = $("#f1").serialize();
        $.post("city_addCity", params, function(result){
            alert(result);
            location.href = "city.html";
        });
    });
}


//给编辑按钮绑定事件
function buttonClick(){
    $("#tab :button").on("click", function(){
        $("#updateCityView").modal("show");
        var id = $(this).prop("alt");
        $.get("city_findCityById",{"city.cityId":id}, function(result){
            $("#cityId").val(result.cityId);
            $("#cityName").val(result.cityName);
        });

        updateCity();
        deleteCity();
    });
}


//给编辑事件的保存按钮添加事件
function updateCity(){
    $("#update").off("click").on("click",function(){
        //序列化表单
        var params=$("#f2").serialize();
        //提交到后台更新
        $.post("city_updateCity", params ,function(result){
            //更新列表数据
            alert(result);
            location.href = "city.html";
        });
    });
}

function deleteCity(){
    $("#delete").on("click", function(){
        var params = $("#f2").serialize();
        $.post("city_removeCity", params, function(result){
            alert(result);
            location.href = "city.html";
        });
    });
}