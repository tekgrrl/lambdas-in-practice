package org.arw.examples;

import java.util.function.Function;
import java.util.stream.Stream;
import java.awt.Color;

public class Camera {

    private Function<Color, Color> colorFilter;

    public Camera() {
        // Effectively set no filters on initialization
        setColorFilters();
    }

    public Color capture(final Color inputColor) {
        final Color processedColor = colorFilter.apply(inputColor);
        // ... more procressing if needed
        return processedColor;
    }

    // takes a varargs of functions, and then wires them together using the reduce()
    // function which is an interesting hack
    public void setColorFilters(final Function<Color, Color>... filters) {
        colorFilter = Stream.of(filters)
                .reduce((aColorFilter, next) -> aColorFilter.compose(next))
                .orElse(color -> color); // reduce returns an Optional of the type of the Stream
                                         // which is Function. This default function just returns
                                         // the Color object that's the input parameter
    }

}
