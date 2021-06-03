package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	List<JobAdvertisement> getAll();
	DataResult<List<JobAdvertisement>> getActive();
	List<JobAdvertisement> getCompanyAdvertisement();
	Result add(JobAdvertisement jobAdvertisement);
	Result delete(JobAdvertisement jobAdvertisement);
	Result update(JobAdvertisement jobAdvertisement);
}
