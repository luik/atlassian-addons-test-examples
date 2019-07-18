package com.milkneko.dev.confluence_2_bandana.impl;

import com.atlassian.bandana.BandanaContext;
import com.atlassian.bandana.BandanaManager;
import com.atlassian.confluence.setup.bandana.ConfluenceBandanaContext;
import com.atlassian.plugin.spring.scanner.annotation.export.ExportAsService;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import com.milkneko.dev.confluence_2_bandana.RecordBean;
import com.milkneko.dev.confluence_2_bandana.api.StorageComponent;

import javax.inject.Inject;
import javax.inject.Named;

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
        return (RecordBean) bandanaManager.getValue(bandanaContext, "value");
    }

    public void setRecordBean(RecordBean recordBean){
        bandanaManager.setValue(bandanaContext, "value", recordBean);
    }
}
