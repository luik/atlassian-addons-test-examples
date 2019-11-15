package ut.com.milkneko.dev.jira_5_workflow_validator;

import org.junit.Test;
import com.milkneko.dev.jira_5_workflow_validator.api.MyPluginComponent;
import com.milkneko.dev.jira_5_workflow_validator.impl.MyPluginComponentImpl;

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