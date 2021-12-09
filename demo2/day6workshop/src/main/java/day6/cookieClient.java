package day6;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter; 
import java.net.Socket;
import java.net.UnknownHostException;

public class cookieClient {
    static PrintWriter out = null;
    static BufferedReader in = null;
  
    public static void main(String[] args) throws UnknownHostException, IOException,EOFException {
      Socket socket = new Socket("localhost",12345);

        try(OutputStream os = socket.getOutputStream()){
          BufferedOutputStream bos = new BufferedOutputStream(os);
          DataOutputStream dos = new DataOutputStream(bos);
          InputStream is = socket.getInputStream();
          BufferedInputStream bis = new BufferedInputStream(is);
          DataInputStream dis = new DataInputStream(bis);
          String line = "";
          String msg = "";
          BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

          while (!line.equals("close")){
            line = br.readLine();
            dos.writeUTF(line);
            dos.flush();
            msg = dis.readUTF();
            System.out.println("cookie-text");
            System.out.println("Server says "+msg);
          }

          dos.close();
          socket.close();
    }
  }
}
