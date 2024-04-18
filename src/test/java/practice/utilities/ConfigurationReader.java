package practice.utilities;

import java.io.FileInputStream;
import java.util.Properties;


public class ConfigurationReader {

   private static Properties properties;

   static {
       try {
           String path = "configuration.properties";
           FileInputStream input = new FileInputStream(path);
           properties = new Properties();
           properties.load(input);
           input.close();
       }catch (Exception e){
           e.printStackTrace();
       }
   }
   public static String getProperty(String keyName){
       return properties.getProperty(keyName);
   }
}
//This class is reading from configuration.properties file. When we call this method its going to use this static block called in the beginning and return the value of it