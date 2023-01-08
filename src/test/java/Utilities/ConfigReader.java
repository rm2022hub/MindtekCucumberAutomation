package Utilities;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    // we created this class to read data from Configuration.properties and to load the file.
    // private and static variables declared
  private static FileInputStream input;
  private static Properties properties;
  // using static block to initialize the static variables.
   static{
    String path =  System.getProperty("user.dir")+"/src/test/resources/configurations/Configuration.properties";
    try{
         input = new FileInputStream(path);
         properties= new Properties();
        properties.load(input);
    }catch (FileNotFoundException e){  // catch FileNotFoundException.
        System.out.println("Path for properties file is invalid");
    }catch (IOException e){ // catch Input/ output stream exception.
        System.out.println("Failed to load the properties file");
    }finally {
        try {
            assert input != null;
            input.close();
        } catch (IOException e) {
            System.out.println("Exception occurred while closing input object");
        }

    }

   }

public  static String getProperty(String key){
   return properties.getProperty(key);
    // this getProperty method takes key and returns value of the key.(we can call this method in other classes)
}

}
