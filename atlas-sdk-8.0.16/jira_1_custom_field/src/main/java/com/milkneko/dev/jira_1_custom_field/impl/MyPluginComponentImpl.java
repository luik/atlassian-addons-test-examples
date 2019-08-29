package com.milkneko.dev.jira_1_custom_field.impl;

import com.atlassian.jira.issue.customfields.converters.DoubleConverter;
import com.atlassian.jira.issue.customfields.searchers.transformer.CustomFieldInputHelper;
import com.atlassian.jira.jql.operand.JqlOperandResolver;
import com.atlassian.jira.util.I18nHelper;
import com.atlassian.jira.web.FieldVisibilityManager;
import com.atlassian.plugin.spring.scanner.annotation.export.ExportAsService;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import com.atlassian.sal.api.ApplicationProperties;
import com.milkneko.dev.jira_1_custom_field.api.MyPluginComponent;

import javax.inject.Inject;
import javax.inject.Named;

import static com.atlassian.jira.util.dbc.Assertions.notNull;

@ExportAsService ({MyPluginComponent.class})
@Named ("myPluginComponent")
public class MyPluginComponentImpl implements MyPluginComponent
{
    @ComponentImport
    private final ApplicationProperties applicationProperties;
    @ComponentImport
    private final FieldVisibilityManager fieldVisibilityManager;
    @ComponentImport
    private final JqlOperandResolver jqlOperandResolver;
    @ComponentImport
    private final DoubleConverter doubleConverter;
    @ComponentImport
    private final CustomFieldInputHelper customFieldInputHelper;
    @ComponentImport
    private I18nHelper.BeanFactory beanFactory;

    @Inject
    public MyPluginComponentImpl(final ApplicationProperties applicationProperties,
                                 final FieldVisibilityManager fieldVisibilityManager,
                                 final JqlOperandResolver jqlOperandResolver,
                                 final DoubleConverter doubleConverter,
                                 final CustomFieldInputHelper customFieldInputHelper,
                                 I18nHelper.BeanFactory beanFactory)
    {
        this.applicationProperties = applicationProperties;

        this.fieldVisibilityManager = fieldVisibilityManager;
        this.jqlOperandResolver = jqlOperandResolver;
        this.doubleConverter = doubleConverter;
        this.beanFactory = beanFactory;
        this.customFieldInputHelper = notNull("customFieldInputHelper", customFieldInputHelper);
    }

    public String getName()
    {
        if(null != applicationProperties)
        {
            return "myComponent:" + applicationProperties.getDisplayName();
        }
        
        return "myComponent";
    }
}