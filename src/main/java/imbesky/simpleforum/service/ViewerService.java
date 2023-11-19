package imbesky.simpleforum.service;

import imbesky.simpleforum.domain.Post;
import imbesky.simpleforum.domain.dto.PostViewDto;
import imbesky.simpleforum.domain.dto.PostsDto;
import imbesky.simpleforum.repository.SimplePostRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ViewerService {
    private final SimplePostRepository simplePostRepository;
    public ViewerService(SimplePostRepository simplePostRepository) {
        this.simplePostRepository = simplePostRepository;
    }
    public PostViewDto inquirePost(final long id){
        return PostViewDto.of(simplePostRepository.findById(id));
    }
    public PostsDto posts(){
        return PostsDto.of(ids(),authors(),titles(),writtenDates());
    }
    private List<Long> ids(){
        return simplePostRepository.findAllPosts().stream().map(Post::postId).toList();
    }
    private List<String> authors(){
        return simplePostRepository.findAllPosts().stream().map(Post::authorName).toList();
    }
    private List<String> titles(){
        return simplePostRepository.findAllPosts().stream().map(Post::shortTitle).toList();
    }
    private List<LocalDate> writtenDates(){
        return simplePostRepository.findAllPosts().stream().map(Post::writtenDate).toList();
    }
}
