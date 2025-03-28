package net.arczinosek.blog.application.handler;

import net.arczinosek.blog.domain.entity.Post;
import net.arczinosek.blog.domain.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FetchNewestPostsHandler {
    private final PostRepository repository;

    public FetchNewestPostsHandler(PostRepository repository) {
        this.repository = repository;
    }

    public List<Post> handle(FetchNewestPostsQuery query) {
        return repository.findAll();
    }
}
