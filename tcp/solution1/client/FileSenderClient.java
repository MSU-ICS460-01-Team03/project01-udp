import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.net.Socket;
import java.net.UnknownHostException;

public class FileSenderClient {
    public final static int PORT = 3456;
    public final static String hostname = "localhost";

    // public static void main(String[] args) {
    // Socket sock = null;
    // try {
    // sock = new Socket(hostname, PORT);
    // System.out.println("connected.");
    // String fileName = "TestFile.txt";
    // File file = new File(fileName);
    // int fileSize = (int) file.length();
    // OutputStream os = sock.getOutputStream();
    // PrintWriter pr = new PrintWriter(sock.getOutputStream(), true);
    // BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
    // Scanner in = new Scanner(sock.getInputStream());

    // pr.println(fileName);
    // pr.println(fileSize);
    // byte[] fileByte = new byte[fileSize];
    // bis.read(fileByte, 0, fileByte.length);
    // os.write(fileByte, 0, fileByte.length);
    // System.out.println(in.nextLine());
    // os.flush();
    // sock.close();
    // bis.close();
    // } catch (IOException ex) {
    // ex.printStackTrace();
    // }
    // }

    @SuppressWarnings("resource")
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket sock = new Socket("localhost", 3456);
        String FileName = "TestFile.txt";
        File MyFile = new File(FileName);
        int FileSize = (int) MyFile.length();
        OutputStream os = sock.getOutputStream();
        PrintWriter pr = new PrintWriter(sock.getOutputStream(), true);
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(MyFile));
        Scanner in = new Scanner(sock.getInputStream());

        pr.println(FileName);
        pr.println(FileSize);
        byte[] filebyte = new byte[FileSize];
        bis.read(filebyte, 0, filebyte.length);
        os.write(filebyte, 0, filebyte.length);
        System.out.println(in.nextLine());
        os.flush();
        sock.close();
    }
}
