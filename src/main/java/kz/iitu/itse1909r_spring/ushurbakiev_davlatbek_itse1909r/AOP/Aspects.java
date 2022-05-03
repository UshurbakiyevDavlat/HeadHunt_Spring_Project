package kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.AOP;

import lombok.extern.java.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Aspect
@Log
public class Aspects {

    @Pointcut("@annotation(LogToken)")
    public void tokenProcessingMethods() {
    }

    @Before("tokenProcessingMethods()")
    public void meBefore(JoinPoint point) {
        log.info("From method: " + point.getSignature().getName() + ", execution. timestamp: " + new Date().getTime());
    }


    @After("tokenProcessingMethods()")
    public void meAfter(JoinPoint point) {
        log.info("from method: " + point.getSignature().getName() + ",executed. Time: " + new Date().getTime());
    }

    @AfterReturning(pointcut = "execution(public * kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.Service.CandidateService.getAgeEighteenCandidates())", returning = "result")
    public void checkEighteenPlusCandidates(JoinPoint point, Object result) {
        log.info("return from method: " + point.getSignature().getName() + ": " + result.toString());
    }
}
