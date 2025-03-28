package net.arczinosek.blog.domain.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private LocalDateTime publishedAt;

    public static Post create(String title, String content, LocalDateTime publishedAt) {
        var post = new Post();

        post.title = title;
        post.content = content;
        post.publishedAt = publishedAt;

        return post;
    }

    public Post withId(Long id) {
        var post = new Post();
        post.id = id;
        post.title = title;
        post.content = content;
        post.publishedAt = publishedAt;

        return post;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getPublishedAt() {
        return publishedAt;
    }
}
