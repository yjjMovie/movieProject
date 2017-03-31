package org.movie.exception;

/**
 * Created by Administrator on 2017/03/29.
 */
public class NotFoundException extends RuntimeException {

    private String message;

    public NotFoundException(String message){
        super(message);
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
