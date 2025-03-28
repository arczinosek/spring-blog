package net.arczinosek.blog.infrastructure.repository;

import net.arczinosek.blog.domain.entity.Post;
import net.arczinosek.blog.domain.repository.PostRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.*;

@Component
public class InMemoryPostRepository implements PostRepository {
    private Long autoIncrement = 1L;

    private final List<Post> posts;

    public InMemoryPostRepository() {
        posts = new Vector<>();
        var post = Post.create(
            "Hello, world!",
            "My first blog post!",
            LocalDateTime.of(2025, 3, 22, 17, 6, 10)
        );

        posts.add(post.withId(autoIncrement++));
    }

    public Post save(Post post) {
        var newPost = post.withId(autoIncrement++);

        posts.add(newPost);

        return newPost;
    }

    @Override
    public List<Post> findAll() {
        return posts;
    }
}
