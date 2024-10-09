package codes.shubham.aop.db;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
public class AspectDB {

    // Pointcut to capture all method executions within the codes.shubham.aop package
    @Pointcut("execution(* codes.shubham.aop..*(..)) && !within(codes.shubham.aop.db..*)")
    public void captureMethodsInAopPackage() {
        // Pointcut definition
    }

    @Around("captureMethodsInAopPackage()")
    public Object captureAndLogMethodOutput(ProceedingJoinPoint joinPoint) throws Throwable {
        // Check if the system property for test mode is set

            // Proceed with the original method call
            Object result = joinPoint.proceed();

            // Capture method signature and output value
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            String className = signature.getDeclaringTypeName();
            String methodName = signature.getName();

            // Build the key: package.class.function
            String key = className + "." + methodName;

            // Store the output in the TestDB map
            TestDB.getInstance().getMap().put(key, result);

            // Return the result to ensure normal program flow
            return result;
    }
}
