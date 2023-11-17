package org.dmytro.crudapp.model;

import lombok.*;
import org.dmytro.crudapp.enams.PostStatus;

import java.util.Date;
import java.util.List;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private Integer id;
    private String content;
    private Date created;
    private Date updated;
    private List<Label> labels;
    private PostStatus postStatus;

    public Post(Integer id, String content, List<Label> labels) {
        this.created = new Date();
        this.id = id;
        this.content = content;
        this.labels = labels;
    }

    public Post(String content, PostStatus postStatus) {
        this.content = content;
        this.postStatus = postStatus;
    }
}
