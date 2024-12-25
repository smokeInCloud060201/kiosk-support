package com.example.kiosksupport.service;

import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;

import static java.time.temporal.ChronoUnit.DAYS;


@Service
public class HolidayDateOffPlan {

    public int getTimeOff(LocalDate holidayDate) {
        if (holidayDate == null || DayOfWeek.SUNDAY.equals(holidayDate.getDayOfWeek())) {
            return 0;
        }
        LocalDate today = LocalDate.now(ZoneId.of("Asia/Singapore"));
        DayOfWeek todayInWeek = today.getDayOfWeek();
        LocalTime localTime = LocalTime.now();
        int range = 0;
        DayOfWeek holidayDayInWeek = holidayDate.getDayOfWeek();
        long daysRange = DAYS.between(today, holidayDate);
        switch (holidayDayInWeek) {
            case MONDAY: {
                if (!(daysRange < 4 && daysRange >= 0)) {
                    return range;
                }
                switch (todayInWeek) {
                    case FRIDAY -> {
                        if (localTime.getHour() >= 15) {
                            range = 3;
                        }
                    }
                    case SATURDAY -> {
                        if (localTime.getHour() >= 15) {
                            range = 3;
                        } else {
                            range = 2;
                        }
                    }
                    case SUNDAY -> range = 2;
                    case MONDAY -> range = 1;
                    default -> {}
                }
            }
            case TUESDAY: {
                if (!(daysRange < 4 && daysRange >= 0)) {
                    return range;
                }
                switch (todayInWeek) {
                    case SATURDAY -> {
                        if (localTime.getHour() >= 15) {
                            range = 3;
                        }
                    }
                    case SUNDAY -> range = 2;
                    case MONDAY -> {
                        if (localTime.getHour() >= 15) {
                            range = 2;
                        } else {
                            range = 1;
                        }
                    }
                    case TUESDAY -> range = 1;
                    default -> {}
                }
            }
            case WEDNESDAY: {
                if (!(daysRange < 3 && daysRange >= 0)) {
                    return range;
                }
                switch (todayInWeek) {
                    case MONDAY -> {
                        if (localTime.getHour() >= 15) {
                            range = 2;
                        }
                    }
                    case THURSDAY -> {
                        if (localTime.getHour() >= 15) {
                            range = 2;
                        } else {
                            range = 1;
                        }
                    }
                    case WEDNESDAY -> range = 1;
                    default -> {}
                }
            }
            case THURSDAY: {
                if (!(daysRange < 3 && daysRange >= 0)) {
                    return range;
                }
                switch (todayInWeek) {
                    case TUESDAY -> {
                        if (localTime.getHour() >= 15) {
                            range = 2;
                        }
                    }
                    case WEDNESDAY -> {
                        if (localTime.getHour() >= 15) {
                            range = 2;
                        } else {
                            range = 1;
                        }
                    }
                    case THURSDAY -> range = 1;
                    default -> {}
                }
            }
            case FRIDAY: {
                if (!(daysRange < 3 && daysRange >= 0)) {
                    return range;
                }
                switch (todayInWeek) {
                    case WEDNESDAY -> {
                        if (localTime.getHour() >= 15) {
                            range = 2;
                        }
                    }
                    case THURSDAY -> {
                        if (localTime.getHour() >= 15) {
                            range = 2;
                        } else {
                            range = 1;
                        }
                    }
                    case FRIDAY -> range = 2;
                    default -> {}
                }
            }
            case SATURDAY: {
                if (!(daysRange < 3 && daysRange >= 0)) {
                    return range;
                }
                switch (todayInWeek) {
                    case THURSDAY -> {
                        if (localTime.getHour() >= 15) {
                            range = 3;
                        }
                    }
                    case FRIDAY -> {
                        if (localTime.getHour() >= 15) {
                            range = 3;
                        } else {
                            range = 2;
                        }
                    }
                    case SATURDAY -> range = 2;
                    default -> {}
                }
            }
            default: {}
        }
        return range;
    }
}
