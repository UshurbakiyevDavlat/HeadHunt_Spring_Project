package kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Date;

import static org.mockito.Mockito.*;

class VacancyTest {
    @Mock
    Date created_at;
    @Mock
    Candidates candidate;
    @InjectMocks
    Vacancy vacancy;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testToString() {
        String result = vacancy.toString();
        Assertions.assertNotEquals(new Vacancy().toString(), result.toString());
        Assertions.assertNotEquals(new Vacancy().getId(), result.toString());
        Assertions.assertNotEquals(new Vacancy().getName(), result.toString());
        Assertions.assertNotEquals(new Vacancy().getAmount(), result.toString());
        Assertions.assertNotEquals(new Vacancy().getCandidate(), result.toString());
        Assertions.assertNotEquals(new Vacancy().getStatus(), result.toString());
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme