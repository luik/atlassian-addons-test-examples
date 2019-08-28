package com.milkneko.dev.jira_1_custom_field.custom_fields;

import com.atlassian.jira.issue.AttachmentManager;
import com.atlassian.jira.issue.customfields.impl.AbstractCustomFieldType;
import com.atlassian.jira.issue.customfields.impl.FieldValidationException;
import com.atlassian.jira.issue.customfields.view.CustomFieldParams;
import com.atlassian.jira.util.ErrorCollection;
import com.atlassian.plugin.spring.scanner.annotation.component.Scanned;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.atlassian.jira.issue.Issue;
import com.atlassian.jira.issue.fields.CustomField;
import com.atlassian.jira.issue.fields.config.FieldConfig;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Set;

@Scanned
public class MyCustomCalculatedField extends AbstractCustomFieldType<String, String> {
    private static final Logger log = LoggerFactory.getLogger(MyCustomCalculatedField.class);

    @ComponentImport
    private AttachmentManager attachmentManager;

    public MyCustomCalculatedField(AttachmentManager attachmentManager) {
        this.attachmentManager = attachmentManager;
    }

    @Override
    public String getStringFromSingularObject(String singularObject) {
        return null;
    }

    @Override
    public String getSingularObjectFromString(String singularObject) throws FieldValidationException {
        return null;
    }

    @Override
    public Set<Long> remove(CustomField customField) {
        return null;
    }

    @Override
    public void validateFromParams(CustomFieldParams customFieldParams, ErrorCollection errorCollection, FieldConfig fieldConfig) {

    }

    @Override
    public void createValue(CustomField customField, Issue issue, @Nonnull String value) {

    }

    @Override
    public void updateValue(CustomField customField, Issue issue, String value) {

    }

    @Override
    public String getValueFromCustomFieldParams(CustomFieldParams customFieldParams) throws FieldValidationException {
        return null;
    }

    @Override
    public Object getStringValueFromCustomFieldParams(CustomFieldParams customFieldParams) {
        return null;
    }

    @Nullable
    @Override
    public String getValueFromIssue(CustomField customField, Issue issue) {
        int attachmentCounter = attachmentManager.getAttachments(issue).size();
        return String.valueOf(attachmentCounter);
    }

    @Override
    public String getDefaultValue(FieldConfig fieldConfig) {
        return "0";
    }

    @Override
    public void setDefaultValue(FieldConfig fieldConfig, String value) {
    }

    @Nullable
    @Override
    public String getChangelogValue(CustomField customField, String value) {
        return null;
    }
}