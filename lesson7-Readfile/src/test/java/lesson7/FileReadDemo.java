package lesson7;

import org.junit.Test;
import java.io.*;


public class FileReadDemo {

    // Тест на чтение
    @Test
    public void readFileContext() throws IOException {
        try (InputStream input = new BufferedInputStream(new FileInputStream("tmp/lorem.txt"))) {
            byte[] buffer = new byte[1024];
            for (int length = 0; (length = input.read(buffer)) != -1; ) {
                System.out.write(buffer, 0, length);
            }
        }
    }

    // Тест на запись в файл построчно с консоли
    @Test
    public void writeFileContext() throws IOException {

        //Имитация консольного ввода со строками This is string1,2,3 для работы теста
        InputStream input = new ByteArrayInputStream("This is string1\nThis is string2\nThis is string3".getBytes());
        byte[] buffer = new byte[1024];

        File targetFile = new File("tmp/test.txt");
        OutputStream outStream = new FileOutputStream(targetFile);
        for (int length = 0; (length = input.read(buffer)) != -1; ) {
            outStream.write(buffer, 0, length);
        }
    }
}
