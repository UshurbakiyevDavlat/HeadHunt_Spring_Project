package kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.validation;

import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.Service.CandidateService;
import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.database.Candidates;
import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.repository.CandidateRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import javax.validation.ClockProvider;
import javax.validation.ConstraintValidatorContext;
import java.sql.SQLException;

class validatorTest {
    kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.validation.validator validator = new validator();

    @Mock
    validator valid;
    @Mock
    ConstraintValidatorContext constraintValidatorContext;

    @InjectMocks
    CandidateRepository candidateRepository;

    @Mock
    CandidateService candidateService;

    @Test
    void testInitialize() throws SQLException {
        candidateService = new CandidateService();
        candidateService.setCandidateServiceRepo(candidateRepository);


        constraintValidatorContext = new ConstraintValidatorContext() {
            @Override
            public void disableDefaultConstraintViolation() {

            }

            @Override
            public String getDefaultConstraintMessageTemplate() {
                return null;
            }

            @Override
            public ClockProvider getClockProvider() {
                return null;
            }

            @Override
            public ConstraintViolationBuilder buildConstraintViolationWithTemplate(String s) {
                return null;
            }

            @Override
            public <T> T unwrap(Class<T> aClass) {
                return null;
            }
        };


        Assertions.assertFalse(validator.isValid(new Candidates("Davlat", 1), constraintValidatorContext));
        validator.initialize(null);
    }

}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme