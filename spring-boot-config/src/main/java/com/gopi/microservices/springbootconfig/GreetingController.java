/**
 * Created by gopinath_mb on 28-May-2020
 */
package com.gopi.microservices.springbootconfig;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gopinath_mb
 */
@RestController
@RefreshScope
public class GreetingController
{

  @Value("SimplySetThisValue")
  private String assignGreetingMessage;

  @Value("${my.greetings}")
  private String greetingMessage;

  @Value("${my.greetingss:Default Value Read as there is no such property}")
  private String greetingDefaultMessage;

  @Value("${greetings.list}")
  private List<String> greetings;

  @Value("#{${greetings.map}}")
  private Map<String, String> greetingsMap;

  @Autowired
  private DBDetails dbDetails;
  
  @Autowired
  private Environment environment;

  @GetMapping("/greeting")
  public String greetings()
  {
    return greetingMessage + "==>" + greetingDefaultMessage + "==>" + greetings
        + "==>" + greetingsMap;
  }

  @GetMapping("/dbDetails")
  public String dbDetails()
  {
    return dbDetails.getHost() + "==>" + dbDetails.getPort() + "==>"
        + dbDetails.getType();
  }
  
  @GetMapping("/envDetails")
  public String envDetails()
  {
    return environment.toString();
  }
}
