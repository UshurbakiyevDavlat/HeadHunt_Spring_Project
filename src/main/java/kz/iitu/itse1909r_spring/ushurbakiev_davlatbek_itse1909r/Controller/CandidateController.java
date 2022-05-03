package kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.Controller;


import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.Service.CandidateService;
import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.Service.ResumeService;
import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.database.Candidates;
import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.database.Resume;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/candidates")
@Log
public class CandidateController {
    private final CandidateService candidateService;
    private final ResumeService resumeService;

    @Autowired
    public CandidateController(CandidateService candidateService, ResumeService resumeService) {
        this.candidateService = candidateService;
        this.resumeService = resumeService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Candidates> getAll() throws SQLException {
        return candidateService.getCandidates();
    }

    @PostMapping("/create")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Response.Status create(@Valid @RequestBody Candidates candidates) throws SQLException {
        List<Resume> resume = resumeService.getResumeById();
        candidates.setResume(resume.get(0));
        log.info("----------" + resume.get(0).toString());
        candidateService.create(candidates);
        return Response.Status.OK;
    }

    @GetMapping("/print-all-headers")
    public Map<String, String> getAllheaders(@RequestHeader Map<String, String> headers) {
        return headers;
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity update(@Valid @RequestParam("id") int id) throws SQLException {
        return ResponseEntity.ok().body(candidateService.update(id));
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity deleteBook(@RequestParam("id") int id) throws SQLException {
        candidateService.delete(id);
        return ResponseEntity.ok("Candidate deleted");
    }

    @GetMapping(value = "/findByAttr")
    @ResponseStatus(HttpStatus.OK)
    public List<Candidates> findByAttr() throws SQLException {
        return candidateService.findAllByAttribute();
    }

    @GetMapping(value = "/findById")
    @ResponseStatus(HttpStatus.OK)
    public List<Candidates> findByID() throws SQLException {
        return candidateService.findById(3);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(SQLException.class)
    public String dummyException(SQLException e) {
        return e.getMessage();
    }

    @GetMapping(value = "/paging")
    @ResponseStatus(HttpStatus.OK)
    public PageRequest paging() throws SQLException {
        return PageRequest.of(0, 2, Sort.by("age").descending());
    }
}
