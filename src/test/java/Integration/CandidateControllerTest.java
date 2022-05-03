package Integration;

import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.Service.CandidateService;
import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.Service.ResumeService;
import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.database.Candidates;
import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.repository.CandidateRepository;
import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.repository.VacancyRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@ContextConfiguration(classes = {VacancyRepository.class, CandidateRepository.class})
@WebMvcTest
public class CandidateControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    CandidateService candidateService;

    @MockBean
    ResumeService resumeService;

    @Test
    void getAll() throws Exception {
        List<Candidates> candidatesList = new ArrayList<>();
        mockMvc.perform(post("/candidates/"))
                .andDo(System.out::println)
                .andReturn().getResponse();

        Assertions.assertNotNull(mockMvc.toString());

    }
}
