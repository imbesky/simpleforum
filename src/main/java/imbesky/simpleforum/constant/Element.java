package imbesky.simpleforum.constant;

import static imbesky.simpleforum.constant.Format.BLANK;

public enum Element {
    ID("작성 번호", BLANK),
    TITLE("제목", "제목은 %d글자 이상 %d글자 이하로 입력하세요."),
    AUTHOR("작성자", "작성자는 %d글자 이상 %d글자 이하로 입력하세요."),
    CONTENT("내용", "내용은 %d글자 이상 %d글자 이하로 입력하세요."),
    PASSWORD("비밀번호", "비밀번호는 %d글자로 입력하세요."),
    WRITTEN_DATE("작성일", BLANK);
    private final String name;
    private final String notice;

    Element(String name, String notice) {
        this.name = name;
        this.notice = notice;
    }

    public String getName() {
        return name;
    }

    public String getNotice() {
        return notice;
    }
}
