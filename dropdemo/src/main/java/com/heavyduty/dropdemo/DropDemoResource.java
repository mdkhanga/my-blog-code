package com.heavyduty.dropdemo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.Date;

@Path("/dropdemo")
public class DropDemoResource {

    public DropDemoResource() {

    }

    @GET
    @Path("/time")
    public String getTime() {
        Date d = new Date() ;
        return d.toString() ;
    }


}
