package com.greenfox.service;

import com.greenfox.domain.Post;
import com.greenfox.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private PostRepository postRepo;

    @Autowired
    public PostService(PostRepository postRepo) {
        this.postRepo = postRepo;
    }

    public Page<Post> obtainPage(Integer pageNumber, Integer pageSize) {
        return postRepo.findByOrderByScoreDesc(new PageRequest(pageNumber, pageSize));
    }

    public void savePost(Post post) {
        post.setUserName(obtainUserNameFromSecurity());
        postRepo.save(post);
    }

    public void changePostScore(Long id, Integer difference) {
        Post currentPost = postRepo.findOne(id);
        currentPost.setScore(currentPost.getScore() + difference);
        savePost(currentPost);
    }

    public Post findById(Long id) {
        return postRepo.findOne(id);
    }

    public void editPost(Long id, String content) {
        Post postToEdit = postRepo.findOne(id);
        if (postToEdit.getUserName().
                equals(obtainUserNameFromSecurity())) {
            postToEdit.setContent(content);
        }
        savePost(postToEdit);
    }

    public void deletePost(Long id) {
        if (postRepo.findOne(id).getUserName().
                equals(obtainUserNameFromSecurity())) {
            postRepo.delete(id);
        }
    }

    private String obtainUserNameFromSecurity() {
        return SecurityContextHolder.
                getContext().
                getAuthentication().
                getName();
    }
}
