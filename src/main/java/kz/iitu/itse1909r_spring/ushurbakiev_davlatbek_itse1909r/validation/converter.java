package kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.validation;

import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.database.Candidates;
import org.springframework.core.convert.converter.Converter;

public class converter implements Converter<String, Candidates> {
    @Override
    public Candidates convert(String source) {
        String []data = source.split(",");
        Candidates candidates = new Candidates();
        candidates.setCandidate_id(Integer.parseInt(data[0]));
        candidates.setAccountName(data[1]);
        return candidates;
    }
}
