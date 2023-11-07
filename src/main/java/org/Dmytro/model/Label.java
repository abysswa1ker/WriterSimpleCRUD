package org.Dmytro.model;

import org.Dmytro.enams.PostStatus;

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

    public Label() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Label{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
