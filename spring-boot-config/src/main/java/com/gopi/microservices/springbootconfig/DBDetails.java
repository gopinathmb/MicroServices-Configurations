/**
 * Created by gopinath_mb on 28-May-2020
 */
package com.gopi.microservices.springbootconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author gopinath_mb
 */
@Configuration
@ConfigurationProperties("db")
public class DBDetails
{

  private String host;

  private int port;

  private String type;

  public String getHost()
  {
    return host;
  }

  public void setHost(String host)
  {
    this.host = host;
  }

  public int getPort()
  {
    return port;
  }

  public void setPort(int port)
  {
    this.port = port;
  }

  public String getType()
  {
    return type;
  }

  public void setType(String type)
  {
    this.type = type;
  }

}
