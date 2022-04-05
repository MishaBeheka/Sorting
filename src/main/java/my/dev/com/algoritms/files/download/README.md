# <h1> Download file by URL. JAVA examples. 4 ways

<hr>


## 1. Download file by Java IO
  * Details:
    * The most basic API we can use to download a file is Java IO. We can use the URL class to open a connection to the file we want to download.
    * To effectively read the file, we'll use the `openStream()` method to obtain an InputStream:
    ```java
    BufferedInputStream in = new BufferedInputStream(new URL(FILE_URL).openStream())
     ```
    * When reading from an InputStream, it's recommended to wrap it in a BufferedInputStream to increase the performance.


<hr>


## 2. Download file by Java NIO `Files.copy()`
   * Details:
     * Starting from Java 7, we have the Files class that contains helper methods for handling IO operations. We can use the `Files.copy()` method to read all the bytes from an InputStream and copy them to a local file: 
      ```java
       InputStream inputStream = URI.create(sourceUrl).toURL().openStream();
       Files.copy(inputStream, Paths.get(localFilePath), StandardCopyOption.REPLACE_EXISTING);
     ```

<hr>


## 3. Download file by Java NIO Channels
 * Details:
   * The Java NIO package offers the possibility to transfer bytes between two channels without buffering them into the application memory.
   * To read the file from our URL, we'll create a `new ReadableByteChannel` from the URL stream:
    
    ```java
    ReadableByteChannel readableByteChannel = Channels.newChannel(new URL(sourceUrl).openStream());
    ```

   * The bytes read from the `ReadableByteChannel` will be transferred to a `FileChannel` corresponding to the file that will be downloaded, after then we'll use the `transferFrom()` method from the `ReadableByteChannel` class to download the bytes from the given URL to our `FileChannel`:
    ```java
    FileOutputStream fileOutputStream = new FileOutputStream(localFilePath);
    fileOutputStream.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
    ```
   * The `transferTo()` and `transferFrom()` methods are more efficient than simply reading from a stream using a buffer. Depending on the underlying operating system, the data can be transferred directly from the filesystem cache to our file without copying any bytes into the application memory.


<hr>


## 4. Download file by apache-commons-io
* Details:
    * Add dependency to `pom.xml`
```java
<dependency>
    <groupId>commons-io</groupId>
    <artifactId>commons-io</artifactId>
    <version>2.11.0</version>
</dependency>
```

### NOTE. The code was written based on material from the resource:
* [baeldung.com](https://www.baeldung.com/java-download-file)


