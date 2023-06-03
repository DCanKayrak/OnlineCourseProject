package com.dcankayrak.OnlineClub.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CourseUpdateRequest {
    private String description;
    private String title;
}
