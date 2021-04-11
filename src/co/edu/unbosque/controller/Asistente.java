package co.edu.unbosque.controller;

import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Asistente implements Runnable {

    public static void main(String[] Args) throws Exception {
        new Asistente();
    }
    public Asistente(){
        run();
    }

    public void run() {

        try (var socket = new Socket("127.0.0.2", 59897)) {

            System.out.println("Connected: " + socket);
            System.out.println("Enter the message to be capitalized...");

            var scanner = new Scanner(System.in);
            var in = new Scanner(socket.getInputStream());
            var out = new PrintWriter(socket.getOutputStream(), true);


            while (scanner.hasNextLine()) {
                out.println(scanner.nextLine());
                System.out.println("Usuario: " + in.nextLine());
            }
        }catch (Exception e){

        }
    }
}
