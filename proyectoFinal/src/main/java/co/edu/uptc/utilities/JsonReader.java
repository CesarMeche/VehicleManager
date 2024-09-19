package co.edu.uptc.utilities;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.edu.uptc.dynamic.SimpleList;
import co.edu.uptc.pogos.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class JsonReader {
    private String source;

    public SimpleList read() {

        return intanceVehicles(intanceArray());

    }

    public SimpleList intanceVehicles(Root root) {
        int c;
        SimpleList<Vehicle> vl = new SimpleList<>();
        SimpleList<String> att = new SimpleList<>();
        int a=0;
        for (List<Object> element : root.data) {
            c = 0;
            
            att = new SimpleList<>();
            for (Object elm : element) {
                if (c > 7 && c < 25) {
                    att.add((String) elm);
                }
                c++;
            }
            vl.add(new Vehicle(att));
            
        }
        return vl;
    }

    public Root intanceArray() {

        try {

            URI uri = new URI(source);
            URL url = uri.toURL();

            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

            StringBuilder result = new StringBuilder();
            String linea;

            while ((linea = reader.readLine()) != null) {
                result.append(linea);
            }

            ObjectMapper om = new ObjectMapper();
            Root root = om.readValue(result.toString(), Root.class);
            reader.close();
            return root;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
