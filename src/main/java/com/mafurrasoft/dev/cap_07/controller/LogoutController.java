package com.mafurrasoft.dev.cap_07.controller;

import com.mafurrasoft.dev.cap_07.service.AuthenticationServiceCap_07Impl;
import com.mafurrasoft.dev.services.AuthenticationService;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;

public class LogoutController extends SelectorComposer<Component> {
    AuthenticationService authenticationService = new AuthenticationServiceCap_07Impl();

    @Listen("onClick=#logout")
    public void doLogout(){
        authenticationService.logout();
        Executions.getCurrent().sendRedirect("/cap_07/");
    }
}
