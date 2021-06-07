package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "job_advertisements")
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisement {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="jobadvertisement_id")
	@PrimaryKeyJoinColumn
	private int jobadvertisement_id;
	
	@Column(name="job_description")
	private String job_description;
	
	@Column(name="job_count")
	private int job_count;
	
	//@Column(name="job_cityid")
	//private int job_cityid;
	
	@Column(name="job_date")
	private LocalDate job_date;
	
	//@Column(name="job_company_id")
	//private int job_company_id;
	
	@Column(name = "job_salarymax")
	private double job_salarymax;
	
	@Column(name = "job_salarymin")
	private double job_salarymin;
	
	@Column(name="job_listdate")
	private LocalDate job_listdate;
	
	//@Column(name="job_position_id")
	//private int job_position_id;
	
	@Column(name="job_active")
	private boolean job_active;
	
	@ManyToOne(targetEntity = Employers.class,fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "job_company_id")
	private Employers employer;
	
	@ManyToOne(targetEntity = City.class,fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "job_cityid")
	private City city;

	@ManyToOne(targetEntity = JobPosition.class,fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "job_position_id")
	private JobPosition jobPosition;
}
