package imbesky.simpleforum;

import imbesky.simpleforum.repository.PostRepository;
import imbesky.simpleforum.service.DeleteService;
import imbesky.simpleforum.service.EditService;
import imbesky.simpleforum.service.SaveService;
import imbesky.simpleforum.service.ViewerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SimpleforumConfig {
    private final PostRepository postRepository;

    @Autowired
    public SimpleforumConfig(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Bean
    public ViewerService viewerService(){
        return new ViewerService(postRepository);
    }

    @Bean
    public SaveService service(){
        return new SaveService(postRepository);
    }

    @Bean
    public EditService editService(){
        return new EditService(postRepository);
    }

    @Bean
    public DeleteService deleteService(){
        return new DeleteService(postRepository);
    }
}
