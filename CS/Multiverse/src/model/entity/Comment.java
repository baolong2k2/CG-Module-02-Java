package model.entity;

public class Comment {
    private int id;
    private int postId;
    private String detail;
    private static int count;
    private User user;

    public Comment(int id, int postId, String detail) {
        this.id = id;
        this.postId = postId;
        this.detail = detail;
    }

    public Comment(int postId, String detail) {
        this.id = ++count;
        this.postId = postId;
        this.detail = detail;
    }

    public Comment(int postId, String detail, User user) {
        this.postId = postId;
        this.detail = detail;
        this.user = user;
        this.id = ++count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return String.format("""
                💖💖 Comment 💖💖:
                👽: %s
                💭: %s
                """, getUser().getName(), getDetail());
    }
}
