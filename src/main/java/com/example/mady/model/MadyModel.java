package com.example.mady.model;

import com.example.mady.model.enums.FormatModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MadyModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String image;
    private String title;
    @Column(length = 3000)
    private String description;
    private LocalDateTime dateCreated;
    @Enumerated(EnumType.STRING)
    private FormatModel formatModel;
}