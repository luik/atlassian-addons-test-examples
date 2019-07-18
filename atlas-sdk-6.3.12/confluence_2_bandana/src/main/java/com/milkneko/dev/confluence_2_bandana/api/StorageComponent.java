package com.milkneko.dev.confluence_2_bandana.api;

import com.milkneko.dev.confluence_2_bandana.RecordBean;

public interface StorageComponent {
    RecordBean getRecordBean();
    void setRecordBean(RecordBean recordBean);
}
