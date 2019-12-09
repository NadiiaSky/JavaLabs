package ua.procamp.lab4;

import ua.procamp.exception.FileReaderException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * {@link FileReaders} privides an API that allow to read whole file into a {@link String} by file name.
 */
class FileReaders {
    /**
     * Returns a {@link String} that contains whole text from the file specified by name.
     *
     * @param fileName a name of a text file
     * @return string that holds whole file content
     */
    public static String readWholeFile(String fileName) {
        Path filePath = createPathFromFileName(fileName);
        try (Stream<String> fileLinesStream = openFileLinesStream(filePath)) {
            return fileLinesStream.collect(Collectors.joining("\n"));
        }
    }


    public static Path createPathFromFileName(String fileName) {
        Objects.requireNonNull(fileName);
        URL fileURL = FileReaders.class.getClassLoader().getResource(fileName);
        try {
            assert fileURL != null;
            return Paths.get(fileURL.toURI());
        } catch (URISyntaxException e) {
            throw new FileReaderException("Invalid file URL", e);
        }
    }

        private static Stream<String> openFileLinesStream(Path filePath) {
            try {
                return Files.lines(filePath);
            } catch (IOException e) {
               throw new FileReaderException("Cannot create stream of file lines!", e);
            }
        }
}
