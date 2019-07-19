package com.milkneko.dev.confluence_3_admin_web_items;

import com.atlassian.confluence.core.ConfluenceActionSupport;
import com.milkneko.dev.confluence_3_admin_web_items.api.StorageComponent;
import com.milkneko.dev.confluence_3_admin_web_items.bean.RecordBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EditAction extends ConfluenceActionSupport {

    private StorageComponent storageComponent;
    private Logger logger = LoggerFactory.getLogger(getClass());

    private String action = null;
    private String idField;
    private String valueField;

    private RecordBean recordBean;

    @Override
    public String execute() {
        if(action != null && action.equals("save")){
            recordBean = new RecordBean( Integer.parseInt(idField), valueField );
            storageComponent.setRecordBean(recordBean);
            return SUCCESS;
        }

        recordBean = storageComponent.getRecordBean();
        return SUCCESS;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getIdField() {
        return idField;
    }

    public void setIdField(String idField) {
        this.idField = idField;
    }

    public String getValueField() {
        return valueField;
    }

    public void setValueField(String valueField) {
        this.valueField = valueField;
    }

    public RecordBean getRecordBean() {
        return recordBean;
    }

    public void setStorageComponent(StorageComponent storageComponent) {
        this.storageComponent = storageComponent;
    }
}
