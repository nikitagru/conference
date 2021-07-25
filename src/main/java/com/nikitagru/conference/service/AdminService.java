package com.nikitagru.conference.service;

import com.nikitagru.conference.repository.UsersRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    private UsersRoleRepository usersRoleRepository;

    @Autowired
    public void setUsersRoleRepository(UsersRoleRepository usersRoleRepository) {
        this.usersRoleRepository = usersRoleRepository;
    }

    public void changeListenerToPresenter(long id) {
        usersRoleRepository.changeListenerToPresenter(id);
    }

    public void changePresenterToListener(long id) {
        usersRoleRepository.changePresenterToListener(id);
    }
}
