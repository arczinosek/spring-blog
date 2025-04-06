package net.arczinosek.blog.application.handler;

import net.arczinosek.blog.domain.entity.Post;
import net.arczinosek.blog.domain.repository.PostRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.time.LocalDateTime;

public class CreatePostHandlerTests {
    @Mock
    private PostRepository postRepository;

    private CreatePostHandler handler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        handler = new CreatePostHandler(postRepository);
    }

    @Test
    public void createsAndSavesNewPostEntityWithPublishDateAsCurrentTime() {
        // Arrange
        var command = new CreatePostCommand(
            "Posts title",
            "Posts content"
        );

        Mockito.when(
            postRepository.save(Mockito.any(Post.class))
        ).thenAnswer(invocation -> invocation.getArgument(0));

        // Act
        var post = handler.handle(command);

        // Assert
        Assertions.assertEquals(command.title(), post.getTitle());
        Assertions.assertEquals(command.content(), post.getContent());
        Assertions.assertTrue(post.getPublishedAt().isBefore(LocalDateTime.now()));

        Mockito.verify(postRepository).save(Mockito.any(Post.class));
    }
}
