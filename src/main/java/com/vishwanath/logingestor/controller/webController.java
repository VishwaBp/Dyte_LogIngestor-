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
        List<String> asd = new ArrayList<>();
        asd.add(("test"));
        model.addAttribute("Logs",requestLogs);
         return "results";
    }
}
