package org.arw.examples;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;

public class YahooFinance {
    public static final BigDecimal getPrice(final String ticker) {
        try {
            // Yahoo! ended this service 
            final URL url =
                new URL("https://ichart.finance.yahoo.com/table.csv?s=" + ticker);
            
            final BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            final String data = reader.lines().skip(1).findFirst().get();
            final String[] dataItems = data.split(", ");

            return new BigDecimal(dataItems[dataItems.length - 1]);
        } catch(Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
