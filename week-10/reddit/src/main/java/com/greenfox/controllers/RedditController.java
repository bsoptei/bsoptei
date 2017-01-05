package com.greenfox.controllers;

import com.greenfox.domain.Post;
import com.greenfox.service.PostService;
import com.greenfox.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/")
public class RedditController {

    private PostService postService;
    private UserService userService;

    @Autowired
    public RedditController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @RequestMapping
    public String emptyUrlRedirect() {
        return "redirect:/posts/1";
    }

    @RequestMapping(value = "/index")
    public String index() {
        return "redirect:/";
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

    @RequestMapping(value = "/posts/add", method = RequestMethod.POST)
    public String addPost(@ModelAttribute Post post) {
        postService.addPost(post);
        return "redirect:/";
    }

    @RequestMapping(value = "/posts/add")
    public String addPost(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("userName", auth.getName());
        model.addAttribute("post", new Post());
        return "add";
    }

    @RequestMapping(value = "/posts/changescore/{id}/{difference}/{goBackTo}")
    public String changeScore(@PathVariable Long id,
                              @PathVariable Integer difference,
                              @PathVariable Integer goBackTo) {
        postService.changePostScore(id, difference);
        return "redirect:/posts/" + String.valueOf(goBackTo);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        return "redirect:/";
    }

    @RequestMapping(value = "/login")
    public String showLogin() {
        return "login";
    }
}
