package com.vitvn183.demouploadfile.configs;

import org.json.*;
import org.springframework.stereotype.Component;

@Component
public class ConvertXMLToJson {
    public static String xml = "<?xml version=\"1.0\" ?><root><test       attribute=\"text1\">javatpoint</test><test attribute=\"text2\">JTP</test></root>";

    public static void main() {
// TODO Auto-generated method stub
        try {
            JSONObject json = XML.toJSONObject(xml);
            String jsonString = json.toString(4);
            System.out.println(jsonString);

        } catch (JSONException e) {
// TODO: handle exception
            System.out.println(e.toString());
        }

    }
}
