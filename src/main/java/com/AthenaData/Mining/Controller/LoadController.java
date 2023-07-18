package com.AthenaData.Mining.Controller;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wayne
 * @Date 17/07/2023
 */
@RestController
public class LoadController {

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job job;


  /*  @GetMapping
    public BatchStatus load(){

        Map<String, Long> maps = new HashMap<>();
        maps.put("time", System.currentTimeMillis());
        JobParameters parameters = new JobParameters(maps);
        JobExecution jobExecution = null;
        try {
            jobExecution = jobLauncher.run(job, parameters);
            System.out.println("Job's Status:::: " + jobExecution.getStatus() + " Time:" + new Date(System.currentTimeMillis()));
        } catch (JobExecutionAlreadyRunningException e) {
            e.printStackTrace();
        } catch (JobRestartException e) {
            e.printStackTrace();;
        } catch (JobInstanceAlreadyCompleteException e) {
            e.printStackTrace();
        } catch (JobParametersInvalidException e) {
            e.printStackTrace();
        }

        System.out.println("JobExecution:::: " + jobExecution.getStatus());

        System.out.println("Batch is Running...");
        while (jobExecution.isRunning()) {
            System.out.println("...");
        }

        return jobExecution.getStatus();
    }*/
}
