package imbesky.simpleforum.service;

import imbesky.simpleforum.domain.Post;
import imbesky.simpleforum.domain.dto.PostViewDto;
import imbesky.simpleforum.domain.dto.PostPreviewDto;
import imbesky.simpleforum.repository.SimplePostRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ViewerService {
    private final SimplePostRepository simplePostRepository;
    public ViewerService(SimplePostRepository simplePostRepository) {
        this.simplePostRepository = simplePostRepository;
    }

    public PostViewDto viewPost(final long id){
        return simplePostRepository.findById(id).toPostViewDto();
    }

    public List<PostPreviewDto> previews(){
        return simplePostRepository.findAllPosts().stream().map(Post::toPostPreviewDto).toList();
    }

}
