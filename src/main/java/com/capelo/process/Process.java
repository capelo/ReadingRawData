package com.capelo.process;

import com.capelo.pojo.Bank;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.json.simple.JSONObject;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Process {

    private List<Bank> inputList = new ArrayList<>();
    private String fileName= "data.csv";

    private void export(String fileName) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        mapper.writeValue(new FileOutputStream("/Users/robertocapelo/Desktop/java/ReadingRawData/src/main/resources/data.json"), inputList);
    }


    public void readData(){


        Pattern pattern = Pattern.compile(",");

        try {
            File file = new File(
                    getClass().getClassLoader().getResource(fileName).getFile()
            );

            InputStream fis = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));

            inputList = br.lines()
                        .skip(1)
                        .map(line -> {
                            String[] x = pattern.split(line);
                            return new Bank(x[4], x[6]);
                        })
                        .collect(Collectors.toList());

            inputList.stream()
                    .forEach(System.out::println);


            export("data.json");


            br.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
