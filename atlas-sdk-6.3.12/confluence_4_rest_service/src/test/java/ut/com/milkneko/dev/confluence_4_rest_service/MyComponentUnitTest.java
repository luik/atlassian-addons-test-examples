package ut.com.milkneko.dev.confluence_4_rest_service;

import org.junit.Test;
import com.milkneko.dev.confluence_4_rest_service.api.MyPluginComponent;
import com.milkneko.dev.confluence_4_rest_service.impl.MyPluginComponentImpl;

import static org.junit.Assert.assertEquals;

public class MyComponentUnitTest
{
    @Test
    public void testMyName()
    {
        MyPluginComponent component = new MyPluginComponentImpl(null);
        assertEquals("names do not match!", "myComponent",component.getName());
    }
}