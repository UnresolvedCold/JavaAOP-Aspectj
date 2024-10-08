package codes.shubham.aop.logging;

public class PriceLogger {
  private static PriceLogger instance = null;

  private PriceLogger() {
  }

  public static PriceLogger getInstance() {
    if (instance == null) {
      synchronized (PriceLogger.class) {
        if (instance == null) {
          instance = new PriceLogger();
        }
      }
    }
    return instance;
  }

  public void log(String name, int price) {
    System.out.println("Product: "+name+" Price: "+price);
  }
}
