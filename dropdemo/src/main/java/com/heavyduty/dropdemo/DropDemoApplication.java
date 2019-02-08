package com.heavyduty.dropdemo;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DropDemoApplication extends Application<DropDemoConfiguration> {

    public static void main(String[] args) throws Exception {
        new DropDemoApplication().run(args);
    }

    @Override
    public String getName() {
        return "dropdemo";
    }

    @Override
    public void initialize(Bootstrap<DropDemoConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(DropDemoConfiguration configuration,
                    Environment environment) {
        // nothing to do yet
        final DropDemoResource dropDemoResource = new DropDemoResource() ;
        final DropDemoHealthCheck dropDemoHealthCheck = new DropDemoHealthCheck() ;

        environment.healthChecks().register("template", dropDemoHealthCheck);
        environment.jersey().register(dropDemoResource);

    }


}
