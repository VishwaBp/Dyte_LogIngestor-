package com.vishwanath.logingestor.controller;

import com.vishwanath.logingestor.DTOS.RequestLog;
import com.vishwanath.logingestor.DTOS.RequestQueryLog;
import com.vishwanath.logingestor.services.LoggerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class LoggerController {

    LoggerService logservice;

    public LoggerController(LoggerService logservice){
        this.logservice = logservice;
    }

    @PostMapping("saveLogs")
    public String  injectLog(@RequestBody RequestLog logrRquest){
       return  logservice.insertLog(logrRquest);
    }

    @GetMapping("searchLogs")
    public List<RequestLog> queryLog(@RequestBody RequestQueryLog logrRquest){
        return logservice.queryName(logrRquest);
    }








}
