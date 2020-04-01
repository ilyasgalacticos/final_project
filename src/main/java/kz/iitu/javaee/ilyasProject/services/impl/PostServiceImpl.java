package kz.iitu.javaee.ilyasProject.services.impl;

import kz.iitu.javaee.ilyasProject.entities.Posts;
import kz.iitu.javaee.ilyasProject.repositories.PostRepository;
import kz.iitu.javaee.ilyasProject.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Posts addPost(Posts post) {
        return postRepository.save(post);
    }

    @Override
    public List<Posts> getAllPosts() {
        return postRepository.findAllByDeletedAtNullOrderByCreatedAtDesc();
    }

    @Override
    public Posts getPostById(Long id) {
        return postRepository.findByDeletedAtNullAndId(id);
    }
}
