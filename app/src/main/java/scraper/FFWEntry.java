package scraper;

/**
 * This class represents an entry in the scraped data.
 * An entry consists of a title, a description, and a link.
 */
public final class FFWEntry implements EntryInterface {
  public static final String DOMAIN_NAME = "https://www.nparks.gov.sg";

  private final String title;
  private final String desc;
  private final String link;
  private final String imageLink;

  /**
   * Constructs a new Entry.
   *
   * @param title the title of the entry
   * @param desc the description of the entry
   * @param link the link of the entry
   */
  public FFWEntry(String title, String desc, String link, String imageLink) {
    this.title = title;
    this.desc = desc;
    this.link = link.startsWith("https://") ? link : DOMAIN_NAME + link;
    this.imageLink = imageLink.startsWith("https://") ? imageLink : DOMAIN_NAME + imageLink;
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
   * Returns a string representation of the entry.
   *
   * @return a string representing the entry
   */
  @Override
  public String toString() {
    return String.format("FFW: [\n\tTitle: %s,\n\tDesc: %s,\n\tLink: %s,\n\tImage Link: %s\n]\n", 
        this.getTitle(), 
        this.getDesc(), 
        this.getLink(),
        this.getImageLink());
  }
}
