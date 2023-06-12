package scraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;

/**
 * WebConnector provides an interface to connect to a specified web page 
 * or local HTML file and retrieve a Jsoup Document.
 */
public class WebConnector {
  /**
   * A Jsoup Document representing the web page or local HTML file.
   */
  private Document doc;

  /**
   * Sets the Document instance by connecting to the specified URL.
   *
   * @param url The URL of the web page.
   * @throws IOException if an I/O error occurs during the connection.
   */
  private void setDocByUrl(String url) throws IOException {
    doc = Jsoup.connect(url).get();
  }

  /**
   * Sets the Document instance by parsing the specified local HTML file.
   *
   * @param filePath The path to the local HTML file.
   * @throws IOException if an I/O error occurs during parsing.
   */
  private void setDocByFilePath(String filePath) throws IOException {
    File input = new File(filePath);
    doc = Jsoup.parse(input, "UTF-8");
  }

  /**
   * Constructs a new WebConnector. Initializes the Document instance with 
   * the specified URL, falling back to a local HTML file if the connection fails.
   *
   * @param url The URL of the web page.
   * @param fallbackFilePath The path to the local HTML file to be used if the URL is inaccessible.
   * @throws IOException if an I/O error occurs during the connection or parsing.
   */
  public WebConnector(String url, String fallbackFilePath) throws IOException {
    try {
      this.setDocByUrl(url);
    } catch (IOException e) {
      this.setDocByFilePath(fallbackFilePath);
    }
  }

  /**
   * Constructs a new WebConnector. Initializes the Document instance by parsing 
   * the specified local HTML file.
   *
   * @param filePath The path to the local HTML file.
   * @throws IOException if an I/O error occurs during parsing.
   */
  public WebConnector(String filePath) throws IOException {
    this.setDocByFilePath(filePath);
  }

  /**
   * Retrieves the Document object representing the web page or local HTML file.
   *
   * @return The Document object.
   */
  public Document getDoc() {
    return doc;
  }
}
