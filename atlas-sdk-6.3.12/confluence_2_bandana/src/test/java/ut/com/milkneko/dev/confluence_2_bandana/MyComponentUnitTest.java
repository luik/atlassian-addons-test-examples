package ut.com.milkneko.dev.confluence_2_bandana;

import org.junit.Test;
import com.milkneko.dev.confluence_2_bandana.api.MyPluginComponent;
import com.milkneko.dev.confluence_2_bandana.impl.MyPluginComponentImpl;

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