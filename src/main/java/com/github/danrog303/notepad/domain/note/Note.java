package com.github.danrog303.notepad.domain.note;

import com.github.danrog303.notepad.domain.importance.Importance;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity @Table
@NoArgsConstructor @AllArgsConstructor
public class Note {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Importance importance;

    @Column
    private Date timestamp;

    @Column
    @NotBlank
    private String text;
}