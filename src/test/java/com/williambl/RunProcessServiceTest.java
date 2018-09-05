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
    RunProcessService service = new RunProcessService();
    service.setCommand("ls");
    service.setDirectory("/home/william/dev/Interlok/bin/Interlok");
    execute(service, AdaptrisMessageFactory.getDefaultInstance().newMessage());
  }

  @Override
  protected Object retrieveObjectForSampleConfig() {
    RunProcessService service = new RunProcessService();
    service.setCommand("ls");
    service.setDirectory("/home/william/dev/Interlok/bin/Interlok");
    return service;
  }

}
