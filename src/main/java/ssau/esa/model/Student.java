package ssau.esa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement(name = "student")
@Table(name = "STUDENT")
@Data
public class Student implements BasicModel{
    @Id
    @Column(name = "mobile_phone", nullable = false, length = 100)
    private int mobile;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "surname", nullable = false, length = 100)
    private  String surname;

    @Column(name = "course", nullable = false)
    private int course;

    @ManyToOne(optional = false, cascade = {CascadeType.ALL})
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    public Student(){}

    @Override
    @JsonIgnore
    public int getId() {
        return mobile;
    }

    @Override
    @JsonIgnore
    public String getTableName() {
        return "students";
    }
}
