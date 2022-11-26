package UDP;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ClienteUDP {
    public static void main(String[] args) {
        //Cliente no tiene puerto asigando por defecto
        //Servidor sí

        //Puerto y buffer definidos del Servidor
        int PUERTO_SERVIDOR = 7777;
        byte[] buffer = new byte[1024];


        try {
            InetAddress direccionServidor = InetAddress.getByName("localhost");
            DatagramSocket socketUDP = new DatagramSocket();

            Scanner teclado = new Scanner(System.in);
            System.out.print("Ingrese un mensaje: ");
            String mensaje = teclado.nextLine();
            buffer = mensaje.getBytes();

            DatagramPacket mensajeParaEnviar = new DatagramPacket(buffer, buffer.length,
                    direccionServidor, PUERTO_SERVIDOR);
            socketUDP.send(mensajeParaEnviar);

            socketUDP.close();

        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
