package com.medilabo.diagnosis_view.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteView {
    private Long customId;
    private String noteField;

}
