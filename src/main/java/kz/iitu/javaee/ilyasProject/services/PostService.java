package kz.iitu.javaee.ilyasProject.services;

import kz.iitu.javaee.ilyasProject.entities.Posts;

import java.util.List;

public interface PostService {

    Posts addPost(Posts post);
    List<Posts> getAllPosts();
    Posts getPostById(Long id);

}
