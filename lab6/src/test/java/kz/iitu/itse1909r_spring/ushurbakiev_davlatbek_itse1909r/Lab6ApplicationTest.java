package kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import java.sql.SQLException;

class Lab6ApplicationTest {
    @Mock
    Logger log;
    @InjectMocks
    Lab6Application lab5Application;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    void testMain() throws SQLException {
        Lab6Application.main(new String[]{"args"});
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme