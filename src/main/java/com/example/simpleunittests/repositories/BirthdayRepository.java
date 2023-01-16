package com.example.simpleunittests.repositories;

import java.time.LocalDate;

public interface BirthdayRepository {
    LocalDate getValidBirthday(String birthday);
    String getBirthDOW(LocalDate birthday);
    String getChineseZodiac(LocalDate birthday);
    String getStarSign(LocalDate birthday);
}
