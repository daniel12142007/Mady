package com.example.mady.dto.response;

import com.example.mady.model.enums.FormatModel;

import java.time.LocalDateTime;
public record MadyModelResponse(Long id,
                                String image,
                                String title,
                                String description,
                                LocalDateTime dateCreated,
                                FormatModel format) {
}