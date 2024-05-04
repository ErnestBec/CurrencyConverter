package com.ernestdev.request.api;

import com.ernestdev.models.RequestConversion;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class RequestApi {

    public RequestConversion conectionRequestApi(String firstSelection, String secondSelection){

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/ca5f35709e13243ec62bdfa4/pair/"+firstSelection+"/"+secondSelection))
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            //Transformacmos la respuesta a json
            return new Gson().fromJson(response.body(), RequestConversion.class);
            //System.out.println(response.body());
        } catch (Exception e) {
            throw new RuntimeException("No se puedo encontrar moneda de cambio...:(");
        }

    }
    public void conversion(RequestConversion dataConversion){
        Scanner read = new Scanner(System.in);
        double currencyValueConvert ;
        System.out.println("Ingrese el valor que desea convertir:");
        currencyValueConvert = read.nextDouble();
        System.out.println(currencyValueConvert+" "+
                dataConversion.base_code()+" Equivale a "+
                currencyValueConvert * dataConversion.conversion_rate()+" "+
               dataConversion.target_code());
    }

}
