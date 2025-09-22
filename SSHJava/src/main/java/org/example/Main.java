package org.example;

import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner lectura = new Scanner(System.in);
        String usuario, servidor,contrasena;

        System.out.println("Introduce el Usuario: ");
        usuario = lectura.next();

        System.out.println("Introduce la dir ip: ");
        servidor = lectura.next();

        System.out.println("Introduce la contraseña del servidor: ");
        contrasena = lectura.next();

        Ssh.sshConnector(usuario,servidor,contrasena);

    }
}