package com.WebApi.webapi.exceptionsHandlers;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class ExceptionDetails {
    private Date time;
    private String msg;
    private String details;
}
