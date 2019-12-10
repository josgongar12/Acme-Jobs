
package acme.features.employer.duty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.duties.Duty;
import acme.entities.jobs.Job;
import acme.entities.roles.Employer;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class EmployerDutyShowService implements AbstractShowService<Employer, Duty> {

	// Internal state -------------------------------------------------------------

	@Autowired
	EmployerDutyRepository repository;


	// AbstractShowService<Employer, Duty> interface -------------------------------

	@Override
	public boolean authorise(final Request<Duty> request) {
		assert request != null;

		boolean result;
		int dutyId;
		Duty duty;
		Job job;
		Employer employer;
		Principal principal;

		dutyId = request.getModel().getInteger("id");
		duty = this.repository.findOneDutyById(dutyId);
		job = duty.getJob();
		employer = job.getEmployer();
		principal = request.getPrincipal();
		//		result = job.getStatus() == JobStatus.PUBLISHED || job.getStatus() == JobStatus.DRAFT && employer.getUserAccount().getId() == principal.getAccountId();

		result = job.getFinalMode() || !job.getFinalMode() && employer.getUserAccount().getId() == principal.getAccountId();

		return result;
	}

	@Override
	public void unbind(final Request<Duty> request, final Duty entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "dutyDescription", "percentage");
	}

	@Override
	public Duty findOne(final Request<Duty> request) {
		assert request != null;

		Duty result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneDutyById(id);

		return result;
	}

}
