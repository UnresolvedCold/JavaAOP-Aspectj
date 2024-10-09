package codes.shubham.aop.products.aspect;

import codes.shubham.aop.products.logging.PriceLogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import codes.shubham.aop.products.items.IProduct;
@Aspect
public class LoggingAspect2 {

  @Pointcut("call(public void codes.shubham.aop.products.items.IProduct.setPrice(int)) " +
      "&& args(price) " +
      "&& target(codes.shubham.aop.products.items.IProduct)")
  public void logPriceChange(int price) {
    // Pointcut definition
  }

  @After("logPriceChange(price)")
  public void afterPriceChange(JoinPoint point, int price) {
    String name = ((IProduct) point.getTarget()).getName();
    PriceLogger.getInstance().log(name, price);
  }
}
