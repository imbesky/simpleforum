package imbesky.simpleforum.repository;

import imbesky.simpleforum.domain.Post;
import java.util.List;

public interface PostRepository {
    void save(final Post post);
    void edit(final Post post);
    void delete(final long id);
    boolean checkPassword(final String input, final long id);
    List<Post> findAllPosts();
    Post findById(final long id);

}