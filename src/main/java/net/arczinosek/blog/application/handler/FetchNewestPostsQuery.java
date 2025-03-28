package net.arczinosek.blog.application.handler;

public record FetchNewestPostsQuery(
    int limit,
    int page
) {
    public FetchNewestPostsQuery {
        if (limit < 1) {
            throw new IllegalArgumentException("'limit' can't be less than 1!");
        }

        if (page < 1) {
            throw new IllegalArgumentException("'page' can't be less than 1!");
        }
    }

    public FetchNewestPostsQuery(int limit) {
        this(limit, 1);
    }

    public FetchNewestPostsQuery() {
        this(3);
    }
}
