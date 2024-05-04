package com.ernestdev;

import com.ernestdev.models.RequestConversion;
import com.ernestdev.request.api.RequestApi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //AP_Key=ca5f35709e13243ec62bdfa4
        int option =0;
        RequestApi request =new RequestApi();
        Scanner read = new Scanner(System.in);



        while(option !=7){
            System.out.println("""
                    1) Dólar => Peso Argentino
                    2) Peso Argentino => Dólar
                    3) Dólar => Real Brasileño
                    4) Real Brasileño => Dólar
                    5) Dólar => Peso Colombiano
                    6) Peso Colombiano => Dólar
                    7) Salir
                    Elija una opcion válida:
                    """);
            option = read.nextInt();

            switch (option){
                case 1:
                    request.conversion(request.conectionRequestApi("USD","ARS"));
                    break;
                case 2:
                    request.conversion(request.conectionRequestApi("ARS","USD"));
                    break;
                case 3:
                    request.conversion(request.conectionRequestApi("USD","BRL"));
                    break;
                case 4:
                    request.conversion(request.conectionRequestApi("BRL","USD"));
                    break;
                case 5:
                    request.conversion(request.conectionRequestApi("USD","COP"));
                    break;
                case 6:
                    request.conversion(request.conectionRequestApi("COP","USD"));
                    break;
                default:
                    System.out.println("Seleccione una opcion valida");
            }
            System.out.println("************************************************");
        }
    }
}
