package com.bootlabs.sample.service;


import com.bootlabs.sample.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * <h2>UserService</h2>
 *
 * @author bootlabs
 * <p>
 * Description:
 */
public interface UserService extends UserDetailsService {

    /**
     * @return list of User
     */
    List<User> getUsers();

    /**
     * @param user ussr object
     * @return user saved or updated
     */
    User save(User user);
}
