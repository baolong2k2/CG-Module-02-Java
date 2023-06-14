package model.service;

import model.entity.*;
import model.exception.InvalidChoiceException;
import model.ulti.FileReaderUtils;
import model.ulti.Input;
import model.ulti.WriteFileUlti;
import view.multiverse_view.UserView;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PostService {
    private static final PostService postService = new PostService();
    private static final List<Post> POST_LIST = new ArrayList<>();
    private static final List<Scientist> SCIENTIST_LIST = UserService.getInstance().getScientistList();
    private static int totalPost;

    private PostService() {
    }

    public static PostService getInstance() {
        return postService;
    }

    static {
        List<Post> dataList = FileReaderUtils.fileReadingPost("src/model/data/post.csv");
        POST_LIST.addAll(dataList);
        totalPost = dataList.size();
    }


    public void addPost() {
        do {
            try {
                boolean checkPermission = false;
                for (Scientist scientist : SCIENTIST_LIST) {
                    if (scientist.getId() == UserService.getCurrentUser().getId()) {
                        if (scientist.getPermission().equalsIgnoreCase("S") || scientist.getPermission().equalsIgnoreCase("A")) {
                            checkPermission = true;
                            break;
                        }
                    }
                }

                if (checkPermission) {
                    String title = Input.prompt("Enter the title of the post: ");
                    String content = Input.prompt("Enter the content of the post: ");
                    Post newPost = new Post(UserService.getCurrentUser(), title, content);
                    POST_LIST.add(newPost);
                    WriteFileUlti.writeFilePost("C:\\CodeGym\\module-02-java\\CS\\Multiverse\\src\\model\\data\\post.csv", newPost);
                    System.out.println("Post added successfully.");
                    return;

                } else {
                    System.err.println("ERROR: This scientist does not have the required permission to add a post.");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }


    public void deletePost() {
        System.out.println("Current Post:");
        displayPostList();

        int postId = Input.choiceIntegerInput("Enter the ID of post to remove: ");

        boolean removed = false;
        Iterator<Post> iterator = POST_LIST.iterator();
        while (iterator.hasNext()) {
            Post post = iterator.next();
            if (post.getId() == postId) {
                iterator.remove();
                removed = true;
                break;
            }
        }

        if (removed) {
            System.err.println("POST has been removed !!!");
        } else {
            System.out.println(" <<< No Post found with the provided ID >>>");
        }
    }

    private void displayPostList() {
        System.out.println("Post List:");
        for (Post post : POST_LIST) {
            System.out.println("ID: " + post.getId() + " -->TITLE: " + post.getTitle());
        }
    }

    public void editPost() {
        while (true) {
            try {
                POST_LIST.forEach(post -> System.out.println("ID: " + post.getId() + ". " + post.getTitle() + " | " + post.getContent()));
                System.out.println("""
                        What would you like to change by using the Reality Stone?
                        (1) Title of post 📜
                        (2) Content of post 🥁
                        (3) Use Time Stone to return ⏳⏳⏳
                        """);
                int choice = Input.choiceIntegerInput("Select your choice: ");
                if (choice == 3) {
                    return;
                }
                int id = Input.choiceIntegerInput("Enter the ID of post to edit: ");
                Post post = POST_LIST.stream().filter(m -> m.getId() == id).findFirst().orElse(null);
                if (post == null) {
                    System.out.println("No Post found with the provided ID.");
                    return;
                }
                switch (choice) {
                    case 1:
                        System.out.println(post.getTitle());
                        String editPostTitle = Input.prompt("Enter a new title for the Post: ");
                        post.setTitle(editPostTitle);
                        System.out.println("A title of post has been edited successfully.");
                        break;
                    case 2:
                        System.out.println(post.getContent());
                        String editPostContent = Input.prompt("Enter a new detail for the Multiverse: ");
                        post.setContent(editPostContent);
                        System.out.println("A Content of post has been edited successfully.");
                        break;
                    default:
                        throw new InvalidChoiceException("The Reality Stone has no power for this choice.");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void showDetailPostById(int id) {
        boolean found = false;
        for (Post post : POST_LIST) {
            if (post.getId() == id) {
                System.out.println(" \uD83C\uDF8APost Information\uD83C\uDF8A ");
                System.out.println("(1) ID: " + post.getId());
                System.out.println("(2) Title: " + post.getTitle());
                System.out.println("(3) Content: " + post.getContent());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println(" ❌No Post found with the provided ID❌ ");
        }
    }


    public void showListPost() {
        do {
            try {
                for (Post post : POST_LIST) {
                    System.out.println(post);
                }

                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public void addCommentToPost(int postId, String comment) {
        Post post = findPostById(postId);
        if (post != null) {
            CommentService.getInstance().addComment(postId, comment);
            return;
        } else {
            System.out.println("⚠ Post not found! ⚠");
        }
    }

    private Post findPostById(int postId) {
        for (Post post : POST_LIST) {
            if (post.getId() == postId) {
                return post;
            }
        }
        return null;
    }

    public void explorePost() {
        PostService.getInstance().displayDetailOfPost();
        System.out.println("""
                🔸🔸🔸 Which galaxy do you want to experience ❓  🔸🔸🔸

                """);
        int id = Input.choiceIntegerInput("GIVE ME ID: ");
        PostService.getInstance().displayChoosenPost(id);
    }

    private void displayChoosenPost(int id) {
        boolean found = false;
        for (Post post : POST_LIST) {
            if (post.getId() == id) {
                System.out.println("*** Post Information *** ");
                System.out.println("(1) ID: " + post.getId());
                System.out.println("(2) Title of post: " + post.getTitle());
                System.out.println("(3) Content of post: " + post.getContent());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println(" ❌❌❌ No Galaxy found with the provided ID ❌❌❌ ");
        }
    }


    private void displayDetailOfPost() {
        displayPostList();
    }
}



