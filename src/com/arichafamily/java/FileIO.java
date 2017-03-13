package com.arichafamily.java;

import java.io.*;

public class FileIO {

    public static void write(String fileName, String data) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName, true);
            fileWriter.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            Close(fileWriter);
        }
    }

    public static String read(String fileName) {
        BufferedReader reader = null;
        try {
            StringBuilder builder = new StringBuilder();
            reader = new BufferedReader(new FileReader(fileName));
            String line = null;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            return (builder.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            Close(reader);
        }
        return null;
    }

    private static void Close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

