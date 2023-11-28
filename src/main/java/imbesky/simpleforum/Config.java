package imbesky.simpleforum;

import imbesky.simpleforum.repository.JpaRepository;
import imbesky.simpleforum.repository.PostRepository;
import imbesky.simpleforum.service.DeleteService;
import imbesky.simpleforum.service.EditService;
import imbesky.simpleforum.service.SaveService;
import imbesky.simpleforum.service.ViewerService;
import jakarta.persistence.EntityManager;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    private final DataSource dataSource;
    private final EntityManager manager;
    public Config(DataSource dataSource, EntityManager manager) {
        this.dataSource = dataSource;
        this.manager = manager;
    }

    @Bean
    public ViewerService viewerService(){
        return new ViewerService(postRepository());
    }

    @Bean
    public SaveService service(){
        return new SaveService(postRepository());
    }

    @Bean
    public EditService editService(){
        return new EditService(postRepository());
    }

    @Bean
    public DeleteService deleteService(){
        return new DeleteService(postRepository());
    }

    @Bean
    public PostRepository postRepository(){
        return new JpaRepository(manager);
    }
}
