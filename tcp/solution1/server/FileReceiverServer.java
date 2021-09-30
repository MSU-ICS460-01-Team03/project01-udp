
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class FileReceiverServer {
    public final static int PORT = 3456;

    // public static void main(String[] args) {
    // Socket sock;
    // Scanner in;
    // BufferedOutputStream bos;
    // try (ServerSocket serverSocket = new ServerSocket(PORT)) {
    // sock = serverSocket.accept();
    // in = new Scanner(sock.getInputStream());
    // InputStream is = sock.getInputStream();
    // PrintWriter pr = new PrintWriter(sock.getOutputStream(), true);
    // String fileName = in.nextLine();
    // int fileSize = in.nextInt();
    // FileOutputStream fos = new FileOutputStream(fileName);
    // bos = new BufferedOutputStream(fos);
    // byte[] fileByte = new byte[fileSize];
    // int fileLength = is.read(fileByte, 0, fileByte.length);
    // bos.write(fileByte, 0, fileLength);

    // System.out.println("Incoming File: " + fileName);
    // System.out.println("Size: " + fileSize + " Byte");
    // if (fileSize == fileLength) {
    // System.out.println("File is verified");
    // } else {
    // System.out.println("File is corrupted. File Recieved " + fileLength +
    // "Byte.");
    // pr.println("File Recieved Successfull.");
    // }
    // // in.close();
    // bos.close();
    // sock.close();
    // } catch (IOException ex) {
    // ex.printStackTrace();
    // }
    // }

    @SuppressWarnings("resource")
    public static void main(String[] args) throws IOException {
        ServerSocket servsock = new ServerSocket(3456);
        Socket sock = servsock.accept();
        Scanner in = new Scanner(sock.getInputStream());
        InputStream is = sock.getInputStream();
        PrintWriter pr = new PrintWriter(sock.getOutputStream(), true);
        String FileName = in.nextLine();
        int FileSize = in.nextInt();
        FileOutputStream fos = new FileOutputStream(FileName);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        byte[] filebyte = new byte[FileSize];

        int file = is.read(filebyte, 0, filebyte.length);
        bos.write(filebyte, 0, file);

        System.out.println("Incoming File: " + FileName);
        System.out.println("Size: " + FileSize + "Byte");
        if (FileSize == file)
            System.out.println("File is verified");
        else
            System.out.println("File is corrupted. File Recieved " + file + " Byte");
        pr.println("File Recieved SUccessfully.");
        bos.close();
        sock.close();
    }
}
