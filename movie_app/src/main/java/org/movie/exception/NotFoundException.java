package org.movie.exception;

/**
 * Created by Administrator on 2017/04/10.
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
