package imbesky.simpleforum.repository;

import imbesky.simpleforum.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataJpaPostRepository extends JpaRepository<Post, Long>, PostRepository {
}
