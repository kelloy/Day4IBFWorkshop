
package day6;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class cookieServer {
    public static void main(String[] args) throws IOException,EOFException{
        ExecutorService threadPool= Executors.newFixedThreadPool(3);
        ServerSocket server = new ServerSocket(12345);
        while (true){
            Socket socket= server.accept();
            cookieClienthandler worker = new cookieClienthandler(socket);
            threadPool.submit(worker);
        }
    }
}



