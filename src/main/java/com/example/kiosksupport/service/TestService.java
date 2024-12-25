package com.example.kiosksupport.service;

import com.example.kiosksupport.dto.PublicHoliday;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

@Service

public class TestService implements CommandLineRunner {

    @Autowired
    private final HolidayDateOffPlan holidayDateOffPlan;

    public TestService(HolidayDateOffPlan holidayDateOffPlan) {
        this.holidayDateOffPlan = holidayDateOffPlan;
    }


    public List<LocalDate> getHoliday() {
        List<PublicHoliday> publicHolidays = generateHoliday();
        List<LocalDate> results = new ArrayList<>();
        handleHolidays(results, publicHolidays);
        return results;
    }

    private void handleHolidays(List<LocalDate> results, List<PublicHoliday> publicHolidays) {
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(31);

        publicHolidays.forEach(publicHoliday -> {
            LocalDate holidayDate = publicHoliday.getDate();
            long dayOff = holidayDateOffPlan.getTimeOff(holidayDate);
            System.out.println(dayOff);
        });

    }

    public List<PublicHoliday> generateHoliday() {
        return List.of(
                new PublicHoliday("", LocalDate.parse("2024-12-23"))
        );
    }

    @Override
    public void run(String... args) throws Exception {
        getHoliday();
    }
}
