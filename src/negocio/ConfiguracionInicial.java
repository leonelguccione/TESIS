package negocio;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.OutputStreamWriter;
import java.io.Writer;

import java.nio.file.Files;
import java.nio.file.Paths;

import modelo.InfoItems;

public class ConfiguracionInicial
{
    private String archivoJson = "/media/leonel/DATOS/UNLP/000_TESIS_MAESTRIA/FRANCO-Juego-Version-GUILLE/2023_json/src/main/java/main/items_f.json"; 
    
    public ConfiguracionInicial(String archivo)
    {
        this.archivoJson = archivo;      
    }
    
    public InfoItems jSon2InfoItems() throws IOException
    {
        byte[] jsonData = Files.readAllBytes(Paths.get(archivoJson));
        ObjectMapper objectMapper = new ObjectMapper();
        InfoItems items = objectMapper.readValue(jsonData, InfoItems.class);
        return items;
    }
    
    public String infoItems2Json(InfoItems items) throws JsonProcessingException
    {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        items.setPlayerHealth(70.0);
        int[] z = { 5, 5, 5, 5, 50, 50, 50, 50, 50, 50 };
        items.setZombieDay(z);   
        String jsonString = objectMapper.writeValueAsString(items);        
        return jsonString;
    }
    
    
}
