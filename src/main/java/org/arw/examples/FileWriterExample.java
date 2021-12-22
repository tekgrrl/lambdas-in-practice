package org.arw.examples;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {
    private final FileWriter writer;

    public FileWriterExample(final String filename) throws IOException {
        writer = new FileWriter(filename);
    }

    public void writeStuff(final String message) throws IOException {
        writer.write(message);
    }

    public void close() throws IOException {
        writer.close();
    }

    public static void main(String... args) throws IOException {
        final FileWriterExample writerExample = new FileWriterExample("peekaboo.txt");
        try {
            writerExample.writeStuff("peek-a-boo");
        } finally {
            writerExample.close();
        }

        try(final FileWriterARM writerARM = new FileWriterARM("peekaboo.txt")) {
            writerARM.writeStuff("peek-a-boo");

            System.out.println("done with the resource");
        }
    }
    
}
