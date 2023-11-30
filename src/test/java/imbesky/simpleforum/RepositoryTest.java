package imbesky.simpleforum;

import static org.assertj.core.api.Assertions.assertThat;

import imbesky.simpleforum.domain.Post;
import imbesky.simpleforum.domain.dto.PostEditDto;
import imbesky.simpleforum.domain.dto.PostSaveDto;
import imbesky.simpleforum.repository.PostRepository;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class RepositoryTest {
    @Autowired
    PostRepository postRepository;

    @Test
    public void save() {
        final PostSaveDto postSaveDto = new PostSaveDto("1234","author","title","content");
        final Post post = Post.from(postSaveDto);

        postRepository.save(post);

        Post result = postRepository.findById(post.Id());
        assertThat(result).isEqualTo(post);
    }

    @Test
    public void edit(){
        final PostSaveDto postSaveDto = new PostSaveDto("1234","author","title","content");
        final Post post = Post.from(postSaveDto);
        postRepository.save(post);
        PostEditDto postEditDto = new PostEditDto("1235", "title2","content2");

        postRepository.findById(post.Id()).editPost(postEditDto);

        Post edittedPost = postRepository.findById(post.Id());
        assertThat(edittedPost.checkPassword("1235")).isEqualTo(true);
        assertThat(edittedPost.toPostViewDto().author()).isEqualTo("author");
        assertThat(edittedPost.toPostViewDto().title()).isEqualTo("title2");
        assertThat(edittedPost.toPostViewDto().content()).isEqualTo("content2");
    }

    @Test
    public void delete(){
        final PostSaveDto postSaveDto = new PostSaveDto("1234","author","title","content");
        final Post post = Post.from(postSaveDto);
        postRepository.save(post);

        postRepository.deleteById(post.Id());

        assertThat(postRepository.findById(post.Id())).isEqualTo(null);
    }

    @Test
    public void findAll(){
        final PostSaveDto postSaveDto = new PostSaveDto("1234","author","title","content");
        final PostSaveDto postSaveDto2 = new PostSaveDto("1234","author2","title2","content2");
        final PostSaveDto postSaveDto3 = new PostSaveDto("1234","author3","title3","content3");
        final Post post = Post.from(postSaveDto);
        final Post post2 = Post.from(postSaveDto2);
        final Post post3 = Post.from(postSaveDto3);

        postRepository.save(post);
        postRepository.save(post2);
        postRepository.save(post3);

        List<Post> foundPosts = postRepository.findAll();
        List<Post> expected = List.of(post, post2, post3);

        assertThat(foundPosts).isEqualTo(expected);
    }

}
