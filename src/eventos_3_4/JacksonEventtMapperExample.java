package eventos_3_4;

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

//import modelo.InfoJSONItems;

public class JacksonEventtMapperExample
{
    public static void main(String[] args) throws IOException
    {

        //read json file data to String
        byte[] jsonData =
            Files.readAllBytes(Paths.get("/media/leonel/DATOS/UNLP/000_TESIS_MAESTRIA/FRANCO-Juego-Version-GUILLE/2023_09_08_json_eventos/2023_json/e.json"));
        //System.out.println(jsonData.toString());

        //create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        //convert json string to object
        EventInfo eventInfo = objectMapper.readValue(jsonData, EventInfo.class);
        /*	EventInfo eventInfo=new EventInfo();
		Slot[] array=new Slot[3];
		array[0]=new Slot();
		array[1]=new Slot();
		array[2]=new Slot();
		eventInfo.setSlotsInfo(array);*/
        System.out.println("Evento \n" + eventInfo);

        //convert Object to json string

        //configure Object mapper for pretty print
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        //Prueba cambios

        eventInfo.setDayNumber(100);
        eventInfo.getSlotsInfo()[0].setTipo_combustible(56);


        //writing to console, can write to any output stream such as file
        Writer outFile = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("salidaEvent.json"), "UTF-8"));


        objectMapper.writeValue(outFile, eventInfo);

    }


}
