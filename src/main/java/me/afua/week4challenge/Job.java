package me.afua.week4challenge;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Job {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    private String position;

    private String company;

    private String requirements;

    private String desiredSkills;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getDesiredSkills() {
        return desiredSkills;
    }

    public void setDesiredSkills(String desiredSkills) {
        this.desiredSkills = desiredSkills;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", position='" + position + '\'' +
                ", company='" + company + '\'' +
                ", requirements='" + requirements + '\'' +
                ", desiredSkills='" + desiredSkills + '\'' +
                '}';
    }
}
