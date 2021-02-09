package com.upgrad.technicalblog.controller;

import com.upgrad.technicalblog.Service.PostService;
import com.upgrad.technicalblog.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PostController {

    @Autowired
    PostService postService;

    @RequestMapping("/posts")
    public String getPosts(Model model) {
        List<Post> posts = postService.getAllPosts();
        model.addAttribute("posts",posts);
        return "posts";
    }

    @RequestMapping("/newpost")
    public String newPosts() {
        return "createpost";
    }

    @RequestMapping(value = "/posts/create", method = RequestMethod.POST)
    public String createPost(Post newPost) {
        postService.createPost(newPost);
        return "redirect:/posts";
    }

    @RequestMapping(value="/editPost" , method = RequestMethod.GET)
    public String editPost(@RequestParam(name="postId") Integer postId, Model model) {
        Post post = postService.getPost(postId);
        model.addAttribute("post",post);
        return "/edit";
    }

    @RequestMapping(value="/editPost" , method = RequestMethod.PUT)
    public String editPostSubmit(@RequestParam(name="postId") Integer postId, Post post) {
        post.setId(postId);
        postService.updatePost(post);
        return "redirect:/posts";
    }

    @RequestMapping(value="/deletePost" , method = RequestMethod.DELETE)
    public String deletePostSubmit(@RequestParam(name="postId") Integer postId) {
        postService.deletePost(postId);
        return "redirect:/posts";
    }
}
