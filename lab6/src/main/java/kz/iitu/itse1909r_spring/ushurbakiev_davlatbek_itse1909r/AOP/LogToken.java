package kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.AOP;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LogToken {
    public boolean isImportant() default false;
}
