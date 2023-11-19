package imbesky.simpleforum.service;

import imbesky.simpleforum.domain.dto.PasswordDto;
import imbesky.simpleforum.domain.dto.PostSaveDto;
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

    public PostSaveDto originalPost(final long id){
        return PostSaveDto.from(simplePostRepository.findById(id));
    }
}