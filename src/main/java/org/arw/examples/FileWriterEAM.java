package org.arw.examples;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterEAM {
    private final FileWriter writer;

    private FileWriterEAM(final String filename) throws IOException {
        writer = new FileWriter(filename);
    }

    public void writeStuff(final String message) throws IOException {
        writer.write(message);
    }

    private void close() throws IOException {
        System.out.println("close() called automatically");
        writer.close();
    }

    public static void use(final String filename, final UseInstance<FileWriterEAM, IOException> block) throws IOException {
        final FileWriterEAM writerEAM = new FileWriterEAM(filename);

        try {
            block.accept(writerEAM);
        } finally {
            writerEAM.close();
        }

    }
}
