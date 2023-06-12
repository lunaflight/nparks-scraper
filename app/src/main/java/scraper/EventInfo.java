package scraper;

import java.io.IOException;
import java.util.stream.Stream;

/**
 * EventInfo represents a handler for extracting details about events from a specific URL.
 * The events are extracted via web scraping, and are returned as a Stream of EventEntry instances.
 */
public final class EventInfo {

  /**
   * An instance of the Scraper class used to extract information from the webpage.
   */
  private final Scraper scraper;

  /**
   * Constructor for EventInfo. Initializes the Scraper instance with the specific URL
   * and caches the HTML document.
   *
   * @throws IOException if an I/O error occurs during retrieval of the HTML document.
   */
  public EventInfo() throws IOException {
    scraper = new Scraper("https://www.nparks.gov.sg/activities/events-and-workshops", "EventCache.html");
  }

  /**
   * Retrieves a stream of `EventEntry`s representing the events listed on the page.
   * Each `EventEntry` object contains the title, description, link, date, time, and location of an event.
   *
   * @return a Stream of `EventEntry` objects representing the events on the page.
   */
  public Stream<EventEntry> getEvents() {
    return this.scraper.select("li.event")
      .stream()
      .map(x ->
          new EventEntry(
            this.scraper.getText(x, "h3.title-event a"),
            this.scraper.getText(x, "div.summary"),
            this.scraper.getAttr(x, "h3.title-event a", "href"),
            this.scraper.getAttr(x, "div.thumbnail-event a img", "src"),
            this.scraper.getText(x, "div.duration span.date"),
            this.scraper.getText(x, "div.duration span.time"),
            this.scraper.getText(x, "div.location span")
            )
          );
  }
}

