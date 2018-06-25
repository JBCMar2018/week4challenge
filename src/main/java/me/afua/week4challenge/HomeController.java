package me.afua.week4challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @Autowired
    JobRepository jobs;

//    Default route  - this will be the first page a user visits


    @RequestMapping("/")
    public @ResponseBody String homePage()
    {
        return "homePage";
    }
//    Add Job - this will show the 'add job' html form
    @RequestMapping("/addjob")
    public String addJob(Model model)
    {
        model.addAttribute("aJob",new Job());
        return "addjob";
    }

//    Save Job - this will save the job to the database
    @RequestMapping("/savejob")
    public  String saveJob(@ModelAttribute("aJob") Job theJob)
    {
        jobs.save(theJob);
        return "redirect:/listjobs";
    }
//    List jobs - show all jobs in the database
    @RequestMapping("/listjobs")
    public String listJobs(Model model)
    {
        model.addAttribute("alljobs",jobs.findAll());
        return "listjobs";
    }

    @RequestMapping("/show/{id}")
    public String showDetailFor(@PathVariable("id") long id, Model model)
    {
        model.addAttribute("aJob",jobs.findById(id).get());
        return "showjob";
    }


    @RequestMapping("/testapp")
    public @ResponseBody  String testApp()
    {
        Job aJob = new Job();

        aJob.setPosition("Full Stack Developer");
        aJob.setCompany("My Company");
        aJob.setRequirements("Full stack developer. Must be able to program in Java, as well as HTML, CSS & Javascript");
        aJob.setDesiredSkills("JAVA, SQL, HTML, CSS");
        jobs.save(aJob);
        System.out.println(aJob.toString());


        aJob = new Job();
        aJob.setCompany("Second company");
        aJob.setPosition("Full Stack Developer");
        aJob.setRequirements("Full stack developer. Must be able to program in Java, as well as HTML only");
        aJob.setDesiredSkills("JAVA, HTML");
        jobs.save(aJob);
        System.out.println(aJob.toString());



//        for(Job eachJob:jobs.findAll())
//        {
//            System.out.println(eachJob.getPosition());
//        }




        return "check your console/database";
    }
}
