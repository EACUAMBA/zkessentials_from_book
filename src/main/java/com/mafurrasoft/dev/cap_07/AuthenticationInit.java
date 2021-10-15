package com.mafurrasoft.dev.cap_07;

import com.mafurrasoft.dev.cap_07.service.AuthenticationServiceCap_07Impl;
import com.mafurrasoft.dev.services.AuthenticationService;
import com.mafurrasoft.dev.services.UserCredential;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.util.Initiator;

import java.util.Map;

public class AuthenticationInit implements Initiator {
    @Override
    public void doInit(Page page, Map<String, Object> map) throws Exception {
        AuthenticationService authenticationService = new AuthenticationServiceCap_07Impl();

        UserCredential userCredential = authenticationService.getUserCredential();

        if(userCredential == null || userCredential.isAnonymous()){
            Executions.sendRedirect("/cap_07/login.zul");
            return;
        }
    }
}
