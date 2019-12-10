
package acme.features.authenticated.job;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.jobs.Job;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedJobShowService implements AbstractShowService<Authenticated, Job> {

	// Internal state -------------------------------------------------------------

	@Autowired
	AuthenticatedJobRepository repository;


	// AbstractShowService<Employer, Job> interface -------------------------------

	@Override
	public boolean authorise(final Request<Job> request) {
		assert request != null;

		boolean result = false;
		int jobId;
		Job job;
		Date dateActual, dateProperty;

		jobId = request.getModel().getInteger("id");
		job = this.repository.findOneJobById(jobId);

		dateActual = new Date();
		dateProperty = job.getDeadline();

		//		result = job.getStatus() == JobStatus.PUBLISHED && dateProperty.after(dateActual);
		result = job.getFinalMode() && dateProperty.after(dateActual);

		return result;
	}

	@Override
	public void unbind(final Request<Job> request, final Job entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "reference", "deadline", "title", "salary", "moreInfo", "description", "finalMode", "descriptorDescription");
	}

	@Override
	public Job findOne(final Request<Job> request) {
		assert request != null;

		Job result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneJobById(id);

		return result;
	}

}
