package imbesky.simpleforum.service;

import imbesky.simpleforum.domain.dto.PasswordDto;
import imbesky.simpleforum.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class DeleteService implements PostService{
    private final PostRepository postRepository;

    @Autowired
    public DeleteService(final PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public boolean checkPassword(final PasswordDto passwordDto){
        return postRepository.findById(passwordDto.id()).checkPassword(passwordDto.inputPassword());
    }

    public void deletePost(final long id){
        postRepository.deleteById(id);
    }
}
