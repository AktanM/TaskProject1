package peaksoft.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseName;
    private String duration;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "group_course",
            joinColumns = @JoinColumn(name ="group_id" ),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Group> group;

    @OneToOne(mappedBy = "course",
            cascade = CascadeType.ALL)
    private Teacher teacher;

    public Course() {
    }

    public Course(String courseName, String duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Group> getGroup() {
        return group;
    }

    public void setGroup(List<Group> group) {
        this.group = group;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", duration='" + duration + '\'' +
                ", company=" + company +
                ", group=" + group +
                ", teacher=" + teacher +
                '}';
    }
}
