package com.dcankayrak.OnlineClub.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CourseSaveRequest {
    @NotNull
    private Long teacherId;
    @NotBlank
    private String title;
    @NotBlank
    private String description;
}
