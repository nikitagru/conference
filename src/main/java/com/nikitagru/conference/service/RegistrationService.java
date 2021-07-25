package com.nikitagru.conference.service;

import com.nikitagru.conference.repository.UsersRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    private UsersRoleRepository usersRoleRepository;

    @Autowired
    public void setUsersRoleRepository(UsersRoleRepository usersRoleRepository) {
        this.usersRoleRepository = usersRoleRepository;
    }

    /***
     * Saves new user with role
     * @param userId current user's id
     */
    public void saveAndSetRoleUser(long userId) {
        usersRoleRepository.saveNewUser(userId);
    }
}
