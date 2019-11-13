package Presenter;

public class DataManager
{
    public static List<String> readFileInList(String fileName) 
  { 
  
    List<String> lines = Collections.emptyList(); 
    try
    { 
      lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8); 
    } 
  
    catch (IOException e) 
    { // do something 
      e.printStackTrace(); 
    } 
        return lines; 
  } 

    public static void writeDataFile(String filename, Object data)
    {
        FileOutputStream adminAccountListFile = new FileInputStream(filename);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(adminAccountListFile);
        objectOutputStream.writeObject(data);
        objectOutputStream.close();
    }
}