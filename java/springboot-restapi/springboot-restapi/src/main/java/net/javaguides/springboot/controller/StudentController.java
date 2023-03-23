package net.javaguides.springboot.controller;

import net.javaguides.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {


    // http://localhost:8080/student
    @GetMapping("student")
    public Student getStudent(){
        Student student = new Student(
                1,
                "john",
                "smith"
        );
        return student;
    }
    //http://localhost:8080/students
@GetMapping
    public List<Student> getStudents(){
        List <Student> students = new ArrayList<>();
        students.add(new Student(1,"john","macca"));
        students.add(new Student(2,"jo","DMmacca"));
        students.add(new Student(3,"saffron","DMmacca"));
        students.add(new Student(4,"arran","DMmacca"));
        return students;

    }
    //http://localhost:8080/students/1/john/test
    @GetMapping("/{id}/{first-name}/{last-name}")
    public Student studentPathVariable(@PathVariable("id") int studentId,
                                @PathVariable("first-name") String firstName,
                                @PathVariable("last-name") String lastName)
    {
       return new Student(studentId,firstName,lastName);
    }

    // http://localhost:8080/students/query?id=1&firstName=john&lastName=macca
    @GetMapping("/query")
    public Student studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName){
        return new Student(id, firstName, lastName);
    }

    //spring rest api that handles post request
@PostMapping("/create")
@ResponseStatus(HttpStatus.CREATED)
    public  Student createStudent (@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return  student;
    }
    // postman http://localhost:8080/students/update
    // springboot rest api that handles put requests update
    // exisiting request

    @PutMapping("/{id}/update")
    public Student updateStudent (@RequestBody Student student, @PathVariable("id") int studentId){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }
    // rest api to delete
  @DeleteMapping("/{id}/delete")
    public String deleteStudent (@PathVariable ("id") int studentId){
        System.out.println(studentId);
        return "deleted";
    }

}
