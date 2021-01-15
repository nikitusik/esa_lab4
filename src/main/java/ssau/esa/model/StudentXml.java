package ssau.esa.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "students")
public class StudentXml {

    @XmlElement
    List<Student> student = new ArrayList<>();

    public StudentXml(){ }

    public StudentXml(List<Student> students) {
        this.student = students;
    }

    public List<Student> getStudents() {
        return student;
    }

}
