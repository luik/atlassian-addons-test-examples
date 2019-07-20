package com.milkneko.dev.confluence_4_rest_service.impl;

import com.atlassian.bandana.BandanaContext;
import com.atlassian.bandana.BandanaManager;
import com.atlassian.confluence.setup.bandana.ConfluenceBandanaContext;
import com.atlassian.plugin.spring.scanner.annotation.export.ExportAsService;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import com.milkneko.dev.confluence_4_rest_service.api.StorageComponent;
import com.milkneko.dev.confluence_4_rest_service.bean.RecordBean;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Date;

@ExportAsService({StorageComponent.class})
@Named("storageComponent")
public class StorageComponentImpl implements StorageComponent {

    @ComponentImport
    private BandanaManager bandanaManager;
    private BandanaContext bandanaContext;

    @Inject
    public StorageComponentImpl(BandanaManager bandanaManager) {
        this.bandanaManager = bandanaManager;

        this.bandanaContext = new ConfluenceBandanaContext("storage");
    }

    public RecordBean getRecordBean(){
        RecordBean recordBean = (RecordBean) bandanaManager.getValue(bandanaContext, "value");
        if(recordBean == null){
            recordBean = new RecordBean(1, new Date().toString());
        }

        return recordBean;
    }

    public void setRecordBean(RecordBean recordBean){
        recordBean.setStored(true);
        bandanaManager.setValue(bandanaContext, "value", recordBean);
    }

    public void deleteRecordBean(){
        bandanaManager.removeValue(bandanaContext, "value");
    }
}
