package org.example;

import java.util.Random;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        Random generador= new Random();

        Boolean esAdministrador;
        String respuestaPerfil;
        Double tarifaEnergia;
        Integer opcion;
        final String contraseña="admin123*";
        String contrasenaUsuario;
        Integer contadorEnergia=0;


        System.out.println("Bienvenido");
        System.out.print("Eres administrador: ");
        respuestaPerfil=teclado.nextLine();

        //PROCESO PARA EL LOGIN
        if(respuestaPerfil.equalsIgnoreCase("si")){
            //admin y me van a pedir la contraseña
            System.out.print("Digita tu contraseña: ");
            contrasenaUsuario=teclado.nextLine();
            //COMPARMOS LA CONTRASEÑA QUE ESCRIBIERON CON LA CONSTANTE ALMACENADA
            if(contrasenaUsuario.equals(contraseña)){
                //FELICITACIONES USTED ES ADMINISTRADOR
                System.out.println("Usted es un admin");
                //puedo actulizar la tarifa de energia
                System.out.print("Ingresa el valor de KWH: ");
                tarifaEnergia=teclado.nextDouble();
                System.out.println("La tarifa de energia quedo en: $"+tarifaEnergia);

                //GENERANDO DATOS PARA UNA EMPRESA
                //generar un ciclo que de 30 vueltas
                Integer numeroVueltas=0; //contador
                Integer contadorDePicos=0;
                do{
                    numeroVueltas=numeroVueltas+1;
                    Integer numeroGenerado=generador.nextInt(400)+1;
                    contadorEnergia=contadorEnergia+numeroGenerado;
                    if(numeroGenerado>300){
                        System.out.println("pico detectado");
                        contadorDePicos=contadorDePicos+1;
                    }else{
                        System.out.println("operando normalmente");
                    }

                }while(numeroVueltas<30);
                System.out.println(numeroVueltas);
                System.out.println(contadorDePicos);

                //MENU
                System.out.println("1. ver tarifa");
                System.out.println("2. mostrar consumo promedio");
                System.out.println("3. mostrar consumo picos");
                System.out.println("4. mostrar factura");
                System.out.println("5. SALIR");

                //repitiendo el menu
                do{
                    System.out.print("Apreciado cliente, digita una opcion: ");
                    opcion=teclado.nextInt();

                    switch (opcion){
                        case 1:
                            System.out.println("La tarifa KWH es: "+tarifaEnergia);
                            break;
                        case 2:
                            System.out.println("El consumo total fue: "+contadorEnergia);
                            Double promedioConsumo=contadorEnergia/30.0;
                            System.out.println("el consumo promedio es: "+promedioConsumo);
                            break;
                        case 3:
                            System.out.println("la cantidad de picos fue: "+contadorDePicos);
                            break;
                        case 4:
                            System.out.println("EL resumen de tu factura es: ");
                            Double totalApagar=contadorEnergia*tarifaEnergia;
                            System.out.println("$...... "+totalApagar);
                            break;
                            default:
                                System.out.println("opcion invalida");
                                break;


                    }

                }while(opcion!=5);



            }else{
                System.out.println("Usted es un hacker....");
            }

        }else{
            //empresa
            System.out.println("usted es una empresa");
        }


    }
}