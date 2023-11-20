package imbesky.simpleforum.service;

import imbesky.simpleforum.domain.dto.PasswordDto;
import imbesky.simpleforum.repository.JpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DeleteService implements PostService{
    private final JpaRepository jpaRepository;

    @Autowired
    public DeleteService(final JpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    public boolean checkPassword(final PasswordDto passwordDto){
        return jpaRepository.checkPassword(passwordDto.inputPassword(),passwordDto.id());
    }

    public void deletePost(final long id){
        jpaRepository.delete(id);
    }
}
