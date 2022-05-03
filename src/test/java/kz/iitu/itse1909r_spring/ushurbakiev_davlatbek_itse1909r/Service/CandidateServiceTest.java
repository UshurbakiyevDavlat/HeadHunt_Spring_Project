package kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.Service;

import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.database.Candidates;
import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.database.Resume;
import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.repository.CandidateRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.cache.CacheManager;
import org.springframework.test.util.ReflectionTestUtils;

import javax.persistence.EntityManager;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class CandidateServiceTest {
    @Mock
    CandidateRepository candidateRepository;
    @Mock
    CacheManager cacheManager;
    @Mock
    EntityManager em;
    @Mock
    Logger log;
    @InjectMocks
    CandidateService candidateService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetCandidates() throws SQLException {
        when(candidateRepository.findAllc()).thenReturn(List.<Candidates>of(new Candidates(1, "accountName", "email", 0, 0, new Resume())));

        ReflectionTestUtils.setField(new Candidates(), "id", 2);
        List<Candidates> result = candidateService.getCandidates();
        Assertions.assertNotNull(result);
   }

    @Test
    void testFindAllByAttribute() {
        when(candidateRepository.findAllByAttribute(any())).thenReturn(List.of(new Candidates(1, "Davlat", "email", 0, 0, new Resume())));

        ReflectionTestUtils.setField(new Candidates(), "id", 2);
        List<Candidates> result = candidateService.findAllByAttribute();
        Assertions.assertEquals(new Resume().getId(), result.get(0).getResume().getId());
    }

    @Test
    void testFindByAccountName() {
        when(candidateRepository.findByAccountName(anyString())).thenReturn(List.<Candidates>of(new Candidates(0, "accountName", "dushurbakiev@gmail.com", 0, 0, new Resume())));

        ReflectionTestUtils.setField(new Candidates(), "id", 2);
        List<Candidates> result = candidateService.findByAccountName("name");
        Assertions.assertNotEquals("dushurbakiev1@gmail.com", result.get(0).getAccountName());
    }

    @Test
    void testFindResumeById() throws SQLException {
        ReflectionTestUtils.setField(new Candidates(), "id", 2);
       Assertions.assertNotNull(candidateService.findResumeById(0));
    }

    @Test
    void testFindById() throws SQLException {
        when(candidateRepository.findById(anyInt())).thenReturn(List.<Candidates>of(new Candidates(0, "accountName", "email", 0, 0, new Resume())));

        ReflectionTestUtils.setField(new Candidates(), "id", 2);
        List<Candidates> result = candidateService.findById(0);
        Assertions.assertEquals(0, result.get(0).getCandidate_id());
    }

    @Test
    void testFindByStatus() throws SQLException {
        when(candidateRepository.findByStatus(anyInt())).thenReturn(List.<Candidates>of(new Candidates(0, "accountName", "email", 0, 1, new Resume())));

        ReflectionTestUtils.setField(new Candidates(), "id", 2);
        List<Candidates> result = candidateService.findByStatus(0);
        Assertions.assertEquals(1, result.get(0).getStatus());
    }

    @Test
    void testFindByAge() throws SQLException {
        when(candidateRepository.findByAge(anyInt())).thenReturn(List.<Candidates>of(new Candidates(0, "accountName", "email", 18, 0, new Resume())));

        ReflectionTestUtils.setField(new Candidates(), "id", 2);
        List<Candidates> result = candidateService.findByAge(18);
        Assertions.assertEquals(18, result.get(0).getAge());
    }

    @Test
    void testCreate() throws SQLException {
        Candidates result = candidateService.create(new Candidates(1, "accountName", "email", 0, 1, new Resume()));
        Assertions.assertNull(result);
    }

    @Test
    void testUpdate() throws SQLException {
        when(candidateRepository.findById(anyInt())).thenReturn(List.<Candidates>of(new Candidates(null, null, null, null, 0, null)));

        ReflectionTestUtils.setField(new Candidates(), "id", 2);
        Response.Status result = candidateService.update(0);
        Assertions.assertNotEquals(result, new Candidates());
    }

    @Test
    void testDelete() throws SQLException {
        when(candidateRepository.findById(anyInt())).thenReturn(List.<Candidates>of(new Candidates(0, "accountName", "email", Integer.valueOf(0), Integer.valueOf(0), new Resume())));

        ReflectionTestUtils.setField(new Candidates(), "id", 2);
        candidateService.delete(0);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme