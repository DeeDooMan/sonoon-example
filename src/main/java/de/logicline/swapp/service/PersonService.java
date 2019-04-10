package de.logicline.swapp.service;


import de.logicline.swapp.model.Person;

import java.util.List;

/**
 * Interface of PersonService.
 * Provides operations to add an remove persons as well as load all persons
 * 
 * (The M in MVC)
 * 
 * @author logicline
 *
 */
public interface PersonService {
    
    public void addPerson(Person person);
    public List<Person> listPeople();
    public void removePerson(Integer id);
}
