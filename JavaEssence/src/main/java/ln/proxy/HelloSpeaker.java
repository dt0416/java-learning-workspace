package ln.proxy;


import org.apache.log4j.Logger;

public class HelloSpeaker implements IHello {
    private static Logger logger = Logger.getLogger(HelloSpeaker.class);
    
    @Override
    public void hello(String name) {
        logger.info("Hello, " + name);
    }

}
