package simpleforum.repository;

import org.springframework.stereotype.Repository;
import simpleforum.domain.Post;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class MemoryPostRepository implements PostRepository{
    public static int sequence = 0;
    private static Map<Integer, Post> list = new HashMap<>();
    @Override
    public Post save(Post post) {
        post.setNumber(sequence++);
        post.setWrittenDate(DateTimeFormatter.ISO_LOCAL_DATE.format(LocalDateTime.now()));
        list.put(post.getNumber(), post);
        return post;
    }

    @Override
    public boolean passWordCheck(int number, String pw) {
        return list.get(number).getPassWord().equals(pw);
    }

    @Override
    public List<Post> returnList() {
        return new ArrayList<>(list.values());
    }

    @Override
    public void edit(int number, Post post) {
        list.replace(number, post);
    }

    @Override
    public void delete(int number) {
        list.remove(number);
    }
}
