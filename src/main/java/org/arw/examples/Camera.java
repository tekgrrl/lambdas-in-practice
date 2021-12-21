package org.arw.examples;

import java.util.function.Function;
import java.util.stream.Stream;
import java.awt.Color;

public class Camera {

    private Function<Color, Color> filter;

    public Camera() {
        setFilters();
    }

    public Color capture(final Color inputColor) {
        final Color processedColor = filter.apply(inputColor);
        // ... more procressing
        return processedColor;
    }

    public void setFilters(final Function<Color, Color>... filters) {
        filter = Stream.of(filters)
                       .reduce((filter, next) -> filter.compose(next))
                       .orElse(color -> color); // reduce returns an Optional of the type of the Stream
                                                // which is Function. This default function just returns
                                                // the Color object that's the input parameter
    }

    
}
