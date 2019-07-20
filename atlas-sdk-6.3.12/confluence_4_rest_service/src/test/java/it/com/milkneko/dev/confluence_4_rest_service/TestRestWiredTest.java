package it.com.milkneko.dev.confluence_4_rest_service;

import com.atlassian.plugins.osgi.test.AtlassianPluginsTestRunner;
import com.milkneko.dev.confluence_4_rest_service.api.StorageComponent;
import com.milkneko.dev.confluence_4_rest_service.rest.TestRest;
import com.milkneko.dev.confluence_4_rest_service.rest.interchange_object.RecordInterchangeObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;


@RunWith(AtlassianPluginsTestRunner.class)
public class TestRestWiredTest
{
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final StorageComponent storageComponent;
    private final TestRest testRest;

    public TestRestWiredTest(StorageComponent storageComponent)
    {
        this.storageComponent = storageComponent;

        this.testRest = new TestRest();
        this.testRest.setStorageComponent(this.storageComponent);
    }

    @Before
    public void setUp(){
        this.storageComponent.deleteRecordBean();
    }

    @Test
    public void testRest() throws Exception {
        RecordInterchangeObject recordInterchangeObject = new RecordInterchangeObject(10, "a value");

        testRest.putRecord(recordInterchangeObject);

        Response response = testRest.getRecord();
        recordInterchangeObject = (RecordInterchangeObject)response.getEntity();

        Assert.assertEquals(10, recordInterchangeObject.getId());
        Assert.assertEquals("a value", recordInterchangeObject.getValue());
    }


}