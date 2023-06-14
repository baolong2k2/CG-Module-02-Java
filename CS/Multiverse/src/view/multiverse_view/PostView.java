package view.multiverse_view;

import model.entity.Customer;
import model.entity.Scientist;
import model.exception.InvalidChoiceException;
import model.service.CommentService;
import model.service.MultiverseService;
import model.service.PostService;
import model.service.UserService;
import model.ulti.Input;

public class PostView {
    private static final PostView postView = new PostView();
    private PostView() {
    }
    public static PostView getInstance() {
        return postView;
    }

    public void customizePost() {
        do {
            try {
                System.out.println("""
                        *** 🙀 CHOOSE ACTION 🙀 ***
                        (1) Show all post
                        (2) Add to Post list 📝
                        (3) Remove the Post from the list 😱
                        (4) Edit Post list 😍
                        (5) Use the Time Stone to return to the menu 👻
                        """);
                int choice = Input.choiceIntegerInput("Choose a number of destiny: ");
                switch (choice){

                    case 1:
                        PostService.getInstance().explorePost();
                        break;

                    case 2:
                        PostService.getInstance().addPost();
                        break;

                    case 3:
                        PostService.getInstance().deletePost();
                        break;

                    case 4:
                        PostService.getInstance().editPost();
                        break;

                    case 5:
                        return;

                    default:
                        throw new InvalidChoiceException("Invalid selection");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public void showAllPost() {
        do {
            try {
                PostService.getInstance().showListPost();
                System.out.println("""
                1. Read post by id 🌪🌪🌪.
                2. Return 🌉🌉🌉
                """);
                int choice = Input.choiceIntegerInput("Choose a number of destiny: ");
                switch (choice) {

                    case 1:
                        int postId = Input.choiceIntegerInput("GIVE ME ID OF POST: ");
                        PostService.getInstance().showDetailPostById(postId);
                        CommentService.getInstance().showAllComment(postId);
                        commentFunction();
                        break;

                    case 2:
                        return;

                    default:
                        System.out.println("Invalid selection");
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }while (true);

    }

    public void commentFunction(){
        do {
            try {
                System.out.println("""
                1. Comment a post 📝📝📝
                2. Choose another post to view
                3. Return ⏳⏳⏳
                """);
                int choice = Input.choiceIntegerInput("Choose a number of destiny: ");
                switch (choice) {

                    case 1:
                        int postId = Input.choiceIntegerInput("Enter post id: ");
                        String comment = Input.prompt("Enter your comment: ");

                        PostService.getInstance().addCommentToPost(postId, comment);
                        commentFunction();
                        break;

                    case 2:
                        showAllPost();
                        break;

                    case 3:
                        return;

                    default:
                        System.out.println("\uD83D\uDEA8Invalid selection\uD83D\uDEA8");
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }while (true);

    }
}
