package kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.Security;

import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.database.Candidates;
import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.repository.CandidateRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Log
@Service("userDetailsService")
@Transactional
public class DetailService implements UserDetailsService {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private LoginAttemptService loginAttemptService;

    @Autowired
    private HttpServletRequest request;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        String ip = getClientIP();
        if (loginAttemptService.isBlocked(ip)) {
            throw new RuntimeException("blocked");
        }

        Candidates user = candidateRepository.findByAccountName(username).get(0);
        if (user == null) {
            return new org.springframework.security.core.userdetails.User(
                    " ", " ", false, true, true, true,
                    getAuthorities(List.of("Candidate")));
        }

        return new org.springframework.security.core.userdetails.User(
                user.getAccountName(), passwordEncoder.encode(user.getPassword()), true, true, true, true,
                getAuthorities(List.of(user.getRole().toString())));


    }

    private Collection<? extends GrantedAuthority> getAuthorities(
            Collection<String> roles) {
        List<GrantedAuthority> authorities
                = new ArrayList<>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }

        log.info(authorities.get(0).getAuthority());
        return authorities;
    }


    private String getClientIP() {
        String xfHeader = request.getHeader("X-Forwarded-For");
        if (xfHeader == null) {
            return request.getRemoteAddr();
        }
        return xfHeader.split(",")[0];
    }
}
