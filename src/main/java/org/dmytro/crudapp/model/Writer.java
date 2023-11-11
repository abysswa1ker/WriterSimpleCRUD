package org.dmytro.crudapp.model;

import lombok.*;
import org.dmytro.crudapp.enams.WriterStatus;

import java.util.List;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Writer {
    private Integer id;
    private String firstName;
    private String lastName;
    private List<Post> postList;
    private WriterStatus writerStatus;

    public Writer( String firstName, String lastName, List<Post> postList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.postList = postList;
    }

    public Writer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
