package com.heavyduty.dropdemo;

import com.codahale.metrics.health.HealthCheck;

public class DropDemoHealthCheck extends HealthCheck {

    public DropDemoHealthCheck() {

    }

    @Override
    protected Result check() throws Exception {

        // Add the healthcheck impl here
        // for eg. are we able to connect to database

        return Result.healthy();
    }
}
