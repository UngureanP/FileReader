package util;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;

public class JsonReader {

    public static <T> T getContent(String path, Class<T> classType) {
        BufferedReader reader = null;
        T object = null;

        try {
            reader = new BufferedReader(new FileReader(path));
            Gson gson = new Gson();
            object = gson.fromJson(reader, (Type) classType);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return object;
    }
}
