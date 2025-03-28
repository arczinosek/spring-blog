package net.arczinosek.blog.domain.repository;

import net.arczinosek.blog.domain.entity.Post;

import java.util.List;

public interface PostRepository {
    Post save(Post post);

    List<Post> findAll();
}
