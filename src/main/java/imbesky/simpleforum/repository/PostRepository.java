package imbesky.simpleforum.repository;

import imbesky.simpleforum.domain.Post;
import imbesky.simpleforum.domain.dto.PostEditDto;
import java.util.List;

public interface PostRepository {
    void save(final Post post);
    void edit(final long id, final PostEditDto postEditDto);
    void delete(final long id);
    boolean checkPassword(final String input, final long id);
    List<Post> findAllPosts();
    Post findById(final long id);

}