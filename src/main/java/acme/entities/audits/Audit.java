
package acme.entities.audits;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import acme.entities.jobs.Job;
import acme.entities.roles.Auditor;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Audit extends DomainEntity {

	// Serialization identifier -----------------------------------------------
	private static final long	serialVersionUID	= 1L;

	//Attributes ----------------------------------

	@NotBlank
	private String				title;

	private boolean				status;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date				creationMoment;

	@NotBlank
	private String				body;

	// Relationships ----------------------------------------------------------------

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private Auditor				auditor;

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private Job					job;

}
