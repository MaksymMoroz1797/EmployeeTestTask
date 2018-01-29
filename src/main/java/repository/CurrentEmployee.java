package repository;

import javax.persistence.*;

@Entity
@Table(name="currentemployees")
public class CurrentEmployee {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="employees")
    private String firstName;

    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="employees")
    private String lastName;

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
}
