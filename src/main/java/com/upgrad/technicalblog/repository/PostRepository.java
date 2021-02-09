package com.upgrad.technicalblog.repository;

import com.upgrad.technicalblog.model.Post;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Repository
public class PostRepository {

    @PersistenceUnit(unitName = "TechBlog")
    private EntityManagerFactory emf;

    public List<Post> getAllPosts() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Post> query = em.createQuery("SELECT p from Post p", Post.class);
        List<Post> resultList = query.getResultList();

        return resultList;
    }

    public Post getLatestPost() {
        EntityManager em = emf.createEntityManager();
        return em.find(Post.class, 3);
    }

    public Post createPost(Post newPost) {
        newPost.setDate(new Date());
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(newPost);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return newPost;
    }

    public Post getPost(Integer postid) {
        EntityManager em = emf.createEntityManager();
        return em.find(Post.class, postid);
    }

    public void updatePost(Post post){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.merge(post);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    public void deletePost(Integer postid){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Post post = em.find(Post.class, postid);
            em.remove(post);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }
}
