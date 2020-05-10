package aurozen.assign.aurozenassign.entity;

import lombok.ToString;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@ToString
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empid;

    private String empname;
    private Long empcontact;
    private String empemail;
    private String empphoto;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Skillset> skillset;

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public Long getEmpcontact() {
        return empcontact;
    }

    public void setEmpcontact(Long empcontact) {
        this.empcontact = empcontact;
    }

    public String getEmpemail() {
        return empemail;
    }

    public void setEmpemail(String empemail) {
        this.empemail = empemail;
    }

    public String getEmpphoto() {
        return empphoto;
    }

    public void setEmpphoto(String empphoto) {
        this.empphoto = empphoto;
    }

    public List<Skillset> getSkillset() {
        return skillset;
    }

    public void setSkillset(List<Skillset> skillset) {
        this.skillset = skillset;
        skillset.forEach(s -> s.setEmployee(this));
    }
}
