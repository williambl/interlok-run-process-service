package com.williambl.interlok.services;

import java.io.*;
import java.util.*;

import com.adaptris.core.*;
import com.adaptris.core.util.*;
import com.adaptris.annotation.*;

import org.hibernate.validator.constraints.NotBlank;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Service which runs an operating system process.
 *
 * <p>
 * This can be a very bad security risk. <strong>It can run arbitrary code!</strong>
 * Be <em>extremely</em> careful with this service.
 * </p>
 * @see java.lang.ProcessBuilder
 */

@XStreamAlias("run-process-service")
@ComponentProfile(summary="Run a command-line process", tag="service,process")
public class RunProcessService extends ServiceImp {

    @NotBlank
    @InputFieldHint(expression = true)
    private String command;

    @NotBlank
    @InputFieldHint(expression = true)
    private String directory;

    private HashMap<String, String> environVars;

    /**
     * @see com.adaptris.core.Service#doService(AdaptrisMessage) 
     */
    public void doService(AdaptrisMessage msg) throws ServiceException {

        // The scary-looking regex will split the string on spaces
        // unless that space is escaped by a backslash.
        String[] args = msg.resolve(command)
            .split("(?<=(?<!\\\\)(\\\\\\\\){0,100}) ");

        ProcessBuilder pb = new ProcessBuilder(Arrays.asList(args));

        pb.directory(new File(msg.resolve(directory)));

        pb.environment().putAll(environVars);

        try {
            Process p = pb.start();
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }
    }

    public final void prepare () {}

    public final void initService () {}

    public final void closeService () {}

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

    public void setEnvironVars (HashMap<String, String> environVarsIn) {
        this.environVars = environVarsIn;
    }

    public HashMap<String, String> getEnvironVars () {
        return this.environVars;
    }
}
