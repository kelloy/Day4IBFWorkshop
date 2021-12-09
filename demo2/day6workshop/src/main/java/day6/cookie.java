package day6;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class cookie {
    public static String readFile(File file) throws IOException {
    StringBuilder sb = new StringBuilder();
    String line;
    try (Reader reader= new FileReader(file)) {
        BufferedReader br = new BufferedReader(reader);
        while (null != (line = br.readLine()))
        sb.append(line).append("\n");
        }
        return sb.toString();
    }


public static String randomwords(String string){
    String[] arrayOfwords = string.trim().split("[\\s,+]");
    Random random = new Random(System.currentTimeMillis());
    int rn = random.nextInt(arrayOfwords.length);
    return arrayOfwords[rn];        
}

public static String removePrefix(String s, String prefix)
{
    if (s != null && prefix != null && s.endsWith(prefix)) {
        return s.substring(prefix.length());
    }
    return s;
}
}

