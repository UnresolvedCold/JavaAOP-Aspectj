package codes.shubham.aop.boxset;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Aspect2 {
  @Pointcut("call(* codes.shubham.aop.boxset.Boxset.setName(String))")
  public void defineEntryPointForGetName() {
  }

  @Before("defineEntryPointForGetName()")
  public void log() {
    System.out.println("Call From Java Jointpoint");
  }

  @Pointcut("initialization(codes.shubham.aop.boxset.Boxset.new(String))")
  public void defineEntryPointForBoxset() {
  }

  @Before("defineEntryPointForBoxset()")
  public void log2() {
    System.out.println("Call From Java Jointpoint before constructor");
  }
}
