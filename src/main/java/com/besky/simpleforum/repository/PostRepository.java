package com.besky.simpleforum.repository;

import com.besky.simpleforum.domain.Post;

import java.util.List;

public interface PostRepository {
    Post save(Post post);
    boolean passWordCheck(int number, String pw);
    List<Post> returnList();
    void edit(int number, Post post);
    void delete(int number);
}
