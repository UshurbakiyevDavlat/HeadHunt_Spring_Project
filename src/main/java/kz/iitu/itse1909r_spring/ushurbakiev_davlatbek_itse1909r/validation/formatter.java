package kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.validation;

import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.database.Vacancy;
import org.jetbrains.annotations.NotNull;
import org.springframework.format.Formatter;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class formatter extends FormattingConversionServiceFactoryBean {

    private final Set<Formatter<?>> formatters = new HashSet<>();

    @PostConstruct
    public void setFormatters() {
        formatters.add(vacancyFormatter());
    }

    public Formatter<Vacancy> vacancyFormatter() {
        return new Formatter<>() {

            @Override
            public @NotNull String print(@NotNull Vacancy object, @NotNull Locale locale) {
                return object.toString();
            }

            @Override
            public @NotNull Vacancy parse(@NotNull String text, @NotNull Locale locale) throws ParseException {
                return new Vacancy();
            }
        };
    }
}
