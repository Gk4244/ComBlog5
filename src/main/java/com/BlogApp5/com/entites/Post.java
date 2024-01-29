package com.BlogApp5.com.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="title", unique = true)
    private String title;
    @Column(name="description", nullable = false)
    private String decription;
    @Column(name="content", nullable = false)
    private String content;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "post_comment",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "comment_id"))
    private Set<Comment> comments = new HashSet<>();
}
