package net.arczinosek.blog.presentation.controller;

import net.arczinosek.blog.application.handler.FetchNewestPostsHandler;
import net.arczinosek.blog.application.handler.FetchNewestPostsQuery;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final FetchNewestPostsHandler fetchNewestPostsHandler;

    public HomeController(FetchNewestPostsHandler handler) {
        fetchNewestPostsHandler = handler;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute(
            "posts",
            fetchNewestPostsHandler.handle(new FetchNewestPostsQuery())
        );

        return "index";
    }
}
