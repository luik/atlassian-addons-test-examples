package ut.com.milkneko.dev.jira_2_custom_searcher;

import org.junit.Test;
import com.milkneko.dev.jira_2_custom_searcher.api.MyPluginComponent;
import com.milkneko.dev.jira_2_custom_searcher.impl.MyPluginComponentImpl;

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