package day6;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Path;
import java.nio.file.Paths;

public class cookieClienthandler implements Runnable{
    private final Socket socket;
    public cookieClienthandler(Socket socket){this.socket = socket;}

@Override
public void run() {

    Path p = Paths.get("C:\\Users\\keldr\\OneDrive\\Desktop\\gitfolder\\Workshop 4\\demo2\\day\\src\\main\\java\\day4\\Cookie.txt");
    File file = p.toFile();

    try(InputStream is = socket.getInputStream()){
    BufferedInputStream bis = new BufferedInputStream(is);
    DataInputStream dis = new DataInputStream(bis);
    OutputStream os = socket.getOutputStream();
    BufferedOutputStream bos = new BufferedOutputStream(os);
    DataOutputStream dos = new DataOutputStream(bos);

    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

    String line = ""; 
    String msg ="";
    String stringofwords = "";

    while (!line.equals("close")){
        line = dis.readUTF();
        if (line.equals("get-cookie")){
        stringofwords = cookie.readFile(file);
        msg = cookie.randomwords(stringofwords);
        dos.writeUTF(msg+"cookie-text");
        dos.flush();
        }
    }
    dis.close();
    socket.close();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
  }
    // TODO Auto-generated method stub
    
}
