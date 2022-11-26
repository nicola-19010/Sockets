package TCP;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteTCP {
    public static void main(String[] args) {
        DataInputStream in;
        DataOutputStream out;
        String HOST = "127.0.0.1"; //para nuestro dispositivo
        int PUERTO = 6666;


        try{
            Socket sc = new Socket(HOST, PUERTO);

            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());


                System.out.print("Ingrese un mensaje:");
                String mensaje = in.readLine();
                out.writeUTF(mensaje);
                sc.close();


        }catch (IOException ex){
            Logger.getLogger(ClienteTCP.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
