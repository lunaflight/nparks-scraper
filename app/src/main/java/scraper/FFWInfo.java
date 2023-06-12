package scraper;

import java.io.IOException;
import java.util.stream.Stream;

/**
 * FFWInfo represents a handler for extracting details about Flora and Fauna from a specific URL.
 * The details are extracted via web scraping, and are returned as FFWEntry instances.
 */
public final class FFWInfo {

  /**
   * An instance of the Scraper class used to extract information from the webpage.
   */
  private final Scraper scraper;

  /**
   * Constructor for FFWInfo. Initializes the Scraper instance with the specific URL
   * and caches the HTML document.
   *
   * @throws IOException if an I/O error occurs during retrieval of the HTML document.
   */
  public FFWInfo() throws IOException {
    scraper = new Scraper("https://www.nparks.gov.sg/FloraFaunaWeb", "FFWCache.html");
  }

  /**
   * Retrieves details of the plant of the month from the web page.
   *
   * @return an FFWEntry representing the plant of the month.
   */
  public FFWEntry getPlantOfTheMonth() {
    return new FFWEntry(
        this.scraper.getText("div.species-of-month.plant h4.species-of-month__name"),
        this.scraper.getText("div.species-of-month.plant p.species-of-month__desc"),
        this.scraper.getAttr("div.species-of-month.plant div.species-of-month__link a", "href"),
        this.scraper.getAttr("div.species-of-month.plant div.species-of-month__image img", "src")
        );
  }

  /**
   * Retrieves details of the animal of the month from the web page.
   *
   * @return an FFWEntry representing the animal of the month.
   */
  public FFWEntry getAnimalOfTheMonth() {
    return new FFWEntry(
        this.scraper.getText("div.species-of-month.animal h4.species-of-month__name"),
        this.scraper.getText("div.species-of-month.animal p.species-of-month__desc"),
        this.scraper.getAttr("div.species-of-month.animal div.species-of-month__link a", "href"),
        this.scraper.getAttr("div.species-of-month.animal div.species-of-month__image img", "src")
        );
  }

  /**
   * Retrieves a stream of FFWEntry instances representing the "Did You Know" facts from the web page.
   *
   * @return a Stream of FFWEntry instances representing the "Did You Know" facts.
   */
  public Stream<FFWEntry> getDidYouKnowFacts() {
    return this.scraper.select("div.did-you-know__item")
      .stream()
      .map(x ->
          new FFWEntry(
            this.scraper.getText(x, "h4.name"),
            this.scraper.getText(x, "p.rte"),
            this.scraper.getAttr(x, "a", "href"),
            this.scraper.getAttr(x, "img", "src")
            )
          );
  }
}

