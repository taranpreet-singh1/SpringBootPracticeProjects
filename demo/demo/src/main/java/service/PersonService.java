package service;

import dao.PersonDao;
import model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PersonService {


    private final PersonDao personDao;

    @Autowired //Autowiring to PersonService interface
    public PersonService(@Qualifier("fakeDao") PersonDao personDao1){
        personDao = personDao1;
    }

    public int insertPerson(Person person){
        return personDao.insertPerson(person);
    }

}
