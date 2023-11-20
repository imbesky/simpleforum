package imbesky.simpleforum.service;

import imbesky.simpleforum.domain.Post;
import imbesky.simpleforum.domain.dto.PostEditDto;
import imbesky.simpleforum.domain.dto.PostSaveDto;
import imbesky.simpleforum.repository.JpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SaveService {
    private final JpaRepository jpaRepository;

    @Autowired
    public SaveService(final JpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }
    public void saveEditedPost(final PostSaveDto postSaveDto){
        jpaRepository.save(Post.from(postSaveDto));
    }
    public void saveEditedPost(final long id, final PostEditDto postEditDto){
        jpaRepository.edit(id, postEditDto);
    }
}
