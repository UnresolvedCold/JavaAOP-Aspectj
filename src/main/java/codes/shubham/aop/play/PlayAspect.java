package codes.shubham.aop.play;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PlayAspect {
  @Pointcut("call(* codes.shubham.aop.play.Play.helloWorld(String)) && args(name)")
  public void defineEntryPointForHelloWorld(String name) {
  }

  @Before("defineEntryPointForHelloWorld(name)")
  public void log(String name) {
    System.out.println("Call From Java Jointpoint");
  }

}
