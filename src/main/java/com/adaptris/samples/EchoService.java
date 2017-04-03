
package com.adaptris.samples;

import com.adaptris.core.*;
import com.adaptris.core.util.*;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("echo-service")
public class EchoService extends ServiceImp {
  public void doService(AdaptrisMessage msg) throws ServiceException {
    System.out.println("Hello World");
  }

  public final void prepare() {
  }

  public final void initService() {
  }

  public final void closeService() {
  }
}