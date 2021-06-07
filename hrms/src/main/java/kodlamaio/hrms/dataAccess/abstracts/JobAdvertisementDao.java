package kodlamaio.hrms.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
	
	@Query("From JobAdvertisement where job_active = true")
	List<JobAdvertisement> findByJobActive();
	
	@Query("From JobAdvertisement where job_active = true and job_company_id=:id")
	List<JobAdvertisement> findByCompanyJobAndJobActive(int id);
	
	@Query("From JobAdvertisement where job_active = true Order By job_date Desc")
	List<JobAdvertisement> findByJobActiveAndOrderByDeadlineDay();
	
	@Query("From JobAdvertisement where jobadvertisement_id=:id")
	JobAdvertisement findById(int id);
} 
