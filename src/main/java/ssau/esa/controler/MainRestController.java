package ssau.esa.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ssau.esa.model.*;
import ssau.esa.notice.JmsSender;
import ssau.esa.repo.FacultyRepo;
import ssau.esa.repo.StudentRepo;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(method={RequestMethod.POST,RequestMethod.GET})
public class MainRestController {

    private final StudentRepo studentRepo;
    private final FacultyRepo facultyRepo;
    private final JmsSender jmsSender;

    @Autowired
    public MainRestController(StudentRepo studentRepo, FacultyRepo facultyRepo, JmsSender jmsSender) {
        this.studentRepo = studentRepo;
        this.facultyRepo = facultyRepo;
        this.jmsSender = jmsSender;
    }

    @GetMapping(value = "/studentsJson", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Student> getAllStudent(){
        return this.studentRepo.findAll();
    }

    @GetMapping(value = "/facultiesJson", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Faculty> getAllFaculty(){
        return this.facultyRepo.findAll();
    }

    @GetMapping(value = "/studentsXml", produces = {MediaType.APPLICATION_XML_VALUE})
    public StudentXml getAllStudentsXml(){
        return new StudentXml((List<Student>) this.studentRepo.findAll());
    }

    @GetMapping(value = "/facultiesXml", produces = {MediaType.APPLICATION_XML_VALUE})
    public FacultyXml getAllFacultyXml(){
        return new FacultyXml((List<Faculty>) this.facultyRepo.findAll());
    }

    @PostMapping(value = "/studentsAdd")
    public String addStudent(@RequestBody @ModelAttribute("student") Student student){
        jmsSender.sendObjectUpdate(student, "ADD");
        String body = "Add Student: " + student.toString();
        Email email = new Email(UUID.randomUUID().toString(), body);
        jmsSender.sendEmail(email);
        studentRepo.save(student);
        return "redirect:/students";
    }

    @PostMapping(value = "/facultiesAdd")
    public String addFaculty(@ModelAttribute("faculty") Faculty faculty){
        jmsSender.sendObjectUpdate(faculty, "ADD");
        String body = "Add Faculty: " + faculty.toString();
        Email email = new Email(UUID.randomUUID().toString(), body);
        jmsSender.sendEmail(email);
        facultyRepo.save(faculty);
        return "redirect:/faculties";
    }

    @DeleteMapping(value = "/studentsDelete/{id}")
    public String deleteStudent(@PathVariable("id") int id){
        Student student = this.studentRepo.findById(id).orElse(null);
        if (student==null)
            return null;
        jmsSender.sendObjectUpdate(student, "DELETE");
        String body = "Delete Student: " + student.toString();
        Email email = new Email(UUID.randomUUID().toString(), body);
        jmsSender.sendEmail(email);
        studentRepo.delete(student);
        return "redirect:/students";
    }

    @DeleteMapping(value = "/facultiesDelete/{id}")
    public String deleteFaculty(@PathVariable("id") int id){
        Faculty faculty = this.facultyRepo.findById(id).orElse(null);
        if (faculty==null)
            return null;
        jmsSender.sendObjectUpdate(faculty, "DELETE");
        String body = "Delete Faculty: " + faculty.toString();
        Email email = new Email(UUID.randomUUID().toString(), body);
        jmsSender.sendEmail(email);
        facultyRepo.delete(faculty);
        return "redirect:/faculties";
    }
}
