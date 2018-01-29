package repository;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="employees")
public class Employee {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(name="firstName")
    private String firstName;

    @Column(name="secondName")
    private String lastName;

    @Column(name="firstName")
    private boolean isInCompany;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="history")
    List<Event> history;

    public boolean isInCompany() { return isInCompany; }

    public void setInCompany(boolean inCompany) { isInCompany = inCompany; }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Event> getHistory() {
        return history;
    }

    public void setHistory(List<Event> history) {
        this.history = history;
    }
}
