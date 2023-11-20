package imbesky.simpleforum.service;

import imbesky.simpleforum.domain.Post;
import imbesky.simpleforum.domain.dto.PostEditDto;
import imbesky.simpleforum.domain.dto.PostSaveDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import imbesky.simpleforum.repository.SimplePostRepository;

@Service
public class SaveService {
    private final SimplePostRepository simplePostRepository;

    @Autowired
    public SaveService(SimplePostRepository simplePostRepository) {
        this.simplePostRepository = simplePostRepository;
    }
    public void saveEditedPost(final PostSaveDto postSaveDto){
        simplePostRepository.save(Post.from(postSaveDto));
    }
    public void saveEditedPost(final long id, final PostEditDto postEditDto){
        simplePostRepository.edit(id, postEditDto);
    }
}
