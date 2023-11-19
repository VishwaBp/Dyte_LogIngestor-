package com.vishwanath.logingestor.DTOS;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document("Log")
public class RequestQueryLog {
    private String level;
    private String message;
    private String resourceId;
    private String startTimestamp;
    private String endTimestamp;
    private String traceId;
    private String spanId;
    private String commit;
    private String parentResourceId;

}
