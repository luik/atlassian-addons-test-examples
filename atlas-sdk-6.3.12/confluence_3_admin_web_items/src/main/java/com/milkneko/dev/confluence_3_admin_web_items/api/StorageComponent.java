package com.milkneko.dev.confluence_3_admin_web_items.api;

import com.milkneko.dev.confluence_3_admin_web_items.bean.RecordBean;

public interface StorageComponent {
    RecordBean getRecordBean();
    void setRecordBean(RecordBean recordBean);
    void deleteRecordBean();
}
