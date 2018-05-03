package com.codeup.pawtify.services;

import com.codeup.pawtify.daos.Roles;
import com.codeup.pawtify.daos.UsersRepository;
import com.codeup.pawtify.models.User;
import com.codeup.pawtify.models.UserWithRoles;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsLoader implements UserDetailsService{
    private UsersRepository usersDao;
    private Roles roles;

    public UserDetailsLoader(UsersRepository usersDao) {
        this.usersDao = usersDao;
        this.roles = roles;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = usersDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("No username: %s found", username));
        }
        return new UserWithRoles(user, roles.ofUserWith(username));
    }
}
