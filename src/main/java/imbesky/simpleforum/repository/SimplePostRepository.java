package imbesky.simpleforum.repository;

import imbesky.simpleforum.domain.Post;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class SimplePostRepository implements PostRepository {

    @Override
    public void save(final Post post) {

    }

    @Override
    public void edit(Post post) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public boolean checkPassword(String input, long id) {
        return false;
    }

    @Override
    public List<Post> findAllPosts() {
        return null;
    }

    @Override
    public Post findById(long id) {
        return null;
    }
}
