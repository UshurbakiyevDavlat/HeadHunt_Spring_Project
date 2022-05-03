package kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Date;
import java.util.List;

import static org.mockito.Mockito.*;

class CandidatesTest {
    @Mock
    Resume resume;
    @Mock
    Date created_at;
    @Mock
    List<Vacancy> vacancies;
    @InjectMocks
    Candidates candidates;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testToString() {
        String result = candidates.toString();
        Assertions.assertEquals(new Candidates().toString(), result);
        Assertions.assertNotEquals(new Candidates().getCandidate_id(), result.toString());
        Assertions.assertNotEquals(new Candidates().getAccountName(), result.toString());
        Assertions.assertNotEquals(new Candidates().getAge(), result.toString());
        Assertions.assertNotEquals(new Candidates().getStatus(), result.toString());
        Assertions.assertNotEquals(new Candidates().getResume(), result.toString());
        Assertions.assertNotEquals(new Candidates().getVacancies(), result.toString());
        Assertions.assertNotEquals(new Candidates().getEmail(), result.toString());
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme