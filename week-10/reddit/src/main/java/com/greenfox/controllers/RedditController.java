package com.greenfox.controllers;

import com.greenfox.domain.Post;
import com.greenfox.domain.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Lenovo on 2017. 01. 04..
 */
@Controller
@RequestMapping("/")
public class RedditController {

    private PostService postService;

    @Autowired
    public RedditController(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping
    public String emptyUrlRedirect() {
        return "redirect:/posts/1";
    }

    @RequestMapping(value = "/posts/{pageNumber}")
    public String showPosts(Model model,
                            @PathVariable Integer pageNumber) {
        Page<Post> page = postService.obtainPage(pageNumber - 1, 10);
        model.addAttribute("posts", page);

        int current = page.getNumber() + 1;
        int begin = Math.max(1, current - 10);
        int end = Math.min(begin + 10, page.getTotalPages());

        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);


        return "posts";
    }

    @RequestMapping(value = "/posts/add")
    public String addPost(Model model) {
        model.addAttribute("post", new Post());
        return "add";
    }

    @RequestMapping(value = "/posts/add", method = RequestMethod.POST)
    public String addPost(@ModelAttribute Post post) {
        postService.addPost(post);
        return "redirect:/";
    }

    @RequestMapping(value = "/posts/changescore/{id}/{difference}/{goBackTo}")
    public String changeScore(@PathVariable Long id,
                              @PathVariable Integer difference,
                              @PathVariable Integer goBackTo) {
        postService.changePostScore(id, difference);
        return "redirect:/posts/" + String.valueOf(goBackTo);
    }
}
