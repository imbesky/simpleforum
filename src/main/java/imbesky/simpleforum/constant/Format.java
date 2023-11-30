package imbesky.simpleforum.constant;

public record Format() {
    public static final String BLANK = " ";
    public static final String EMPTY = "";
    public static final String DOTS = "...";
    public static final String DASH = "-";
    public static final String NO_POSTS = "작성된 게시글이 없습니다.";
    public static final String SUBMIT = "게시하기";
    public static final String ENTER = "입력하기";
    public static final String EDIT = "수정하기";
    public static final String DELETE = "삭제하기";
    public static final String WRITE = "작성하기";
    public static final String POST_URL = "/view?id=%d";
    public static final String REDIRECT_URL = "redirect:/";
    public static final String REDIRECT_NOTICE = "이전 페이지로 돌아가기";
    public static final String INDEX_PAGE_URL = "/";
    public static final String INDEX_PAGE_NOTICE = "메인 화면으로 돌아가기";
    public static final String LIST_PAGE_URL = "list";
    public static final String LIST_PAGE_NOTICE = "게시글 목록";
    public static final String PASSWORD_ERROR = "비밀번호가 일치하지 않습니다.";
    public static final String INPUT_PASSWORD = "비밀번호를 입력하세요.";
}
