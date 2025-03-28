package net.arczinosek.blog.application.handler;

import net.arczinosek.blog.domain.entity.Post;
import net.arczinosek.blog.domain.repository.PostRepository;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CreatePostHandlerTests {
    @Test
    public void createsAndSavesNewPostEntityWithPublishDateAsCurrentTime() {
        var postsRepository = new PostRepository() {
            private final List<Post> posts = new LinkedList<>();

            @Override
            public Post save(Post post) {
                var newPost = post.withId(1L);
                posts.add(newPost);

                return newPost;
            }

            @Override
            public List<Post> findAll() {
                return posts;
            }
        };

        var command = new CreatePostCommand(
            "Posts title",
            "Posts content"
        );

        var handler = new CreatePostHandler(postsRepository);

        var post = handler.handle(command);

        assertInstanceOf(Post.class, post);
        assertSame(command.title(), post.getTitle());
        assertSame(command.content(), post.getContent());
        assertNotNull(post.getPublishedAt());
        assertSame(1L, post.getId());
        assertEquals(1, postsRepository.findAll().size());
    }
}
