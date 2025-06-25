package com.result.mvc.controllers;

import com.result.mvc.entities.Student;
import com.result.mvc.payload.FormStudent;
import com.result.mvc.service.ResultService;
import jakarta.persistence.PostPersist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/result")
public class resultController {
    @Autowired
    private ResultService resultService;

    @RequestMapping("/addResult")
    public String addResult(Model model){
        FormStudent student = new FormStudent();
        model.addAttribute("FormStudent",student);
        System.out.println("RESULT ADDED");
        return "addResult";
    }

    @RequestMapping(value="/processForm", method = RequestMethod.POST)
    public String submitResult(@ModelAttribute FormStudent formStudent, Model model){
        int id =  resultService.save(formStudent);
        model.addAttribute("id",id);
        return "result-success";
    }



    @RequestMapping(value = "/viewResult", method=RequestMethod.POST)
    public String viewResult(@RequestParam int rollNumber, Model model){
      Student studentMarks =  resultService.find((""+rollNumber).trim());
      if(studentMarks==null){
          return "notFound";
      }

      model.addAttribute("studentMarks",studentMarks);
        return "viewResult";
    }

//    @PostMapping("/viewResult")
//    public String viewResulta(@RequestParam int rollNumber, Model model){
////        @RequestParam("rollNumber") String rollNumber
//        Student studentMarks =  resultService.find((""+rollNumber).trim());
//        model.addAttribute("studentMarks",studentMarks);
//        return "viewResult";
//    }




}
