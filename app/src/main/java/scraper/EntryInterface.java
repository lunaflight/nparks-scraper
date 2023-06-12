package scraper;

/**
 * EntryInterface provides methods that return details about an entry.
 * Each entry typically represents a record in a data collection, like an event in a list.
 */
public interface EntryInterface {
  
  /**
   * Retrieves the title of the entry.
   * 
   * @return String representing the title of the entry
   */
  String getTitle();

  /**
   * Retrieves the description of the entry.
   * 
   * @return String representing the description of the entry
   */
  String getDesc();

  /**
   * Retrieves the link associated with the entry.
   * 
   * @return String representing the URL or link of the entry
   */
  String getLink();

  /**
   * Retrieves the link associated with the entry.
   * 
   * @return String representing the URL or link of the entry
   */
  String getImageLink();
}

