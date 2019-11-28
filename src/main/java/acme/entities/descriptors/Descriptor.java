
package acme.entities.descriptors;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class Descriptor extends DomainEntity {

	@NotBlank
	String description;

	// Duty duty;

}
