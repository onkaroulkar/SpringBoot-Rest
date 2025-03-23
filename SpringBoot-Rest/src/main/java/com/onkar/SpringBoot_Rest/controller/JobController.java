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

    @GetMapping(path ="jobPosts", produces={"application/json"})
    public List<JobPost> getAllJobs(){
        return jobService.getAllJobs();
    }

    @PostMapping(path="addJobs",consumes = {"application/xml"})
    public void addJobs(@RequestBody JobPost jobPost){
        jobService.addJob(jobPost);
    }

    @GetMapping("jobPost/{jobPostId}")
    public JobPost getJob(@PathVariable("jobPostId") int postId){
        return jobService.getJob(postId);
    }

    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost){
        jobService.updateJob(jobPost);
        return jobService.getJob(jobPost.getPostId());
    }

    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable int postId){
        jobService.deleteJob(postId);
    return "Deleted";
    }
}
