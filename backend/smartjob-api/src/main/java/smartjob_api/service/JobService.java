package smartjob_api.service;

import smartjob_api.entity.Job;
import smartjob_api.repository.JobRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }
    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    public Job updateJob(Long id, Job jobDetails) {
        Job existingJob = jobRepository.findById(id).orElse(null);
        if (existingJob != null) {
            existingJob.setTitle(jobDetails.getTitle());
            existingJob.setDescription(jobDetails.getDescription());
            existingJob.setLocation(jobDetails.getLocation());
            existingJob.setContractType(jobDetails.getContractType());
            existingJob.setSalaryMin(jobDetails.getSalaryMin());
            existingJob.setSalaryMax(jobDetails.getSalaryMax());
            existingJob.setRemote(jobDetails.isRemote());
            existingJob.setStatus(jobDetails.getStatus());

            return jobRepository.save(existingJob);
        }
        return null;
    }
    public Job deleteJob(Long id) {
        Job existingJob = jobRepository.findById(id).orElse(null);
        if (existingJob != null) {
            jobRepository.delete(existingJob);
            return existingJob;
        }
        return null;
    }
}
