package ut.com.milkneko.dev.jira_5_workflow_condition;

import org.junit.Test;
import com.milkneko.dev.jira_5_workflow_condition.api.MyPluginComponent;
import com.milkneko.dev.jira_5_workflow_condition.impl.MyPluginComponentImpl;

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