package model.entity;

public class Post {
    private int id;
    private User user;
    private int userId;
    private String title;
    private String content;
    private static int count;



    public Post(int id, User user, String title, String content) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.content = content;
    }

    public Post(User user, String title, String content) {
        this.user = user;
        this.title = title;
        this.content = content;
        this.id = ++count;
    }

    public Post(User user,int userId, String title, String content) {
        this.id = ++count;
        this.user = user;
        this.userId = userId;
        this.title = title;
        this.content = content;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return String.format("""
                (1) Post id: %s
                (2) Title of post: %s
                """,getId(),getTitle());
    }

}
