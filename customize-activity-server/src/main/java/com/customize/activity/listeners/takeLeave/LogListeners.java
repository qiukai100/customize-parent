package com.customize.activity.listeners.takeLeave;

import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

@Slf4j
public class LogListeners implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) {
        log.debug("LogListeners is run.......");
    }
}
