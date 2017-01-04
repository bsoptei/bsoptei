package com.greenfox.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Lenovo on 2017. 01. 04..
 */
public interface PostRepository extends JpaRepository<Post, Long> {

    Page<Post> findByOrderByScoreDesc(Pageable pageable);

}
