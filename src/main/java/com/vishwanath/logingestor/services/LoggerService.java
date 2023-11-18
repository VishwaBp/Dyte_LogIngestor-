package com.vishwanath.logingestor.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vishwanath.logingestor.DTOS.RequestLog;
import com.vishwanath.logingestor.DTOS.RequestQueryLog;
import com.vishwanath.logingestor.repository.LogRepo;
import org.springframework.data.mongodb.core.MongoTemplate;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class LoggerService {

     ObjectMapper objMap;
     LogRepo logrepo;

     MongoTemplate mongoTemplate;

     public LoggerService(ObjectMapper obj,LogRepo logr, MongoTemplate mongoTemplate){
         this.objMap = obj;
         this.logrepo = logr;
         this.mongoTemplate = mongoTemplate;
     }
    public String  insertLog(RequestLog log) {
        try{
//            System.out.println(objMap.writeValueAsString(log));
//            logrepo.save(new nameDto();
            logrepo.save(log);
           return objMap.writeValueAsString(log);
        }
        catch(Exception e){
//            System.out.println("Exception Occured");
           return "error occured";
        }
    }
    public List<RequestLog> queryName(RequestQueryLog log){
         try{
             Query query =  new Query();
             if (log.getLevel() != null && !log.getLevel().isEmpty()) {
                 query.addCriteria(Criteria.where("level").is(log.getLevel()));
             }
             if (log.getMessage() != null && !log.getMessage().isEmpty()) {
                 query.addCriteria(Criteria.where("message").regex(log.getMessage(), "i"));
             }

             if (log.getResourceId() != null && !log.getResourceId().isEmpty()) {
                 query.addCriteria(Criteria.where("resourceId").is(log.getResourceId()));
             }

             if (log.getStartTimestamp() != null && log.getEndTimestamp() != null &&  !log.getStartTimestamp().isEmpty() && !log.getEndTimestamp().isEmpty()) {
                 query.addCriteria(Criteria.where("timestamp")
                         .gte(log.getStartTimestamp())
                         .lte(log.getEndTimestamp()));
             } else if (log.getStartTimestamp() != null && !log.getStartTimestamp().isEmpty()) {
                 query.addCriteria(Criteria.where("timestamp").gte(log.getStartTimestamp()));
             } else if (log.getEndTimestamp() != null && !log.getEndTimestamp().isEmpty()) {
                 query.addCriteria(Criteria.where("timestamp").lte(log.getEndTimestamp()));
             }

             if (log.getTraceId() != null && !log.getTraceId().isEmpty()) {
                 query.addCriteria(Criteria.where("traceId").is(log.getTraceId()));
             }

             if (log.getSpanId() != null && !log.getSpanId().isEmpty()) {
                 query.addCriteria(Criteria.where("spanId").is(log.getSpanId()));
             }

             if (log.getCommit() != null && !log.getCommit().isEmpty()) {
                 query.addCriteria(Criteria.where("commit").is(log.getCommit()));
             }

             if (log.getParentResourceId() != null && !log.getParentResourceId().isEmpty()) {
                 query.addCriteria(Criteria.where("metadata.parentResourceId").is(log.getParentResourceId()));
             }



           return  mongoTemplate.find(query,RequestLog.class);

//            List<RequestLog> nameDtoList =  logrepo.findByName("vishwa");
//            return objMap.writeValueAsString(nameDtoList);
         }
         catch(Exception e){
            return null;

         }
    }


}
