package com.vitvn183.demosendmailfromfile.services.imp;

import com.vitvn183.demosendmailfromfile.entities.User;
import com.vitvn183.demosendmailfromfile.repositories.UserRepository;
import com.vitvn183.demosendmailfromfile.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class UserServiceImp implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }
}
