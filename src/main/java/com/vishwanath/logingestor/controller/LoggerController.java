package com.vishwanath.logingestor.controller;

import com.vishwanath.logingestor.DTOS.RequestLog;
import com.vishwanath.logingestor.DTOS.RequestQueryLog;
import com.vishwanath.logingestor.services.LoggerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class LoggerController {

    LoggerService logservice;

    public LoggerController(LoggerService logservice){
        this.logservice = logservice;
    }

    @PostMapping
    public String  injectLog(@RequestBody RequestLog logrRquest){
       return  logservice.insertLog(logrRquest);
    }

    @GetMapping
    public String queryLog(@RequestBody RequestQueryLog logrRquest){
        return logservice.queryName(logrRquest);
    }








}
