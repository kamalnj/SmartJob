package smartjob_api.repository;

import smartjob_api.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
    // Custom query methods can be defined here if needed
}