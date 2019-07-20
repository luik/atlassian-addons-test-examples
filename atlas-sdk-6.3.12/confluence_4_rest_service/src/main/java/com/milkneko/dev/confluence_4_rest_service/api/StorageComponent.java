package com.milkneko.dev.confluence_4_rest_service.api;

import com.milkneko.dev.confluence_4_rest_service.bean.RecordBean;

public interface StorageComponent {
    RecordBean getRecordBean();
    void setRecordBean(RecordBean recordBean);
    void deleteRecordBean();
}
