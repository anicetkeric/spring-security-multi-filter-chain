package com.bootlabs.sample.service;


import com.bootlabs.sample.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "userDetailsJwtService")
@RequiredArgsConstructor
@Transactional
public class UserDetailsJwtServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    private final AccountStatusUserDetailsChecker detailsChecker = new AccountStatusUserDetailsChecker();

    /**
     * Load user info by credential
     *
     * @param usernameValue username or email
     * @return UserDetails object
     */
    @Override
    public UserDetails loadUserByUsername(String usernameValue) {
        var user = userRepository.findActiveByUsername(usernameValue)
                .orElseThrow(() -> new UsernameNotFoundException("Invalid username or password."));

        // set encoded password = 123456789  (this is for dev mode)
        user.setPassword("$2a$10$NWNajrXEnFlv9nekF7G6xOhDabCMCYhYNrIkqgRVbHASfZpgb6EWS");
        detailsChecker.check(user);

        return user;
    }

}
