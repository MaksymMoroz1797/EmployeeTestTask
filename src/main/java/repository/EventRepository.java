package repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("eventRepository")
public interface EventRepository extends CrudRepository<Event,Long> {
}
