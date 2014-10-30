package ln.reflection.obj;

import org.apache.log4j.Logger;

public class MyObject {
    private static Logger logger = Logger.getLogger(MyObject.class);
    private String id;
    private String name;
    
    static {
        logger.info("MyObject static");
    }
    
    public MyObject() {
        logger.info("MyObject");
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
        return "MyName:" + name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
