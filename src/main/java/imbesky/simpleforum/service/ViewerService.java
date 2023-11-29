package imbesky.simpleforum.service;

import static imbesky.simpleforum.constant.Format.DASH;
import static imbesky.simpleforum.constant.Format.NO_POSTS;

import imbesky.simpleforum.domain.Post;
import imbesky.simpleforum.domain.dto.PostViewDto;
import imbesky.simpleforum.domain.dto.PostPreviewDto;
import imbesky.simpleforum.repository.PostRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class ViewerService {
    private final PostRepository postRepository;

    @Autowired
    public ViewerService(final PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostViewDto viewPost(final long id){
        return postRepository.findById(id).toPostViewDto();
    }

    public List<PostPreviewDto> previews(){
        final List<Post> posts = postRepository.findAll();
        if(posts.isEmpty()){
            return List.of(PostPreviewDto.of(null, DASH, NO_POSTS, DASH));
        }
        return posts.stream().map(Post::toPostPreviewDto).toList();
    }

}
