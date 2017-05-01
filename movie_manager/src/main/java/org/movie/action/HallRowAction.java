package org.movie.action;

import org.movie.entity.HallRow;
import org.movie.entity.MovieHall;
import org.movie.exception.NotFoundException;
import org.movie.service.HallRowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by Administrator on 2017/04/19.
 */
@Controller("hallRowAction")
@Scope("prototype")
public class HallRowAction {

    private List<HallRow> rowList;
    private HallRow hallRow;
    private MovieHall movieHall;
    private String message;
    @Autowired
    private HallRowService service;

    public List<HallRow> getRowList() {
        return rowList;
    }

    public void setRowList(List<HallRow> rowList) {
        this.rowList = rowList;
    }

    public HallRow getHallRow() {
        return hallRow;
    }

    public void setHallRow(HallRow hallRow) {
        this.hallRow = hallRow;
    }

    public MovieHall getMovieHall() {
        return movieHall;
    }

    public void setMovieHall(MovieHall movieHall) {
        this.movieHall = movieHall;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String findRowByHallId() throws Exception {
        rowList = service.findRowByHallId(movieHall.getMovieHallId());
        if(rowList.size() != 0){
            return "findRowByHallId";
        }
        System.out.println(rowList);
        throw new NotFoundException("该影厅没有座位!");
    }

    public String findRowById() throws Exception {
        hallRow = service.findRowById(hallRow.getHallRowId());
        return "findRowById";
    }

    public String addRow() throws Exception {
        hallRow.setMovieHall(movieHall);
        message = service.save(hallRow);
        return "addRow";
    }
    public String updateRow() throws Exception {
        hallRow.setMovieHall(movieHall);
        message = service.update(hallRow);
        return "updateRow";
    }

    public String removeRow() throws Exception {
        message = service.remove(hallRow);
        return "removeRow";
    }
}
