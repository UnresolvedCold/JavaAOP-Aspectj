package codes.shubham.aop.db;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Aspect
public class AspectDB {

  // Pointcut to capture all method executions within the codes.shubham.aop package
  @Pointcut("execution(* codes.shubham.aop..*(..)) && !within(codes.shubham.aop.db..*)")
  public void captureMethodsInAopPackage() {
    // Pointcut definition
  }

  // Map to track iterations for each unique key
  private Map<String, Integer> iterationMap = new HashMap<>();

  @Around("captureMethodsInAopPackage()")
  public Object captureAndLogMethodOutput(ProceedingJoinPoint joinPoint) throws Throwable {
    // Get the method signature
    MethodSignature signature = (MethodSignature) joinPoint.getSignature();
    String executionClassName = signature.getDeclaringTypeName();
    String methodName = signature.getName();

    // Get the caller class name (this will be the class that invokes the method)
    String callerClassName = joinPoint.getSourceLocation().getWithinType().getName();

    // Create a unique key for this caller and execution class combination
    String uniqueKey = callerClassName + "-" + executionClassName;

    // Update the iteration count for this unique key
    int iteration = iterationMap.getOrDefault(uniqueKey, 0) + 1;
    iterationMap.put(uniqueKey, iteration);

    // Build the final key: <caller class>-<execution class>-<method_name>-<iteration>
    String key = uniqueKey + "-" + methodName + "-" + iteration;

    // Proceed with the original method call
    Object result = joinPoint.proceed();

    // Store the output in the TestDB map
    TestDB.getInstance().getMap().put(key, result);

    // Return the result to ensure normal program flow
    return result;
  }
}
