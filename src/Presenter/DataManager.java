package Presenter;

public class DataManager
{
    public static String readDataFile(String filename)
    {
        FileInputStream fileInputStream = new FileInputStream(filename);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Object data = objectInputStream.readObject();
        objectInputStream.close();
        return data;
    }

    public static void writeDataFile(String filename, Object data)
    {
        FileOutputStream adminAccountListFile = new FileInputStream(filename);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(adminAccountListFile);
        objectOutputStream.writeObject(data);
        objectOutputStream.close();
    }
}