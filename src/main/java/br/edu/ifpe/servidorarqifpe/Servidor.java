/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.servidorarqifpe;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 *
 * @author gon
 */
public class Servidor {

    public static void main(String[] args) throws IOException {
        ServerSocket servidor = new ServerSocket(32154);
        System.out.println("Porta 32154 aberta!");
        while (true) {

            Socket cliente = servidor.accept();
            System.out.println("Nova conexão com o cliente "
                    + cliente.getInetAddress().getHostAddress());

            Scanner s = new Scanner(cliente.getInputStream());
            while (s.hasNextLine()) {
                String escrita = s.nextLine();
                if (escrita.equals("sair")) {
                    break;
                }
                System.out.println(escrita);
            }

            s.close();
            servidor.close();
            cliente.close();
        }
    }

}
