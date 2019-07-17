package ut.com.milkneko.dev.confluence_3_admin_web_items;

import org.junit.Test;
import com.milkneko.dev.confluence_3_admin_web_items.api.MyPluginComponent;
import com.milkneko.dev.confluence_3_admin_web_items.impl.MyPluginComponentImpl;

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