package com.milkneko.dev.confluence_3_admin_web_items;

import com.atlassian.confluence.core.ConfluenceActionSupport;
import com.milkneko.dev.confluence_3_admin_web_items.api.StorageComponent;
import com.milkneko.dev.confluence_3_admin_web_items.bean.RecordBean;

public class ViewAction extends ConfluenceActionSupport {

    private StorageComponent storageComponent;

    private RecordBean recordBean;

    @Override
    public String execute() {
        recordBean = storageComponent.getRecordBean();

        return SUCCESS;
    }


    public RecordBean getRecordBean() {
        return recordBean;
    }

    public void setStorageComponent(StorageComponent storageComponent) {
        this.storageComponent = storageComponent;
    }
}
