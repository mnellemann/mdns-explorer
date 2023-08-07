package biz.nellemann.mdexpl.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;

@Singleton
public class MainModel {

    private static final Logger log = LoggerFactory.getLogger(MainModel.class);


    @PostConstruct
    public void initialize() {
        log.info("initialize()");
    }

}
