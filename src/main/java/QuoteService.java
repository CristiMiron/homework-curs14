import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuoteService {

    List<Quote> quotes = new ArrayList<>();

    public QuoteService(List<Quote> quotes) {
        if (quotes != null) {
            this.quotes.addAll(quotes);
        }
    }


    public List<Quote> readQuotesFromFile() throws Exception {
        List<Quote> quotes = new ArrayList<>();
        BufferedReader fileReader = new BufferedReader(new FileReader("files/quotes.txt"));
        String line;
        while ((line = fileReader.readLine()) != null) {
            quotes.add(readQuotes(line));
        }
        return quotes;
    }

    private static Quote readQuotes(String quotesInfo) {
        String[] quotesData = quotesInfo.split("~");

        String author = quotesData[0];
        String quote = quotesData[1];

        int id = 0;

        return new Quote(id, author, quote, false);
    }

    public List<String> getAllQuotes() {
        List<String> result = new ArrayList<>();
        for (Quote quote : quotes) {
            result.add(quote.getQuote());
        }
        return result;
    }

    public List<Quote> getQuotesForAuthor(String author) {
        List<Quote> result = new ArrayList<>();
        for (Quote quote : quotes) {
            if (quote.getAuthor().equals(author)) {
                result.add(quote);
            }
        }
        return result;
    }

    public List<String> getAuthors() {
        List<String> result = new ArrayList<>();
        for (Quote quote : quotes) {
            result.add(quote.getAuthor());
        }
        return result;
    }

    public boolean setFavourite(int id) {
        for (Quote quote : quotes) {
            if (quote.getId() == id) {
                quote.setFavourite(true);
                System.out.println("Id " + id + " is Favourite");
                return true;
            }
        }
        return false;
    }

    public List<Quote> getFavourites() {
        List<Quote> result = new ArrayList<>();
        for (Quote quote : quotes) {
            if (quote.isFavourite() == true) {
                result.add(quote);
            }
        }
        return result;
    }

}
