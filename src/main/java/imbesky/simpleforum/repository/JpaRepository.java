package imbesky.simpleforum.repository;

import imbesky.simpleforum.domain.Post;
import imbesky.simpleforum.domain.dto.PostEditDto;
import jakarta.persistence.EntityManager;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class JpaRepository implements PostRepository{
    private final EntityManager manager;

    public JpaRepository(final EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public void save(final Post post) {
        manager.persist(post);
    }

    @Override
    public void edit(final long id, final PostEditDto postEditDto) {
        findById(id).editPost(postEditDto);
    }

    @Override
    public void delete(long id) {
        manager.remove(findById(id));
    }

    @Override
    public boolean checkPassword(final String input, final long id) {
        return findById(id).checkPassword(input);
    }

    @Override
    public List<Post> findAllPosts() {
        return manager.createQuery("select p from Post p", Post.class).getResultList();
    }

    @Override
    public Post findById(long id) {
        return manager.find(Post.class,id);
    }
}
