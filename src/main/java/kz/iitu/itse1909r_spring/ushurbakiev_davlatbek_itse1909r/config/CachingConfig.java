package kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@EnableCaching
public class CachingConfig {

    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Arrays.asList(
                        new ConcurrentMapCache("candidates_adults"),
                        new ConcurrentMapCache("candidates_open"),
                        new ConcurrentMapCache("resumes"),
                        new ConcurrentMapCache("vacancies"),
                        new ConcurrentMapCache("account"),
                        new ConcurrentMapCache("getCandidates")
                )
        );
        return cacheManager;
    }
}
