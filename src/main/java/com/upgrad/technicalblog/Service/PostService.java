package com.upgrad.technicalblog.Service;

import com.upgrad.technicalblog.model.Post;
import com.upgrad.technicalblog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    @PersistenceUnit(unitName = "TechBlog")
    private EntityManagerFactory emf;

    public List<Post> getAllPosts() {
        return postRepository.getAllPosts();
    }

    public Post getLatestPost() {
        return postRepository.getLatestPost();
    }

    public void createPost(Post newPost) {
        postRepository.createPost(newPost);
        System.out.println(newPost);
    }

    public Post getPost(Integer postid){
        return postRepository.getPost(postid);
    }

    public void updatePost(Post post){
        post.setDate(new Date());
        postRepository.updatePost(post);
    }

    public void deletePost(Integer postid){
        postRepository.deletePost(postid);
    }
}
