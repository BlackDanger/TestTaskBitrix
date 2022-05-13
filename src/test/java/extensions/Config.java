package extensions;

import org.aeonbits.owner.ConfigCache;

public class Config {
    // public instance initialized when loading the class
    private static PropertyLoader config = ConfigCache.getOrCreate(PropertyLoader.class);

    private Config()
    {
        // private constructor
    }
    public static PropertyLoader get(){
        return config;
    }
}
