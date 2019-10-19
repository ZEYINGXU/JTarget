package com.watermelon.jtarget;

import com.watermelon.jtarget.job.dto.JobDTO;
import com.watermelon.jtarget.job.service.JobService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JtargetApplicationTests {

    @Autowired
    private JobService jobService;

    @Test
    public void contextLoads() {
        JobDTO job = jobService.findJob("123");
        System.out.println(job);
    }

}
