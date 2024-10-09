package codes.shubham.aop.play;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PlayAspect {
  @Pointcut("execution(* main(..))")
  public void defineEntryPoint() {
  }

  @Before("defineEntryPoint()")
  public void aaa(JoinPoint joinPoint) {
    System.out.println("aspect before");
  }

  @After("defineEntryPoint()")
  public void bbb(JoinPoint joinPoint) {
    System.out.println("aspect after");
  }

  // Point cut with parameter exposed
  // execution is used for invocation within a class
  // call is used for invocation from anywhere
  // For parameter exposure, use args and define the type in the method signature
  @Pointcut("call(* codes.shubham.aop.play.Play.helloWorld(String)) && args(name)")
  public void defineEntryPointForHelloWorld(String name) {
  }

  @Before("defineEntryPointForHelloWorld(name)")
  public void ccc(String name) {
    System.out.println("aspect before hello world with name: "+name);
  }

}
