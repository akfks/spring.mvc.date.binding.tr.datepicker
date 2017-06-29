package com.cihangir.dao;

import com.cihangir.model.Travel;
import com.cihangir.model.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;
import java.util.List;

/**
 * Created by cihangir on 6/6/17.
 */
@Repository
public class UserDAO {

    @Autowired
    private SessionFactory sessionFactory;


    public void insertTravel(Travel theTravel) {
        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(theTravel);
    }

    public List<Travel> findTravels() {
        // get current hibernate session
        Session currentSession=sessionFactory.getCurrentSession();


        Criteria criteria=currentSession.createCriteria(Travel.class);
        List<Travel> travels=criteria.list();

        // return the results
        return travels;
    }

    public List<Travel> findTravelsBetweenDates(Date date1, Date date2) {
        // get current hibernate session
        Session currentSession=sessionFactory.getCurrentSession();

        Criteria criteria = currentSession.createCriteria(Travel.class)
                .add(Restrictions.or(
                        Restrictions.isNull("beginTime"),
                        Restrictions.ge("beginTime", date1)))
                .add(Restrictions.or(
                        Restrictions.isNull("endTime"),
                         Restrictions.lt("endTime", date2)));


        List<Travel> travels=criteria.list();

        return travels;
    }
}
