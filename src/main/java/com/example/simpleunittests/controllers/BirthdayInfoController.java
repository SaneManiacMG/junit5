package com.example.simpleunittests.controllers;

import com.example.simpleunittests.repositories.BirthdayRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/birthday")
public class BirthdayInfoController {
    private BirthdayRepository birthdayRepository;

    public BirthdayInfoController(BirthdayRepository birthdayRepository) {
        this.birthdayRepository = birthdayRepository;
    }

    @PostMapping("/dayOfWeek")
    public String getDayOfWeek(@RequestBody String birthdayString) {
        LocalDate birthday = birthdayRepository.getValidBirthday(birthdayString);
        String dow = birthdayRepository.getBirthDOW(birthday);
        return dow;
    }

    @PostMapping("/chineseZodiac")
    public String getChineseZodiac(@RequestBody String birthdayString) {
        LocalDate birthday = birthdayRepository.getValidBirthday(birthdayString);
        String sign = birthdayRepository.getChineseZodiac(birthday);
        return sign;
    }

    @PostMapping("/starSign")
    public String starSign(@RequestBody String birthdayString) {
        LocalDate birthday = birthdayRepository.getValidBirthday(birthdayString);
        String sign = birthdayRepository.getStarSign(birthday);
        return sign;
    }

    @ExceptionHandler(RuntimeException.class)
    public final ResponseEntity<Exception> handleAllExceptions(RuntimeException ex) {
        return new ResponseEntity<Exception>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
