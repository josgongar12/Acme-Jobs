
package acme.features.authenticated.duty;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.duties.Duty;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedDutyListService implements AbstractListService<Authenticated, Duty> {

	// Internal state ---------------------------------------------------------------

	@Autowired
	AuthenticatedDutyRepository repository;


	// AbstractListService<Employer, Duty> interface ---------------------------------

	@Override
	public boolean authorise(final Request<Duty> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<Duty> request, final Duty entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "dutyDescription", "percentage", "job");
	}

	@Override
	public Collection<Duty> findMany(final Request<Duty> request) {
		assert request != null;

		Collection<Duty> result;
		int jobId;

		String[] cadena = request.getServletRequest().getQueryString().trim().split("=");
		jobId = Integer.parseInt(cadena[1]);

		result = this.repository.findManyByJobId(jobId);

		return result;
	}

}
