package simpleforum.service;

import org.springframework.stereotype.Service;
import simpleforum.domain.Post;
import simpleforum.repository.PostRepository;

import java.util.List;
@Service
public class PostService {
    private final PostRepository postRepository;
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post postPost(Post post){
        postRepository.save(post);
        return post;
    }
    public List<Post> returnList(){
        return postRepository.returnList();
    }
    public boolean check(int number, String pw){
        return postRepository.passWordCheck(number, pw);
    }
    public void postEdit(int number, Post post){
        postRepository.edit(number, post);
    }
    public void postDelete(int number){
        postRepository.delete(number);
    }
}
