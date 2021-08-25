package io.github.somesh.springhateos;

import io.github.somesh.springhateos.app.ApiConsumer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ApiConsumerTest {

  @Autowired private ApiConsumer consumer;

  @Test
  public void testRestCall(){
    String response = consumer.getSampleApi(3);
    Assertions.assertNotNull(response);
  }
}
