package kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.validation;

import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.database.Vacancy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistrar;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.util.StringValueResolver;

import java.util.Set;

import static org.mockito.Mockito.*;

class formatterTest {
    @Mock
    Set<Formatter<?>> formatters;
    @Mock
    Set<?> converters;
    @Mock
    Set<FormatterRegistrar> formatterRegistrars;
    @Mock
    StringValueResolver embeddedValueResolver;
    @Mock
    FormattingConversionService conversionService;
    @InjectMocks
    kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.validation.formatter formatter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSetFormatters() {
        formatter.setFormatters();
    }

    @Test
    void testVacancyFormatter() {
        Formatter<Vacancy> result = formatter.vacancyFormatter();
        Assertions.assertEquals(formatters.contains(result), false);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme