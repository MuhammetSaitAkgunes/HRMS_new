package kodlamaio.hrms.api.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobAdvertisements")
public class JobAdvertisementController {
	private JobAdvertisementService jobAdvertisementService;
	
	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll(){
		return this.jobAdvertisementService.getAll();
	}
	
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@GetMapping("/getactive")
	public DataResult<List<JobAdvertisement>> getActive(){
		return this.jobAdvertisementService.getActive();
	}
	
	@GetMapping("/getcompanyandactive")
	public DataResult<List<JobAdvertisement>> getCompanyAndActive(int id){
		return this.jobAdvertisementService.getCompanyAdvertisement(id);
	}
	
	@GetMapping("/getdateorder")
	public DataResult<List<JobAdvertisement>> getDateOrder(){
		return this.jobAdvertisementService.getDateOrder();
	}
	
	@PostMapping("/update")
	public Result update(@RequestParam int id,@RequestParam boolean value_,@RequestParam int count,@RequestParam String description,@RequestParam int smin,@RequestParam int smax) {
		return this.jobAdvertisementService.update(id, value_, count, description, smin, smax);
	}
}
