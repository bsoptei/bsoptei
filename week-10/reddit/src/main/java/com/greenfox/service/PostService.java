package com.greenfox.service;

import com.greenfox.domain.Post;
import com.greenfox.repository.PostRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private PostRepository postRepo;
    @Getter
    @Setter
    private Post currentPost;

    @Autowired
    public PostService(PostRepository postRepo) {
        this.postRepo = postRepo;
    }

    public Page<Post> obtainPage(Integer pageNumber, Integer pageSize) {
        return postRepo.findByOrderByScoreDesc(new PageRequest(pageNumber, pageSize));
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

    public Post findById(Long id) {
        return postRepo.findOne(id);
    }

    public void editPost(String content) {
        currentPost.setContent(content);
        postRepo.save(currentPost);
    }

    public void deletePost(Long id) {
        postRepo.delete(id);
    }
}
