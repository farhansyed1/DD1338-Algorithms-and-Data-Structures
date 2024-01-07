import java.time.LocalDate;
import java.util.ArrayList;

/**
 * The NewsFeed class stores news posts for the news feed in a
 * social network application (like FaceBook or Google+).
 *
 * Display of the posts is currently simulated by printing the
 * details to the terminal. (Later, this should display in a browser.)
 *
 * This version does not save the data to disk, and it does not
 * provide any search or ordering functions.
 *
 * @author Michael Kölling and David J. Barnes
 * @author Farhan Syed
 * @version 2022.01.20
 */
public class NewsFeed {

    private ArrayList<Post> posts;

    /**
     * Construct an empty news feed.
     */
    public NewsFeed() {
        posts = new ArrayList<Post>();
    }

    /**
     * Add a post to the news feed.
     *
     * @param post  The post to be added.
     */
    public void addPost(Post post) {
        posts.add(post);
    }

    /**
     * Show the news feed. Currently: print the news feed details
     * to the terminal. 
     */
    public void show() {
        // display all posts
        for(Post post : posts) {
            post.display();
            System.out.println();
        }
    }

    public static void main(String[] args) {
       //Exercise Inh.2

        NewsFeed app = new NewsFeed();
        app.addPost(new PhotoPost("Alice", "photo.jpg", "sunset over the sea"));
        app.addPost(new MessagePost("Farhan","Hellooo"));

        LocalDate date = LocalDate.of(2022, 1, 15);
        app.addPost(new EventPost("John", "Tentapub","KTH",date));

        app.show();
    }
}
