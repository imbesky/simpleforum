package imbesky.simpleforum.service;

import imbesky.simpleforum.domain.Post;
import imbesky.simpleforum.domain.dto.PostEditDto;
import imbesky.simpleforum.domain.dto.PostSaveDto;
import imbesky.simpleforum.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class SaveService {
    private final PostRepository postRepository;

    @Autowired
    public SaveService(final PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    public void saveEditedPost(final PostSaveDto postSaveDto){
        postRepository.save(Post.from(postSaveDto));
    }
    public void saveEditedPost(final long id, final PostEditDto postEditDto){
        postRepository.findById(id).editPost(postEditDto);
    }
}
