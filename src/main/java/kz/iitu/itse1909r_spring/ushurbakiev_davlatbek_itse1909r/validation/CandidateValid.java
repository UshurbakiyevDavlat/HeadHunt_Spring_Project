package kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.validation;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy= validator.class)
@Documented
public @interface CandidateValid {
}
