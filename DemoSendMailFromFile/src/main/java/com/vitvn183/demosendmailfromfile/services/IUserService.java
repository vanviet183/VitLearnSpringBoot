package com.vitvn183.demosendmailfromfile.services;

import com.vitvn183.demosendmailfromfile.entities.User;

import java.util.List;

public interface IUserService {
    List<User> findAllUser();
}
