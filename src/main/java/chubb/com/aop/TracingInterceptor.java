package chubb.com.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
class TracingInterceptor {

    @Pointcut(value = "execution(* *(..))")
    public void anyMethod() {
        // Pointcut for intercepting ANY method.
        System.out.println("DO ST");
    }

    @Around("anyMethod()")
    public Object invoke(final ProceedingJoinPoint pjp) throws Throwable {
        //does some stuff
        System.out.println("Any method: " + pjp.getSignature());
        return pjp.proceed();
    }
}