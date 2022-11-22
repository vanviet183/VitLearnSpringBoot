package com.vitvn183.demouploadfile.utils;

import org.json.JSONObject;
import org.json.XML;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class ReadFile {
    public static String convertXmlToJson(String fileName) throws IOException {
        Unzip unzip = new Unzip();
        String sourceFile = "E:\\Self_Learning\\VitLearnSpringBoot\\DemoUploadFile\\" + fileName;
        File file = new File(sourceFile);
        InputStream inputStream = unzip.getStreamDocumentXml(file);
        String text = new BufferedReader(
                new InputStreamReader(inputStream, StandardCharsets.UTF_8))
                .lines()
                .collect(Collectors.joining("\n"));
        System.out.println(text);


        JSONObject jsonObject = XML.toJSONObject(text);
        String jsonString = jsonObject.toString(4);
        System.out.println(jsonString);
        return jsonString;
    }
}
