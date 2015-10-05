package ln.reflection.obj;

import org.apache.log4j.Logger;

public class MyObject2 {
    private static Logger logger = Logger.getLogger(MyObject2.class);
    private String id;
    private String name;
    
    static {
        logger.info("MyObject2 static");
    }
    
    public MyObject2() {
        logger.info("MyObject2");
    }
    
    public static String myStaticMethod(String str) {
        return "myStaticMethod:" + str;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
