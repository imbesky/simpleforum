package imbesky.simpleforum.service;

import imbesky.simpleforum.domain.dto.PasswordDto;
import imbesky.simpleforum.domain.dto.PostViewDto;
import imbesky.simpleforum.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class EditService implements PostService{
    private final PostRepository postRepository;

    @Autowired
    public EditService(final PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public boolean checkPassword(final PasswordDto passwordDto){
        return postRepository.checkPassword(passwordDto.inputPassword(),passwordDto.id());
    }

    public PostViewDto originalPost(final long id){
        return postRepository.findById(id).toPostViewDto();
    }
}
