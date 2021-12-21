package org.arw.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Color;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CameraTest {
    @Test
    void testCapture() {
        Camera camera = new Camera();

        Color captured = camera.capture(new Color(200, 100, 200));
        assertEquals(-3644216, captured.getRGB());

    }

    @Test
    @DisplayName("Testing with single filter")
    void testSetSingleFilter() {
        Camera camera = new Camera();

        camera.setColorFilters(Color::brighter);
        Color captured = camera.capture(new Color(200, 100, 200));
        assertEquals(-28929, captured.getRGB());

    }

    @Test
    @DisplayName("Testing with chain of filters")
    void testSetChainedFilters() {
        Camera camera = new Camera();

        camera.setColorFilters(Color::brighter, Color::brighter);
        Color captured = camera.capture(new Color(200, 100, 200));
        assertEquals(-13569, captured.getRGB());

    }
}
