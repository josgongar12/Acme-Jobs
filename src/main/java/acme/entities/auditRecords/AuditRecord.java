//
//package acme.entities.auditRecords;
//
//import java.util.Date;
//
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Past;
//
//import acme.framework.entities.DomainEntity;
//
//public class AuditRecord extends DomainEntity {
//
//	//-	The system must store audit records regarding the jobs.  For every audit record, the system must store a title,
//	//a status, a creation moment, and a body.
//	//The status can be either “draft”, if the audit record is not ready to be shown publicly, or “published”, otherwise.
//
//	// Serialization identifier -----------------------------------------------
//	private static final long	serialVersionUID	= 1L;
//
//	//Atributes----------------------------------
//
//	@NotBlank
//	private String				title;
//
//	@NotBlank
//	private String				status;
//
//	@NotNull
//	@Temporal(TemporalType.TIMESTAMP)
//	@Past
//	private Date				creationMoment;
//
//	@NotBlank
//	private String				body;
//
//}
