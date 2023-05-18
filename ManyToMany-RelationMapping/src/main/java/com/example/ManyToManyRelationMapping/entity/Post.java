package com.example.ManyToManyRelationMapping.entity;


import jakarta.persistence.*;
import lombok.Data;

import javax.xml.stream.events.Comment;
import java.util.HashSet;
import java.util.Set;
@Data
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "post_comment",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "comment_id")
    )
    private Set<Comment> comments = new HashSet<>();
}
