package repository;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="history")
public class Event {
    public static enum Action {
        CREATE, UPDATE, DELETE
    }

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    long id;

    @Column(name="action")
    Action action;

    @Column(name="date")
    Date date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
