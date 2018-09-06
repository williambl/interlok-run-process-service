package com.williambl.interlok.services;

import java.util.*;
import com.adaptris.core.*;

public class RunProcessServiceTest extends ServiceCase {

    public RunProcessServiceTest(java.lang.String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
    }

    public void testService() throws Exception {
        HashMap<String, String> environ = new HashMap<String, String>();
        environ.put("KEY", "value");

        RunProcessService service = new RunProcessService();
        service.setCommand("ls");
        service.setDirectory("/home/william/dev/Interlok/bin/Interlok");
        service.setEnvironVars(environ);
        execute(service, AdaptrisMessageFactory.getDefaultInstance().newMessage());
    }

    @Override
    protected Object retrieveObjectForSampleConfig() {
        HashMap<String, String> environ = new HashMap<String, String>();
        environ.put("KEY", "value");

        RunProcessService service = new RunProcessService();
        service.setCommand("ls");
        service.setDirectory("/home/william/dev/Interlok/bin/Interlok");
        service.setEnvironVars(environ);

        return service;
    }

}
