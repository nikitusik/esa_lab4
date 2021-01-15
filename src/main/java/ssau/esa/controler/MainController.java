package ssau.esa.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ssau.esa.model.Faculty;
import ssau.esa.model.Student;
import ssau.esa.repo.FacultyRepo;
import ssau.esa.repo.StudentRepo;

@Controller
public class MainController {

    @Autowired
    private FacultyRepo facultyRepo;

    @Autowired
    private StudentRepo studentRepo;

    @RequestMapping(value = {"/","/enter"})
    public String mainPage(Model model){
        model.addAttribute("name","Enter");
        return "enter";
    }

    @RequestMapping(value = "/faculties", method = RequestMethod.GET)
    public Iterable<Faculty> getAllFaculty(Model model){
        Iterable<Faculty> faculties = this.facultyRepo.findAll();
        model.addAttribute("faculties", faculties);
        return faculties;
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public Iterable<Student> getAllStudents(Model model){
        Iterable<Student> students = this.studentRepo.findAll();
        model.addAttribute("students", students);
        return students;
    }
}