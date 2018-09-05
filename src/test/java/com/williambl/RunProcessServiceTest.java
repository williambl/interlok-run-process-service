package com.williambl.interlok.services;

import com.adaptris.core.*;

public class RunProcessServiceTest extends ServiceCase {

  public RunProcessServiceTest(java.lang.String testName) {
    super(testName);
  }

  @Override
  protected void setUp() throws Exception {
  }

  public void testService() throws Exception {
    execute(new RunProcessService(), AdaptrisMessageFactory.getDefaultInstance().newMessage());
  }

  @Override
  protected Object retrieveObjectForSampleConfig() {
    return new RunProcessService();
  }

}
