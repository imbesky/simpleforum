package imbesky.simpleforum.service;

import imbesky.simpleforum.domain.Post;
import imbesky.simpleforum.domain.dto.PostViewDto;
import imbesky.simpleforum.domain.dto.PostPreviewDto;
import imbesky.simpleforum.repository.JpaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ViewerService {
    private final JpaRepository jpaRepository;

    @Autowired
    public ViewerService(final JpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    public PostViewDto viewPost(final long id){
        return jpaRepository.findById(id).toPostViewDto();
    }

    public List<PostPreviewDto> previews(){
        return jpaRepository.findAllPosts().stream().map(Post::toPostPreviewDto).toList();
    }

}
