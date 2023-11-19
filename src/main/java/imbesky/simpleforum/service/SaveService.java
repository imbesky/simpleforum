package imbesky.simpleforum.service;

import imbesky.simpleforum.domain.Post;
import imbesky.simpleforum.domain.dto.PostSaveDto;
import org.springframework.stereotype.Service;
import imbesky.simpleforum.repository.SimplePostRepository;

@Service
public class SaveService {
    private final SimplePostRepository simplePostRepository;
    public SaveService(SimplePostRepository simplePostRepository) {
        this.simplePostRepository = simplePostRepository;
    }
    public void savePost(final PostSaveDto postSaveDto){
        final Post post = new Post(postSaveDto);
        simplePostRepository.save(post);
    }
}
