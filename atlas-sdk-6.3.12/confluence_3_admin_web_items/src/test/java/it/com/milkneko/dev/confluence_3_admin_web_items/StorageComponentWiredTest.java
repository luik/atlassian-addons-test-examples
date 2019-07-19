package it.com.milkneko.dev.confluence_3_admin_web_items;

import com.atlassian.plugins.osgi.test.AtlassianPluginsTestRunner;
import com.milkneko.dev.confluence_3_admin_web_items.bean.RecordBean;
import com.milkneko.dev.confluence_3_admin_web_items.api.StorageComponent;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(AtlassianPluginsTestRunner.class)
public class StorageComponentWiredTest
{
    private final StorageComponent storageComponent;

    public StorageComponentWiredTest(StorageComponent storageComponent)
    {
        this.storageComponent = storageComponent;
    }

    @Before
    public void setUp(){
        this.storageComponent.deleteRecordBean();
    }

    @Test
    public void testStorageComponent()
    {
        RecordBean recordBean = this.storageComponent.getRecordBean();
        assertNotNull(recordBean);
        assertFalse(recordBean.isStored());

        recordBean = new RecordBean(10, new Date().toString());
        this.storageComponent.setRecordBean(recordBean);

        recordBean = this.storageComponent.getRecordBean();

        assertEquals(10, recordBean.getId());
        assertNotNull(recordBean.getValue());
        assertTrue(recordBean.isStored());
    }
}