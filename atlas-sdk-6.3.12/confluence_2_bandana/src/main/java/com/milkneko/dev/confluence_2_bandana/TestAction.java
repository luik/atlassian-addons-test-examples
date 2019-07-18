package com.milkneko.dev.confluence_2_bandana;

import com.atlassian.bandana.BandanaManager;
import com.atlassian.confluence.core.ConfluenceActionSupport;
import com.atlassian.confluence.setup.bandana.ConfluenceBandanaContext;
import com.milkneko.dev.confluence_2_bandana.api.StorageComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class TestAction extends ConfluenceActionSupport {

    private BandanaManager bandanaManager;
    private StorageComponent storageComponent;
    private Logger logger = LoggerFactory.getLogger(getClass());

    private Integer counter;
    private String date = "";
    // Custom objects must be access from a Component
    // If you try to access directly from the action you will get a ClassNotFoundException
    private RecordBean recordBean;

    @Override
    public String execute() {
        ConfluenceBandanaContext bandanaContext = new ConfluenceBandanaContext("context");
        counter = (Integer)bandanaManager.getValue(bandanaContext, "counter");
        date = (String)bandanaManager.getValue(bandanaContext, "date");

        recordBean = storageComponent.getRecordBean();
        if(recordBean == null){
            recordBean = new RecordBean(1, new Date().toString());
        }
        else{
            recordBean = new RecordBean(recordBean.getAttribute1() + 1, new Date().toString());
        }
        storageComponent.setRecordBean(recordBean);

        if(counter == null){
            logger.info("Not data in bandana, setting data");
            counter = 1;
        }
        else {
            counter ++;
        }
        date = new Date().toString();
        bandanaManager.setValue(bandanaContext, "counter", counter);
        bandanaManager.setValue(bandanaContext, "date", date);

        return SUCCESS;
    }

    public int getCounter() {
        return counter;
    }

    public String getDate() {
        return date;
    }

    public RecordBean getRecordBean() {
        return recordBean;
    }

    // actions get dependencies using set methods
    public void setBandanaManager(BandanaManager bandanaManager) {
        this.bandanaManager = bandanaManager;
    }

    public void setStorageComponent(StorageComponent storageComponent) {
        this.storageComponent = storageComponent;
    }
}
