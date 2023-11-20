package imbesky.simpleforum.service;

import imbesky.simpleforum.domain.dto.PasswordDto;
import imbesky.simpleforum.domain.dto.PostViewDto;
import imbesky.simpleforum.repository.SimplePostRepository;
import org.springframework.stereotype.Service;

@Service
public class EditService implements PostService{
    private final SimplePostRepository simplePostRepository;
    public EditService(SimplePostRepository simplePostRepository) {
        this.simplePostRepository = simplePostRepository;
    }

    public boolean checkPassword(final PasswordDto passwordDto){
        return simplePostRepository.checkPassword(passwordDto.inputPassword(),passwordDto.id());
    }

    public PostViewDto originalPost(final long id){
        return simplePostRepository.findById(id).toPostViewDto();
    }
}
