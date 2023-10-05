package demowebshop.factoryBrowser;

public class BrowserNotSupportedException extends IllegalStateException{
    public static final long serialinal = 1L;

    public BrowserNotSupportedException(String browserName){
        super(String.format("Browser not support : %s",browserName));
    }

}
