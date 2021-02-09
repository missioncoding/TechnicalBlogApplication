package com.upgrad.technicalblog.controller;

import com.upgrad.technicalblog.Service.PostService;
import com.upgrad.technicalblog.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class HomeController {


    @Autowired
    PostService postService;

    @RequestMapping("/")
    public String getLatestPost(Model model) {
        List<Post> posts = postService.getAllPosts();
        model.addAttribute("posts",posts);
        return "index";
    }
}
