package main;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import java.nio.file.Files;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import modelo.InfoItems;

public class JacksonObjectMapperExample
{
    public static void main(String[] args) throws IOException
    {

        //read json file data to String
        //byte[] jsonData = Files.readAllBytes(Paths.get("items_f.json"));
        byte[] jsonData = Files.readAllBytes(Paths.get("/media/leonel/DATOS/UNLP/000_TESIS_MAESTRIA/FRANCO-Juego-Version-GUILLE/2023_json/src/main/java/main/items_f.json"));
        //System.out.println(jsonData.toString());

        //create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        //convert json string to object
        InfoItems items = objectMapper.readValue(jsonData, InfoItems.class);

        System.out.println("Items \n" + items);

        //convert Object to json string

        //configure Object mapper for pretty print
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        //Prueba cambios


        items.setPlayerHealth(70.0);
        int[] z = { 5, 5, 5, 5, 50, 50, 50, 50, 50, 50 };
        items.setZombieDay(z);

        //writing to console, can write to any output stream such as file
        Writer outFile = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/media/leonel/DATOS/UNLP/000_TESIS_MAESTRIA/FRANCO-Juego-Version-GUILLE/2023_json/src/main/java/main/salida2.json"), "UTF-8"));


        objectMapper.writeValue(outFile, items);

    }


}
