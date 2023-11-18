package com.vishwanath.logingestor.repository;

import com.vishwanath.logingestor.DTOS.RequestLog;
import com.vishwanath.logingestor.DTOS.nameDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface LogRepo  extends MongoRepository<RequestLog,String> {
    @Query("{name : '?0'}")
    List<RequestLog> findByName(String name);
}
