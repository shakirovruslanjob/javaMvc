package alishev.DAO;

import alishev.model.person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class personDAO {
  private   List<person> people;
    {
        people=new ArrayList<>();
        people.add(new person(1,"kate"));
        people.add(new person(2,"mike"));
        people.add(new person(3,"alisher"));

    }
    public List<person> index(){
        return people;
    }
    public person show(int id){
        return people.stream().filter(person ->person.getId()==id).findAny().orElse(null);

    }
    public void save(person person){
        person.setId(4);
       people.add(person);
    }
}
