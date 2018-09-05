
package com.williambl.interlok.services;

import com.adaptris.core.*;
import com.adaptris.core.util.*;
import org.hibernate.validator.constraints.NotBlank;
import java.io.*;
import java.util.Arrays;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("run-process-service")
public class RunProcessService extends ServiceImp {

    @NotBlank
    private String command;

    @NotBlank
    private String directory;

    public void doService(AdaptrisMessage msg) throws ServiceException {

        // This scary-looking regex will split the string on spaces
        // unless that space is escaped by a backslash.
        String[] args = command.split("(?<=(?<!\\\\)(\\\\\\\\){0,100}) ");

        ProcessBuilder pb = new ProcessBuilder(Arrays.asList(args));
        pb.directory(new File(directory));
        try {
            Process p = pb.start();
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }
    }

    public final void prepare() {
    }

    public final void initService() {
    }

    public final void closeService() {
    }

    public void setCommand (String commandIn) {
        this.command = commandIn;
    }

    public String getCommand () {
        return this.command;
    }

    public void setDirectory (String directoryIn) {
        this.directory = directoryIn;
    }

    public String getDirectory () {
        return this.directory;
    }

}
