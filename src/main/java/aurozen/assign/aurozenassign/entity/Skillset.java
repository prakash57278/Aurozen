package aurozen.assign.aurozenassign.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.ToString;

import javax.persistence.*;

@Entity
public class Skillset {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String skillid;

    private String skillname;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "empid", nullable = false)
    private Employee employee;

    public String getSkillid() {
        return skillid;
    }

    public void setSkillid(String skillid) {
        this.skillid = skillid;
    }

    public String getSkillname() {
        return skillname;
    }

    public void setSkillname(String skillname) {
        this.skillname = skillname;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Skillset{" +
                "skillid='" + skillid + '\'' +
                ", skillname='" + skillname + '\'' +
//                ", employee=" + employee +
                '}';
    }
}
