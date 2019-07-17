package ut.com.milkneko.dev.confluence_1_velocity_templates;

import org.junit.Test;
import com.milkneko.dev.confluence_1_velocity_templates.api.MyPluginComponent;
import com.milkneko.dev.confluence_1_velocity_templates.impl.MyPluginComponentImpl;

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