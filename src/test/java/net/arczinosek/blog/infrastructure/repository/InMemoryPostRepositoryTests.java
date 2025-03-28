package net.arczinosek.blog.infrastructure.repository;

import static org.junit.jupiter.api.Assertions.*;

import net.arczinosek.blog.domain.entity.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class InMemoryPostRepositoryTests {
    private InMemoryPostRepository repository;

    @BeforeEach
    void setUp() {
        repository = new InMemoryPostRepository();
    }
    @Test
    public void newRepositoryHasHelloWorldPost() {
        assertEquals(1, repository.findAll().size());
        assertEquals(1L, repository.findAll().getFirst().getId());
    }

    @Test
    public void saveReturnsNewEntityWithNewId() {
        var post = Post.create("test post", "their contents", LocalDateTime.now());

        var result = repository.save(post);

        assertNull(post.getId());
        assertEquals(2L, result.getId());
        assertEquals(post.getTitle(), result.getTitle());
        assertEquals(post.getContent(), result.getContent());
        assertEquals(post.getPublishedAt(), result.getPublishedAt());
    }
}
