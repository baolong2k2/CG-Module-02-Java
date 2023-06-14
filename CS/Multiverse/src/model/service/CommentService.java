package model.service;


import model.entity.Comment;
import model.ulti.FileReaderUtils;
import model.ulti.WriteFileUlti;

import java.util.ArrayList;
import java.util.List;

public class CommentService {
    private static final CommentService commentService = new CommentService();

    private static final List<Comment> COMMENT_LIST = new ArrayList<>();
    private static boolean allowComments;

    private CommentService() {
        allowComments = false;
    }

    public static CommentService getInstance() {
        return commentService;
    }

    static {
        List<Comment> dataList = FileReaderUtils.fileReadingComment("src/model/data/comment.csv");
        COMMENT_LIST.addAll(dataList);
    }

    public void setAllowComments(boolean allowComments) {
        this.allowComments = allowComments;
    }

    public void addComment(int postId, String detail) {
        do {
            try {

                Comment newComment = new Comment(postId, detail,UserService.getCurrentUser());

                WriteFileUlti.writeFileComment("C:\\CodeGym\\module-02-java\\CS\\Multiverse\\src\\model\\data\\comment.csv", newComment);
                COMMENT_LIST.add(newComment);

                CommentService commentService = CommentService.getInstance();
                commentService.setAllowComments(true);

                System.out.println("CONGRATULATIONS❗❗❗ You have comment a post.");
                return;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public void showAllComment(int postId) {
        for (Comment comment : COMMENT_LIST){
            if (comment.getPostId() == postId) {
                System.out.println(comment);
            }
        }
    }
}


