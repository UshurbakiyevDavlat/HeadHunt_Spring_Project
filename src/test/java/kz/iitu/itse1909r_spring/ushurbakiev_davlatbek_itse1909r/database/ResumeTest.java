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

class ResumeTest {
    @Mock
    Date created_at;
    @Mock
    List<Candidates> candidateses;
    @InjectMocks
    Resume resume;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testToString() {
        String result = resume.toString();
        Assertions.assertNotEquals(new Resume().getId(), result.toString());
        Assertions.assertNotEquals(new Resume().getName(), result.toString());
        Assertions.assertNotEquals(new Resume().getDescription(), result.toString());
        Assertions.assertNotEquals(new Resume().getEducation(), result.toString());
        Assertions.assertNotEquals(new Resume().getPhone(), result.toString());
        Assertions.assertNotEquals(new Resume().getCandidateses(), result.toString());
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme