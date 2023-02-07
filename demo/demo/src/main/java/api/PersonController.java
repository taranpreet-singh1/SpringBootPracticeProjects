package api;

import model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import service.PersonService;

@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(Person person){
        personService.insertPerson(person);
    }

}
