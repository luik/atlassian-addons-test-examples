package com.milkneko.dev.confluence_4_rest_service.rest;

import com.milkneko.dev.confluence_4_rest_service.api.StorageComponent;
import com.milkneko.dev.confluence_4_rest_service.bean.RecordBean;
import com.milkneko.dev.confluence_4_rest_service.rest.interchange_object.RecordInterchangeObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("record")
public class TestRest {

    private StorageComponent storageComponent;
    private Logger logger = LoggerFactory.getLogger(getClass());

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response putRecord(RecordInterchangeObject recordInterchangeObject) throws Exception{

        logger.info("Getting object " + recordInterchangeObject);

        storageComponent.setRecordBean(new RecordBean(recordInterchangeObject.getId(), recordInterchangeObject.getValue()));

        return getRecord();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRecord() throws Exception{
        RecordBean recordBean = storageComponent.getRecordBean();

        return Response.ok(new RecordInterchangeObject(recordBean.getId(), recordBean.getValue())).cacheControl(CacheControl.valueOf("no-store")).build();
    }

    public void setStorageComponent(StorageComponent storageComponent) {
        this.storageComponent = storageComponent;
    }
}
