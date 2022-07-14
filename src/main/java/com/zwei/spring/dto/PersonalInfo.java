package com.zwei.spring.dto;

import java.time.LocalDate;

public record PersonalInfo(String firstname, String lastname, LocalDate birthDate) {
}
