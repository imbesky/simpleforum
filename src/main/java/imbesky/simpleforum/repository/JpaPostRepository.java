//package imbesky.simpleforum.repository;
//
//import imbesky.simpleforum.domain.Post;
//import imbesky.simpleforum.domain.dto.PostEditDto;
//import jakarta.persistence.EntityManager;
//import java.util.List;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public class JpaPostRepository implements PostRepository{
//    private final EntityManager manager;
//
//    public JpaPostRepository(final EntityManager manager) {
//        this.manager = manager;
//    }
//
//    @Override
//    public void save(final Post post) {
//        manager.persist(post);
//    }
//
//
//    @Override
//    public void delete(long id) {
//        manager.remove(findById(id));
//    }
//
//
//    @Override
//    public List<Post> findAllPosts() {
//        return manager.createQuery("select p from Post p", Post.class).getResultList();
//    }
//
//    @Override
//    public Post findById(long id) {
//        return manager.find(Post.class,id);
//    }
//}
