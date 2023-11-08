package org.dmytro.crudapp.model;

import lombok.*;
import org.dmytro.crudapp.enams.PostStatus;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Label {
    private int id;
    private String name;
    private PostStatus status;

    public Label(String name) {
        this.status = PostStatus.ACTIVE;
        this.name = name;
    }

    public Label(int id, String name) {
        this.status = PostStatus.ACTIVE;
        this.id = id;
        this.name = name;
    }
}
