package kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.Service;

import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.AOP.LogToken;
import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.database.Candidates;
import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.database.Role;
import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.repository.CandidateRepository;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
@EnableScheduling
@EnableAsync
@Transactional
public class CandidateService {

    public CandidateRepository candidateRepository;
    private CacheManager cacheManager;

    @Autowired
    private SessionFactory sessionFactory;


    @PersistenceContext
    private EntityManager em;

    @Resource(name = "cacheManager")
    public void setCacheManager(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    @Autowired
    @Transactional(timeout = 10, rollbackFor = {SQLException.class})
    public void setCandidateServiceRepo(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @LogToken
    @Transactional(timeout = 10, rollbackFor = {SQLException.class})
//    @Cacheable(value = "getCandidates")
////    @Async
//    @Scheduled(fixedRate = 2000)
    public List<Candidates> getCandidates() throws SQLException {
        return this.candidateRepository.findAllc();
    }


    @LogToken
//    @Scheduled(cron = "${cron.hh}")
    @Transactional(timeout = 10, rollbackFor = {SQLException.class}, propagation = Propagation.REQUIRES_NEW)
    public List<Candidates> findAllByAttribute() {
        return this.candidateRepository.findAllByAttribute(new Date());
    }

    @LogToken
    @Transactional(timeout = 10, rollbackFor = {SQLException.class})
    public List<Candidates> findByAccountName(String name) {
        return this.candidateRepository.findByAccountName(name);
    }

    @LogToken
    @Transactional(timeout = 10, rollbackFor = {SQLException.class})
    public Object findResumeById(int id) throws SQLException {
        this.candidateRepository.findResumeById(id);
        return 1;
    }

    @LogToken
    @Transactional(timeout = 10, rollbackFor = {SQLException.class}, propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Candidates> findById(int id) throws SQLException {
        return this.candidateRepository.findById(id);
    }

    @LogToken
    @Transactional(timeout = 10, isolation = Isolation.SERIALIZABLE)
    public List<Candidates> findByStatus(int status) throws SQLException {
        PageRequest sortedByAgeDesc = PageRequest.of(0, 3, Sort.by("age").descending());
        return this.candidateRepository.findByStatus(status);
    }

    @LogToken
    @Transactional(timeout = 10, propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Candidates> findByAge(int age) throws SQLException {
        return this.candidateRepository.findByAge(age);
    }

    @LogToken
    @Transactional
    public Candidates create(Candidates candidates) throws SQLException {
        log.info(candidates.toString());

        Session sessionOne = sessionFactory.openSession();
        sessionOne.beginTransaction();

        Role role = new Role();
        role.setId(1);

        candidates.setRole(role);
        candidates.setPassword(candidates.getPassword());
        sessionOne.save(candidates);

        sessionOne.getTransaction().commit();

        sessionOne.close();


        return candidates;
    }

    @Transactional
    @Modifying
    //TODO доделать
    public Response.Status update(int c_id) throws SQLException {
        List<Candidates> candidates = this.candidateRepository.findById(c_id);
        candidates.get(0).setStatus(0);

        Session sessionOne = sessionFactory.openSession();
        sessionOne.beginTransaction();


        sessionOne.save(candidates.get(0));

        sessionOne.getTransaction().commit();

        sessionOne.close();
        return Response.Status.OK;
    }

    @Transactional
    @Modifying
    public void delete(int id) throws SQLException {
        List<Candidates> candidates = this.candidateRepository.findById(id);

        Session sessionOne = sessionFactory.openSession();
        sessionOne.beginTransaction();

        sessionOne.remove(sessionOne.contains(candidates.get(0)) ? candidates.get(0) : sessionOne.merge(candidates.get(0)));

        sessionOne.getTransaction().commit();

        sessionOne.close();

    }

}
