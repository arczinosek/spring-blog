package net.arczinosek.blog.application.handler;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreatePostCommand(
    @NotBlank(message = "Field 'title' must not be blank")
    @Size(min = 3, max = 512, message = "Field 'title' should be between 3 and 512 characters long")
    String title,

    @NotBlank(message = "Field 'title' must not be blank")
    String content
) {
}
