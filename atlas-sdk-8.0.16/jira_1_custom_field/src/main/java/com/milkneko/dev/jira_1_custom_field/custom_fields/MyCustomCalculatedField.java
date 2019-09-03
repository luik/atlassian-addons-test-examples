package com.milkneko.dev.jira_1_custom_field.custom_fields;

import com.atlassian.jira.issue.AttachmentManager;
import com.atlassian.jira.issue.customfields.impl.CalculatedCFType;
import com.atlassian.jira.issue.customfields.impl.FieldValidationException;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.atlassian.jira.issue.Issue;
import com.atlassian.jira.issue.fields.CustomField;

import javax.annotation.Nullable;

public class MyCustomCalculatedField extends CalculatedCFType<Double, Double> {
    private static final Logger log = LoggerFactory.getLogger(MyCustomCalculatedField.class);

    @ComponentImport
    private AttachmentManager attachmentManager;

    public MyCustomCalculatedField(AttachmentManager attachmentManager) {
        this.attachmentManager = attachmentManager;
    }

    @Override
    public String getStringFromSingularObject(Double aDouble) {
        return String.valueOf(aDouble);
    }

    @Override
    public Double getSingularObjectFromString(String s) throws FieldValidationException {
        return Double.parseDouble(s);
    }

    @Nullable
    @Override
    public Double getValueFromIssue(CustomField customField, Issue issue) {
        return (double) attachmentManager.getAttachments(issue).size();
    }

}