package org.arw.examples;

import java.awt.Color;
import java.util.function.Consumer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        final Camera camera = new Camera();

        final Consumer<String> printCaptured = (filterInfo) -> 
            System.out.println(String.format("with %s: %s", filterInfo, 
              camera.capture(new Color(200, 100, 200))));

              camera.setFilters((Color::brighter));
              printCaptured.accept("brighter filter");

              camera.setFilters(Color::darker);
              printCaptured.accept("darker filter");

              camera.setFilters(Color::brighter, Color::brighter);
              printCaptured.accept("brighter and darker filters");
    }
}
