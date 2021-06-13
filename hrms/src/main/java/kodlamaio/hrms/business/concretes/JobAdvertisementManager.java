package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.core.utilites.results.SuccessDataResult;
import kodlamaio.hrms.core.utilites.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {
	
	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(),"Tüm iş ilanları listelendi.");
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("İş ilanı eklendi.");
	}
	

	@Override
	public DataResult<List<JobAdvertisement>> getCompanyAdvertisement(int id) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByCompanyJobAndJobActive(id),"Seçili şirketin aktif ilanları listelendi.");
	}

	@Override
	public Result delete(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.delete(jobAdvertisement);
		return new SuccessResult("İş ilanı silindi.");
	}


	@Override
	public DataResult<List<JobAdvertisement>> getActive() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByJobActive(),"Tüm aktif ilanlar listelendi.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getDateOrder() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByJobActiveAndOrderByDeadlineDay());
	}


	@Override
	public Result update(int id, boolean value_, int count,
			String description, int smin, int smax) {
		JobAdvertisement jobAds = jobAdvertisementDao.findById(id);
		jobAds.setJob_active(value_);
		jobAds.setJob_count(count);
		jobAds.setJob_description(description);
		jobAds.setJob_salarymin(smin);
		jobAds.setJob_salarymax(smax);
		jobAds.setJob_date(LocalDate.now());
		jobAdvertisementDao.save(jobAds);
		return new SuccessResult("İş ilanı güncellendi.");
	}

		
}
