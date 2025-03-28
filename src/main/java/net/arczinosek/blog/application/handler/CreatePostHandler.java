package net.arczinosek.blog.application.handler;

import net.arczinosek.blog.domain.entity.Post;
import net.arczinosek.blog.domain.repository.PostRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CreatePostHandler {
    private final PostRepository repository;

    public CreatePostHandler(PostRepository repository) {
        this.repository = repository;
    }

    public Post handle(CreatePostCommand createPost) {
        var post = Post.create(
            createPost.title(),
            createPost.content(),
            LocalDateTime.now()
        );

        return repository.save(post);
    }
}
