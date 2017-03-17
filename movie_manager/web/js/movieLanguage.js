$(function(){
    $.get("languagefindLanguage", function(result){
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
            "<td>"+obj.movieLanguageName+"</td>"+
            "<td><input  alt='"+obj.movieLanguageId+"' type='button' class='btn btn-danger btn-sm' value='编辑'></td>");
    });
}

//给添加按钮绑定click事件
function add(){
    $("#addLanguage").on("click", function(){
        //显示模式对话框
        $("#addLanguageView").modal("show");
    });
    save();
}

//给保存按钮添加事件
function save(){
    $("#save").on("click",function(){
        //序列化表单
        var params = $("#f1").serialize();
        $.post("languageaddLanguage", params, function(result){
            alert(result);
            location.href = "movieLanguage.html";
        });
    });
}


//给编辑按钮绑定事件
function buttonClick(){
    $("#tab :button").on("click", function(){
        $("#updateLanguageView").modal("show");
        var id = $(this).prop("alt");
        $.get("languagefindLanguageById",{"language.movieLanguageId":id}, function(result){
            $("#movieLanguageId").val(result.movieLanguageId);
            $("#movieLanguageName").val(result.movieLanguageName);
        });

        updateLanguage();
        deleteLanguage();
    });
}


//给编辑事件的保存按钮添加事件
function updateLanguage(){
    $("#update").off("click").on("click",function(){
        //序列化表单
        var params=$("#f2").serialize();
        //提交到后台更新
        $.post("languageupdateLanguage", params ,function(result){
            //更新列表数据
            alert(result);
            location.href = "movieLanguage.html";
        });
    });
}

function deleteLanguage(){
    $("#delete").on("click", function(){
        var params = $("#f2").serialize();
        $.post("languageremoveLanguage", params, function(result){
            alert(result);
            location.href = "movieLanguage.html";
        });
    });
}