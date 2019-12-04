
package acme.entities.duties;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import acme.entities.jobs.Job;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Duty extends DomainEntity {

	// Serialisation identifier -------------------------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes ----------------------------------------------------------------------------------

	@NotBlank
	private String				title;

	@NotBlank
	private String				dutyDescription;

	@NotNull
	@Min(0)
	@Max(100)
	private Double				percentage;

	// Relationships --------------------------------------------------------------------------------

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private Job					job;

}
