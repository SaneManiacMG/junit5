package com.example.simpleunittests.repositories;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface BirthdayRepository {
    LocalDate getValidBirthday(String birthday);
    String getBirthDOW(LocalDate birthday);
    String getChineseZodiac(LocalDate birthday);
    String getStarSign(LocalDate birthday);
}
