package com.vishwanath.logingestor.controller;

import com.vishwanath.logingestor.DTOS.RequestLog;
import com.vishwanath.logingestor.DTOS.RequestQueryLog;
import com.vishwanath.logingestor.services.LoggerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class webController {


    LoggerService logservice;

    public webController(LoggerService logservice){
        this.logservice = logservice;
    }

    @RequestMapping(value = "/query")
    public String returnQuery(Model model){


model.addAttribute("request", new RequestQueryLog());
        return "query";
    }

    @PostMapping("/search")
    public String  searchQuery(Model model ,@ModelAttribute("Query")RequestQueryLog requestQueryLog){
         List<RequestLog>  requestLogs = logservice.queryName(requestQueryLog);

        model.addAttribute("Logs",requestLogs);
         return "results";
    }


    @RequestMapping(value = "/query1")
    public String returnQuery1(Model model){

        List<RequestLog> requestLogs = new ArrayList<>();
        model.addAttribute("Logs",requestLogs);
        model.addAttribute("request", new RequestQueryLog());
        model.addAttribute("formSubmitted", false);
        return "test";
    }

    @PostMapping("/search1")
    public String  searchQuery1(Model model ,@ModelAttribute("Query")RequestQueryLog requestQueryLog){
        List<RequestLog>  requestLogs = logservice.queryName(requestQueryLog);
        model.addAttribute("request", requestQueryLog);
        model.addAttribute("Logs",requestLogs);
        model.addAttribute("formSubmitted", true);
        return "test";
    }
}
