package net.arczinosek.blog.domain.repository;

import net.arczinosek.blog.domain.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
