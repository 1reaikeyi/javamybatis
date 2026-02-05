package bean;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Resource {
    private Resource(){

    }
    public static InputStream getResourceAsStream(String path){
        return ClassLoader.getSystemClassLoader().getResourceAsStream(path);
    }

//    public static InputStream getResourceAsStream(String path){
//            try {
//                return new FileInputStream(path);
//            } catch (FileNotFoundException e) {
//                throw new RuntimeException(e);
//            }
//    }
}
