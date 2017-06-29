package com.cihangir.service.impl;

import com.cihangir.dao.UserDAO;
import com.cihangir.model.Travel;
import com.cihangir.model.User;
import com.cihangir.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by cihangir on 6/16/17.
 */
@Service
@Transactional
public class UserService implements IUserService {

    @Autowired
    private UserDAO userDAO;


    @Override
    public List<User> getAllUser() {
        return null;
    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public void saveTravel(Travel theTravel) {
        userDAO.insertTravel(theTravel);
    }

    @Override
    public List<Travel> getAllTravel() {
        return userDAO.findTravels();
    }

    @Override
    public List<Travel> getTravelsBetweenDate(String d1, String d2) {
        return null;
    }


    @Override
    public List<Travel> getTravelsBetweenDate(Date date1, Date date2) {
        return userDAO.findTravelsBetweenDates(date1, date2);
    }


}
