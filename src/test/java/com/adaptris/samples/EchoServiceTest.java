package com.adaptris.samples;

import com.adaptris.core.*;

public class EchoServiceTest extends ServiceCase {

  public EchoServiceTest(java.lang.String testName) {
    super(testName);
  }

  @Override
  protected void setUp() throws Exception {
  }

  public void testService() throws Exception {
    execute(new EchoService(), AdaptrisMessageFactory.getDefaultInstance().newMessage());
  }

  @Override
  protected Object retrieveObjectForSampleConfig() {
    return new EchoService();
  }

}
