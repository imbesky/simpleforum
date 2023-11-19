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
    public void edit(final long id, final Post post) {

    }

    @Override
    public void edit(final Post post) {

    }

    @Override
    public void delete(final long id) {

    }

    @Override
    public boolean checkPassword(final String input, final long id) {
        return false;
    }

    @Override
    public List<Post> findAllPosts() {
        return null;
    }

    @Override
    public Post findById(final long id) {
        return null;
    }
}
