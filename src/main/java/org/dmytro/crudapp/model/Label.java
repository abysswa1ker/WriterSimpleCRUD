package org.dmytro.crudapp.model;

import lombok.*;
import org.dmytro.crudapp.enams.LabelStatus;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Label {
    private Integer id;
    private String name;
    private LabelStatus status;

    public Label(String name) {
        this.name = name;
    }
}
