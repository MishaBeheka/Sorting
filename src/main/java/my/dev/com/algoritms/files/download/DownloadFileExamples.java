package my.dev.com.algoritms.files.download;

import org.apache.commons.io.FileUtils;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class DownloadFileExamples {

    public static final String FILE_URL = "https://spring-boot-aws-revievers.s3.eu-central-1.amazonaws.com/Reviews.csv";

    public static final String PATH_TO_IO_WAY_FILE = "src/main/resources/IO_WAY_FILE.csv";
    public static final String PATH_TO_NIO_FILES_COPY_WAY_FILE = "src/main/resources/NIO_FILES_COPY_WAY_FILE.csv";
    public static final String PATH_TO_NIO_CHANNEL_WAY_FILE = "src/main/resources/NIO_CHANNEL_FILE.csv";
    public static final String PATH_TO_COMMONS_IO_FILE = "src/main/resources/COMMONS_IO_FILE.csv";

    public static void main(String[] args) {
        downloadFileByStream(FILE_URL, PATH_TO_IO_WAY_FILE);
        downloadFileByFilesCopy(FILE_URL, PATH_TO_NIO_FILES_COPY_WAY_FILE);
        downloadFileByNIO(FILE_URL, PATH_TO_NIO_CHANNEL_WAY_FILE);
        downloadByApacheCommonsIO(FILE_URL, PATH_TO_COMMONS_IO_FILE);



    }

    // 1. Using Java IO
    private static void downloadFileByStream(String sourceUrl, String localFilePath) {

        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new URL(sourceUrl).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(localFilePath)) {

            byte[] bytesBuffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = bufferedInputStream.read(bytesBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(bytesBuffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 2. Using Java NIO Files.copy()
    private static void downloadFileByFilesCopy(String sourceUrl, String localFilePath) {

        try (InputStream inputStream = URI.create(sourceUrl).toURL().openStream()) {
            Files.copy(inputStream, Paths.get(localFilePath), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 3. Using Java NIO Channels
    private static void downloadFileByNIO(String sourceUrl, String localFilePath) {

        try (ReadableByteChannel readableByteChannel = Channels.newChannel(new URL(sourceUrl).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(localFilePath)) {
            fileOutputStream.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 4. Using apache-commons-io
    private static void downloadByApacheCommonsIO(String sourceUrl, String localFilePath) {

        try {
            FileUtils.copyURLToFile(URI.create(sourceUrl).toURL(), Paths.get(localFilePath).toFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
