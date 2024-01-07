import java.time.LocalDate;


/**
 * This class stores information about a post in a social network news feed.
 * The main part of the post consists of details of an event with date and location.
 *
 * @author Farhan Syed
 * @version 2022.01.20
 */
public class EventPost extends Post {

    private String title;  // the name of the image file
    private String location;   // a one line image caption
    private LocalDate date;  // the name of the image file

    /**
     * Constructor for objects of class MessagePost.
     *
     * @param author    The username of the author of this post.
     * @param title     The title of the event.
     * @param location  The location of the event.
     * @param date      The date of the event.
     */
    public EventPost(String author, String title, String location, LocalDate date) {
        super(author);
        this.title = title;
        this.location = location;
        this.date = date;
    }

    /**
     * Display the details of this post.
     *
     * (Currently: Print to the text terminal. This is simulating display
     * in a web browser for now.)
     */
    public void display() {
        System.out.println(title);
        System.out.println("Location: " + location);
        System.out.println("Date: " + date);
        System.out.println("*********************");
        super.display();
    }
}
