package net.arczinosek.blog.presentation.controller;

import jakarta.validation.Valid;
import net.arczinosek.blog.application.handler.CreatePostCommand;
import net.arczinosek.blog.application.handler.CreatePostHandler;
import net.arczinosek.blog.domain.entity.Post;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
public class AdminController {
    private final CreatePostHandler createPostHandler;

    public AdminController(CreatePostHandler createPostHandler) {
        this.createPostHandler = createPostHandler;
    }

    @PostMapping
    public ResponseEntity<Post> createPost(
        @Valid
        @RequestBody
        CreatePostCommand request
    ) {
        var post = createPostHandler.handle(request);

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(post)
        ;
    }
}
