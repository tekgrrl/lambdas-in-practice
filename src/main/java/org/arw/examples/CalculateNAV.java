package org.arw.examples;

import java.math.BigDecimal;
import java.util.function.Function;

public class CalculateNAV {

    public CalculateNAV(Function<String, BigDecimal> priceFinder) {
        this.priceFinder = priceFinder;
    }

    private Function<String, BigDecimal> priceFinder;
    
    public BigDecimal computeStockWorth(final String ticker, final int shares) {
        return priceFinder.apply(ticker).multiply(BigDecimal.valueOf(shares));
    }

    public static void main(String... args) {
        final CalculateNAV usingWebService = new CalculateNAV(YahooFinance::getPrice);
    }
}
