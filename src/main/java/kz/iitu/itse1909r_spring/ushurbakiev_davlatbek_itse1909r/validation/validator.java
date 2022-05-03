package kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.validation;

import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.database.Candidates;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.AssertTrue;

public class validator implements ConstraintValidator<CandidateValid, Candidates> {
    @Override
    public void initialize(CandidateValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    @AssertTrue(message = "Error Individual customer should have gender and last name defined!")
    public boolean isValid(Candidates candidates, ConstraintValidatorContext constraintValidatorContext) {
        return candidates.getAccountName().equals(constraintValidatorContext.getDefaultConstraintMessageTemplate());
    }
}
