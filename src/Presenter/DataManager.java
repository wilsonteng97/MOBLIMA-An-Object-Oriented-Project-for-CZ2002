package Presenter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class DataManager
{
    public static String readDataFile(String filename)
    {
        FileInputStream fileInputStream = new FileInputStream(filename);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Object data = objectInputStream.readObject();
        objectInputStream.close();
        return (String) data;
    }

    public static void writeDataFile(String filename, Object data)
    {
        FileInputStream adminAccountListFile = new FileInputStream(filename);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(adminAccountListFile);
        objectOutputStream.writeObject(data);
        objectOutputStream.close();
    }
}