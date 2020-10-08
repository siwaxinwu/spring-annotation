package io.roy.spring.plugins.register.service;

import io.roy.spring.plugins.register.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * description：
 * author：dingyawu
 * date：created in 17:21 2020/9/28
 * history:
 */
@Service
public class PersonService {
    @Autowired(required = false)
    //@Qualifier("personDao")
    private PersonDao personDao;

    @Override
    public String toString() {
        return personDao.toString();
    }
}