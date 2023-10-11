package helpers;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlHelper {

    public static URL createURL(String path) {
        try {
            return new URL(path);
        } catch(MalformedURLException e){
            // handle somehow
            throw new RuntimeException(e);
        }
    }
}
