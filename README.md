# Simple forum project

## Versions
`Java 17` `Spring 3.1.5`

## 기능

### 게시글 작성 및 게시

- 작성자, 제목, 내용을 입력해 게시글을 작성할 수 있다.
  - 작성자는 공백 포함 4글자 이상, 12글자 이하로 작성해야 한다.
  - 제목은 공백 포함 4글자 이상, 30글자 이하로 작성해야 한다.
  - 게시글은 공백 포함 1000자 이하로 작성해야 하며 공백만 입력하는 것은 불가하다.
- 문자 또는 숫자로 된 4자리의 비밀번호를 반드시 설정해야 한다.
- 작성일은 최초 게시 일시로 설정된다.
- 게시글 번호는 작성 순서대로 부여된다.

### 게시글 조회

#### 게시글 리스트 페이지

- 게시글 리스트 페이지에서는 게시글의 번호, 작성자, 제목, 작성일을 조회 가능하다.
  - 제목은 최대 10글자까지만 조회 가능하다.
  - 10글자 이후의 내용이 더 있을 경우 뒷부분은 "..." 으로 처리된다.

#### 게시글 세부 페이지

- 게시글 세부 페이지에서는 게시글의 번호, 작성자, 제목, 작성일, 내용을 조회 가능하다.
- 수정과 삭제 버튼이 존재한다.

### 게시글 수정

- 게시글 입력 시 올바른 비밀번호를 입력하면 게시글 수정이 가능하다.
  - 제목, 내용, 비밀번호만 수정 가능하다.
- 비밀번호 오류가 발생하면 비밀번호 오류를 알리는 페이지로 이동한다.

### 게시글 삭제

- 게시글 입력 시 올바른 비밀번호를 입력하면 게시글 삭제가 가능하다.
- 비밀번호 오류가 발생하면 비밀번호 오류를 알리는 페이지로 이동한다.