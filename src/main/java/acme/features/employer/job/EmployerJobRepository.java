
package acme.features.employer.job;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;

import acme.entities.jobs.Job;
import acme.framework.repositories.AbstractRepository;

public interface EmployerJobRepository extends AbstractRepository {

	@Query("select j from Job j where j.id = ?1")
	Job findJobById(int id);

	@Query("select j from Job j")
	Collection<Job> findMany();

}
