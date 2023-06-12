package scraper;

/**
 * This class represents an entry in the scraped data of events happening.
 * An event entry consists of a title, a description, a link,
 * the date, the time and the location.
 */
public final class EventEntry implements EntryInterface {
  public static final String DOMAIN_NAME = "https://www.nparks.gov.sg";
  public static final String IMAGE_EXT = "/activities/";

  private final String title;
  private final String desc;
  private final String link;
  private final String imageLink;
  private final String date;
  private final String time;
  private final String location;

  /**
   * Constructs a new Entry.
   *
   * @param title the title of the entry
   * @param desc the description of the entry
   * @param link the link of the entry
   * @param date the date of the entry
   * @param time the time of the entry
   * @param location the location of the entry
   */
  public EventEntry
    (String title, String desc, String link, String imageLink, String date, String time, String location) {
    this.title = title;
    this.desc = desc;
    this.link = link.startsWith("https://") ? link : DOMAIN_NAME + link;
    this.imageLink = imageLink.startsWith("https://") ? imageLink : DOMAIN_NAME + IMAGE_EXT + imageLink;
    this.date = date;
    this.time = time;
    this.location = location;
  }

  /**
   * Returns the title of the entry.
   *
   * @return the title
   */
  @Override
  public String getTitle() {
    return this.title;
  }

  /**
   * Returns the description of the entry.
   *
   * @return the description
   */
  @Override
  public String getDesc() {
    return this.desc;
  }

  /**
   * Returns the link of the entry.
   *
   * @return the link
   */
  @Override
  public String getLink() {
    return this.link;
  }

  /**
   * Returns the link of the entry.
   *
   * @return the link
   */
  @Override
  public String getImageLink() {
    return this.imageLink;
  }

  /**
   * Returns the date of the entry.
   *
   * @return the date
   */
  public String getDate() {
    return this.date;
  }

  /**
   * Returns the time of the entry.
   *
   * @return the time
   */
  public String getTime() {
    return this.time;
  }

  /**
   * Returns the location of the entry.
   *
   * @return the location
   */
  public String getLocation() {
    return this.location;
  }

  /**
   * Returns a string representation of the entry.
   *
   * @return a string representing the entry
   */
  @Override
  public String toString() {
    return String.format("Event: [\n\tTitle: %s,\n\tDesc: %s,\n\tLink: %s,\n\tImage Link: %s,\n\tDate: %s,\n\tTime: %s\n\tLocation: %s\n]\n", 
        this.getTitle(), 
        this.getDesc(), 
        this.getLink(),
        this.getImageLink(),
        this.getDate(),
        this.getTime(),
        this.getLocation());
  }
}
