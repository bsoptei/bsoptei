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
        return postRepo.findAll(new PageRequest(0, 5));
    }

    public void addPost(Post post) {
        postRepo.save(post);
    }

    public void changePostScore(Long id, Integer difference) {
        Post currentPost = postRepo.findOne(id);
        currentPost.setScore(difference);
        postRepo.save(currentPost);
    }
}
