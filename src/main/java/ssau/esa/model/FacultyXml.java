package ssau.esa.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "faculties")
public class FacultyXml {

    @XmlElement
    List<Faculty> faculty = new ArrayList<>();

    public FacultyXml(){ }

    public FacultyXml(List<Faculty> faculties) {
        this.faculty = faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculty = faculties;
    }

}
