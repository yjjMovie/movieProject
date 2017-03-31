$(function(){
    $.get("item_findItem", function(result){
        addTable(result);
    });

    $("#findItem").on("click", function(){
        $.get("item_findItem", function(result){
            $("#tab tr:not(:first)").empty();
            if(result.message != undefined){
                alert(result.message);
            }else{
                addTable(result);
            }
        });
    });

    $("#findItemByCondition").on("click", function(){
        var params = $("#f1").serialize();
        $("#f1 :text").val("");
        $.post("item_findItemByCondition", params, function(result){
            $("#tab tr:not(:first)").empty();
            if(result.message != undefined){
                alert(result.message);
            }else{
                addTable(result);
            }
        });
    });
});
function addTable(result){
    $("#tab tr:not(:first)").empty();

    $.each(result, function(index, obj){

        $("table").append("<tr>" +
            "<td>"+(++index)+"</td>"+
            "<td>"+obj.user.userName+"</td>"+
            "<td>"+obj.movieSession.movie.movieName+"</td>"+
            "<td>"+obj.movieSession.cinema.cinemaName+"</td>"+
            "<td>"+obj.movieSession.cinema.cinemaTel+"</td>"+
            "<td>"+obj.movieSession.movieHall.movieHallName+"</td>"+
            "<td>"+obj.movieSession.startTime+"</td>"+
            "<td>"+obj.itemNum+"</td>"+
            "<td>"+obj.subtotal+"</td>");
    });
}