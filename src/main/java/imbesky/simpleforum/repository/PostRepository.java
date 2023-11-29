package imbesky.simpleforum.repository;

import imbesky.simpleforum.domain.Post;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository {
    Post save(final Post post);
    void deleteById(final long id);
    List<Post> findAll();
    Post findById(final long id);
}