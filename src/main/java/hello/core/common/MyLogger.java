package hello.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope(value = "request")
public class MyLogger {
    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL){
        this.requestURL = requestURL;
    }

    public void log(String message){
        System.out.println("["+uuid+"]"+requestURL+"] "+message);
    }
    @PostConstruct
    public void init(){ //request와서 객체 생성하면 자동으로 init 콜백 시키면서  uuid 세팅
        uuid = UUID.randomUUID().toString();
        System.out.println("["+uuid+"] request scope been create: " + this);
    }

    @PreDestroy
    public void close(){
        System.out.println("["+uuid+"] request scope been close: " + this);
    }
}
