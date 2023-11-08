package org.dmytro.crudapp.model;

import lombok.*;

import java.util.Date;
import java.util.List;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private int id;
    private String content;
    private Date created;
    private Date updated;
    private List<Label> labels;

    public Post(int id, String content, List<Label> labels) {
        this.created = new Date();
        this.id = id;
        this.content = content;
        this.labels = labels;
    }
}
