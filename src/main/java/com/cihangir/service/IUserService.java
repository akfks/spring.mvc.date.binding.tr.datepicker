package com.cihangir.service;

import com.cihangir.model.Travel;
import com.cihangir.model.User;

import java.util.Date;
import java.util.List;

/**
 * Created by cihangir on 6/16/17.
 */
public interface IUserService {

    public List<User> getAllUser();
    public void saveUser(User user);

    void saveTravel(Travel theTravel);

    List<Travel> getAllTravel();

    List<Travel> getTravelsBetweenDate(String d1, String d2);

    List<Travel> getTravelsBetweenDate(Date date1, Date date2);
}
