package com.greenfox.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Lenovo on 2017. 01. 04..
 */
@Service
public class PostService {

    private PostRepository postRepo;

    @Autowired
    public PostService(PostRepository postRepo) {
        this.postRepo = postRepo;
    }


    public Page<Post> obtainPage() {
        postRepo.findAll(new PageRequest(1,1));
        return postRepo.findByOrderByScoreDesc(new PageRequest(0, 10));
    }

    public void addPost(Post post) {
        postRepo.save(post);
    }

    public void changePostScore(Long id, Integer difference) {
        Post currentPost = postRepo.findOne(id);
        currentPost.setScore(currentPost.getScore() + difference);
        postRepo.save(currentPost);
    }

    public void removePost(Long id) {
        postRepo.delete(postRepo.findOne(id));
    }
}
