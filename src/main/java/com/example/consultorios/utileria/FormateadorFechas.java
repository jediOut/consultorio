package com.example.consultorios.utileria;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class FormateadorFechas {

    public static Date convertLocalDateToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}
