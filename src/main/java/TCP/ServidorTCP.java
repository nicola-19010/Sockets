package TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServidorTCP {
    public static void main(String[] args) {
        ServerSocket servidor;
        Socket sc;
        DataInputStream in;
        DataOutputStream out;
        int PUERTO = 6666;


        try {
            servidor = new ServerSocket(PUERTO);
            System.out.println("Servidor iniciado");

            while (true){
                sc = servidor.accept();

                System.out.println("---Cliente conectado---");
                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());


                String mensaje = in.readUTF();
                System.out.println(mensaje);

                sc.close();
                System.out.println("---Cliente desconectado---");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

