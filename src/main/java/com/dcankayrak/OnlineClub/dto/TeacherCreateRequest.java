package com.dcankayrak.OnlineClub.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class TeacherCreateRequest {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
}
