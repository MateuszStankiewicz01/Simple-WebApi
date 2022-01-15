package com.WebApi.webapi.exceptionsHandlers;

import java.util.Date;

public class ServiceException extends Exception{
    private static final long serialVersionUID = 1L;
    private Date time;
    private String msg;
    private String details;
    public ServiceException(String name){
        super(name);
    }
}
