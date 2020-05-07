package aurozen.assign.aurozenassign.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employee {


    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empid;

    private String empname;

    private String empcontact;

    private String empemail;

    private String empphoto;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Skillset> skillset = new ArrayList<>();

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

    public String getEmpcontact() {
        return empcontact;
    }

    public void setEmpcontact(String empcontact) {
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
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empid=" + empid +
                ", empname='" + empname + '\'' +
                ", empcontact='" + empcontact + '\'' +
                ", empemail='" + empemail + '\'' +
                ", emphoto='" + empphoto + '\'' +
                ", skillset=" + skillset +
                '}';
    }
}
