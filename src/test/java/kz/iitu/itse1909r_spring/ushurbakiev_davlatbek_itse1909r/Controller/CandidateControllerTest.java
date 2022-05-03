package kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.Controller;

import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.Service.CandidateService;
import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.Service.ResumeService;
import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.database.Candidates;
import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.database.Resume;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import static org.mockito.Mockito.*;

//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = { Lab6Application.class })
//@WebAppConfiguration
class CandidateControllerTest {
    @Mock
    CandidateService candidateService;
    @Mock
    ResumeService resumeService;
    @Mock
    Logger log;
    @InjectMocks
    CandidateController candidateController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAll() throws SQLException {
        when(candidateService.getCandidates()).thenReturn(Arrays.<Candidates>asList(new Candidates(Integer.valueOf(0), "accountName", "email", Integer.valueOf(0), Integer.valueOf(0), new Resume())));

        List<Candidates> result = candidateController.getAll();
        Assertions.assertEquals(Arrays.<Candidates>asList(new Candidates(Integer.valueOf(0), "accountName", "email", Integer.valueOf(0), Integer.valueOf(0), new Resume())).get(0).toString(), result.get(0).toString());
    }

    @Test
    void testCreate() throws SQLException {
        when(candidateService.create(any())).thenReturn(new Candidates(null, null, null, null, null, new Resume()));
        when(resumeService.getResumeById()).thenReturn(Arrays.<Resume>asList(new Resume()));

        Response.Status result = candidateController.create(new Candidates(null, null, null, null, null, new Resume()));
        Assertions.assertEquals(Response.Status.OK, result);
    }

    @Test
    void testGetAllheaders() {
        Map<String, String> result = candidateController.getAllheaders(new HashMap<String, String>() {{
            put("String", "String");
        }});
        Assertions.assertEquals(new HashMap<String, String>() {{
            put("String", "String");
        }}, result);
    }

    @Test
    void testUpdate() throws SQLException {
        when(candidateService.update(anyInt())).thenReturn(Response.Status.OK);

        ResponseEntity result = candidateController.update(0);
        Assertions.assertEquals("<200 OK OK,OK,[]>", result.toString());
    }

    @Test
    void testDeleteBook() throws SQLException {
        ResponseEntity result = candidateController.deleteBook(0);
        Assertions.assertEquals("<200 OK OK,Candidate deleted,[]>", result.toString());
    }

    @Test
    void testFindByAttr() throws SQLException {
        when(candidateService.findAllByAttribute()).thenReturn(Arrays.<Candidates>asList(new Candidates(Integer.valueOf(0), "accountName", "email", Integer.valueOf(0), Integer.valueOf(0), new Resume())));

        List<Candidates> result = candidateController.findByAttr();
        Assertions.assertEquals(Arrays.<Candidates>asList(new Candidates(Integer.valueOf(0), "accountName", "email", Integer.valueOf(0), Integer.valueOf(0), new Resume())).get(0).getAccountName(), result.get(0).getAccountName());
    }

    @Test
    void testFindByID() throws SQLException {
        when(candidateService.findById(anyInt())).thenReturn(Arrays.<Candidates>asList(new Candidates(Integer.valueOf(0), "accountName", "email", Integer.valueOf(0), Integer.valueOf(0), new Resume())));

        List<Candidates> result = candidateController.findByID();
        Assertions.assertEquals(Arrays.<Candidates>asList(new Candidates(Integer.valueOf(0), "accountName", "email", Integer.valueOf(0), Integer.valueOf(0), new Resume())).get(0).getAccountName(), result.get(0).getAccountName());
    }

    @Test
    void testDummyException() {
        String result = candidateController.dummyException(new SQLException());
        Assertions.assertNull(result);
    }

    @Test
    void testPaging() throws SQLException {
        PageRequest result = candidateController.paging();
        Assertions.assertNotNull(result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme