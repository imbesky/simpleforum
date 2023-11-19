package imbesky.simpleforum.service;

import imbesky.simpleforum.domain.dto.PasswordDto;
import imbesky.simpleforum.repository.SimplePostRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteService implements PostService{
    private final SimplePostRepository simplePostRepository;
    public DeleteService(SimplePostRepository simplePostRepository) {
        this.simplePostRepository = simplePostRepository;
    }

    public boolean checkPassword(final PasswordDto passwordDto){
        return simplePostRepository.checkPassword(passwordDto.inputPassword(),passwordDto.id());
    }

    public void deletePost(final long id){
        simplePostRepository.delete(id);
    }
}
