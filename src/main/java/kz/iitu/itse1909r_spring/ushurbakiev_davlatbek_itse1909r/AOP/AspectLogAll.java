package kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.AOP;


import lombok.extern.java.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Log
public class AspectLogAll {
    @Pointcut(
            "within(kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.Service.CandidateService)" +
                    "within(kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.Service.ResumeService)" +
                    "within(kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.Service.VacancyService)")
    public void tokenProcessingMethods() {
    }

    @Around("tokenProcessingMethods()")
    public Object ExecTime(ProceedingJoinPoint point) throws Throwable {
        long start = System.currentTimeMillis();

        Object proceed = point.proceed();
        long executionTime = System.currentTimeMillis() - start;

        log.info(point.getSignature() + " done in " + executionTime + "ms");
        return proceed;
    }

    @AfterThrowing(pointcut = "@annotation(kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.AOP.LogToken)", throwing = "ex")
    public void WithinException(JoinPoint joinPoint, Exception ex) {
        log.info("Exception in " + joinPoint.getSignature() + ", " + ex.getMessage());
    }
}
