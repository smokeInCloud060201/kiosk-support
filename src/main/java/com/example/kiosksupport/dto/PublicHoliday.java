package com.example.kiosksupport.dto;

import java.time.LocalDate;

public class PublicHoliday {

    public PublicHoliday(String holiday, LocalDate date) {
        this.holiday = holiday;
        this.date = date;
    }

    public String getHoliday() {
        return holiday;
    }

    public LocalDate getDate() {
        return date;
    }

    private String holiday;
    private LocalDate date;
}
