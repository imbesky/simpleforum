package imbesky.simpleforum.domain.dto;

import static imbesky.simpleforum.constant.Format.BLANK;
import static imbesky.simpleforum.constant.Format.POST_URL;

public record PostPreviewDto(
        Long id,
        String url,
        String author,
        String title,
        String writtenDate
){
    public static PostPreviewDto of(final Long id, final String author, final String title, final String writtenDate){
        String url = String.format(POST_URL, id);
        if(id==null){
            url = BLANK;
        }
        return new PostPreviewDto(id, url ,author, title, writtenDate);
    }
}
