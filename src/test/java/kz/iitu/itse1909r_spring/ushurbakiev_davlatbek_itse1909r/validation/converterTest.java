package kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.validation;

import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.database.Candidates;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class converterTest {
    kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.validation.converter converter = new converter();

    @Test
    void testConvert() {
        Candidates result = converter.convert("1,2");
        Assertions.assertEquals(new Candidates(1, "2", null, null, null, null).toString(), result.toString());
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme