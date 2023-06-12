package scraper;

import java.io.IOException;
import java.util.Optional;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Scraper represents a tool for extracting details from a specific URL.
 * The details are extracted via web scraping, and are returned as Jsoup elements.
 * The scraper uses CSS queries to select elements from the web page.
 */
public final class Scraper {

  /**
   * A Jsoup Document representing the web page that is being scraped.
   */
  private final Document doc;

  /**
   * Constructs a new Scraper. Initializes the Document instance with the specific URL.
   *
   * @param url The URL of the web page to be scraped.
   * @param fallbackFilePath The path to the HTML document to be used if the URL is inaccessible.
   * @throws IOException if an I/O error occurs during retrieval of the HTML document.
   */
  public Scraper(String url, String fallbackFilePath) throws IOException {
    WebConnector webConnector = 
      new WebConnector(url, fallbackFilePath);
    doc = webConnector.getDoc();
  }

  /**
   * Selects the first element that matches the specified CSS query from the web page.
   *
   * @param tag The CSS query.
   * @return The first matching element, or null if no elements match.
   */
  public Element selectFirst(String tag) {
    return this.selectFirst(this.doc, tag);
  }

  /**
   * Selects the first element that matches the specified CSS query from the provided element.
   *
   * @param e The element to search from.
   * @param tag The CSS query.
   * @return The first matching element, or null if no elements match.
   */
  public Element selectFirst(Element e, String tag) {
    return Optional.of(e)
      .map(x -> x.selectFirst(tag))
      .orElse(null);
  }

  /**
   * Gets the text of the first element that matches the specified CSS query from the web page.
   *
   * @param tag The CSS query.
   * @return The text of the first matching element, or null if no elements match.
   */
  public String getText(String tag) {
    return this.getText(this.doc, tag);
  }

  /**
   * Gets the text of the first element that matches the specified CSS query from the provided element.
   *
   * @param e The element to search from.
   * @param tag The CSS query.
   * @return The text of the first matching element, or null if no elements match.
   */
  public String getText(Element e, String tag) {
    return Optional.of(selectFirst(e, tag))
      .map(x -> x.text())
      .orElse(null);
  }

  /**
   * Gets the value of the specified attribute from the first element that matches the specified CSS query from the web page.
   *
   * @param tag The CSS query.
   * @param attr The attribute name.
   * @return The value of the specified attribute, or null if no elements match.
   */
  public String getAttr(String tag, String attr) {
    return this.getAttr(this.doc, tag, attr);
  }

  /**
   * Gets the value of the specified attribute from the first element that matches the specified CSS query from the provided element.
   *
   * @param e The element to search from.
   * @param tag The CSS query.
   * @param attr The attribute name.
   * @return The value of the specified attribute, or null if no elements match.
   */
  public String getAttr(Element e, String tag, String attr) {
    return Optional.of(selectFirst(e, tag))
      .map(x -> x.attr(attr))
      .orElse(null);
  }

  /**
   * Selects all elements that match the specified CSS query from the web page.
   *
   * @param tag The CSS query.
   * @return All matching elements, or null if no elements match.
   */
  public Elements select(String tag) {
    return Optional.of(doc)
      .map(x -> x.select(tag))
      .orElse(null);
  }

  /**
   * Retrieves the Document object representing the web page.
   *
   * @return The Document object.
   */
  public Document getDoc() {
    return this.doc;
  }
}
