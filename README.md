# FloraFaunaWeb Scraper

This repository contains a simple yet functional web scraper specifically tailored for extracting plant of the month, animal of the month, and "did you know" facts from [National Parks Board, Singapore](https://www.nparks.gov.sg/FloraFaunaWeb). It can also scrape event information from [here](https://www.nparks.gov.sg/activities/events-and-workshops).

## Project Structure
The project is written in Java with Gradle as the build tool. The main application files are located within the `app/src/main/java/scraper` directory. The application's entry point is in the `App.java` file located in the same directory.

## Usage

A typical use case of the web scraper can be as follows:

```java
/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package scraper;

import java.io.IOException;

public class App {
  public static void main(String[] args) throws IOException {
    final FFWInfo ffwInfo = new FFWInfo();
    System.out.println(ffwInfo.getPlantOfTheMonth());
    System.out.println(ffwInfo.getAnimalOfTheMonth());
    ffwInfo.getDidYouKnowFacts().forEach(System.out::println);

    final EventInfo eventInfo = new EventInfo();
    eventInfo.getEvents().forEach(System.out::println);
  }
}
```

The above sample code showcases how to instantiate the `FFWInfo` and `EventInfo` objects and use their methods to fetch and print the desired information.

## Disclaimer
Please note that while this tool can assist in gathering information, it is recommended to use it responsibly and adhere to the terms of service of the website being scraped. Also, it is not guaranteed to work if the website's structure changes.

## Contribution
Feel free to fork this repository, make some changes, and submit pull requests. While this tool is simple, there's always room for improvement!

## License
This project is open-source and available under the [MIT License](LICENSE).