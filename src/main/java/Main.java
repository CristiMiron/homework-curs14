import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {


        QuoteService quoteService = new QuoteService(List.of(
                new Quote(1,"Lao Tzu","Doing nothing is better than being busy doing nothing.",false),
                new Quote(2,"Buddha","Work out your own salvation. Do not depend on others.",false),
                new Quote(3,"Larry Elder","A goal without a plan is just a wish.",false)
        ));
        System.out.println(quoteService.readQuotesFromFile());

        System.out.println(quoteService.getAllQuotes());
        System.out.println(quoteService.getQuotesForAuthor("Buddha"));
        System.out.println(quoteService.getAuthors());
        System.out.println(quoteService.setFavourite(1));
        System.out.println(quoteService.setFavourite(3));
        System.out.println(quoteService.setFavourite(4));
        System.out.println(quoteService.getFavourites());


    }
    private static void readFullFile() throws Exception {
        Scanner fileScanner = new Scanner(new File("files/quotes.txt"));

        while(fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            System.out.println(line);
        }

    }
}
