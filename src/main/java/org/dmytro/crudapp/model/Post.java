package org.dmytro.crudapp.model;

import java.util.Date;
import java.util.List;

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
    public Post(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                ", labels=" + labels +
                '}';
    }
}
