package smartjob_api.controller;

import smartjob_api.entity.Job;
import smartjob_api.service.JobService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }
    @GetMapping("/{id}")
    public Job GetJobById(
        @PathVariable Long id
        ) {
        return jobService.getJobById(id);
    }
    @PostMapping
    public Job createJob(
        @RequestBody Job job
        ) {
        return jobService.createJob(job);
    }
    @PutMapping("/{id}")
    public Job updateJob(
        @PathVariable Long id,
        @RequestBody Job jobDetails
        ) {
        return jobService.updateJob(id, jobDetails);
}
    @DeleteMapping("/{id}")
    public Job deleteJob(@PathVariable Long id) {
 return jobService.deleteJob(id);
    }
}