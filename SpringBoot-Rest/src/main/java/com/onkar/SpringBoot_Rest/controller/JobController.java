package com.onkar.SpringBoot_Rest.controller;
import com.onkar.SpringBoot_Rest.model.JobPost;
import com.onkar.SpringBoot_Rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping("jobPosts")
    public List<JobPost> getAllJobs(){
        return jobService.getAllJobs();
    }

    @PostMapping("addJobs")
    public void addJobs(@RequestBody JobPost jobPost){
        jobService.addJob(jobPost);
    }

    @GetMapping("jobPost/{jobPostId}")
    public JobPost getJob(@PathVariable("jobPostId") int postId){
        return jobService.getJob(postId);
    }
}
