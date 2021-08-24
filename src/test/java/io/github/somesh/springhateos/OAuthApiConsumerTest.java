package io.github.somesh.springhateos;

import io.github.somesh.springhateos.app.OAuthApiConsumer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OAuthApiConsumerTest {

  @Autowired
  private OAuthApiConsumer consumer;

  @Test
  public void testOauthCall(){
    String response = consumer.getOauthResponse();
    Assertions.assertNotNull(response);
  }


}
