package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ServidorUDP {
    public static void main(String[] args) {
        int PUERTO = 7777;
        byte[] buffer = new byte[1024]; //tamaño de info que puedo enviar

        try {
            System.out.println("Servidor iniciado");
            DatagramSocket socketUDP = new DatagramSocket(PUERTO);

            DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);
            socketUDP.receive(peticion);

            String mensaje = new String(peticion.getData());
            System.out.println(mensaje);

            //extra para mostrar el puerto y direccion desde donde contactan
            int puertoCliente = peticion.getPort();
            InetAddress direccionCliente = peticion.getAddress();
            System.out.println("Puerto del Cliente: "+puertoCliente+
                    "\nDireccion del Cliente: "+direccionCliente);
            System.out.println();
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
