package com.mafurrasoft.dev.cap_07.service;

import com.mafurrasoft.dev.entity.User;
import com.mafurrasoft.dev.services.AuthenticationService;
import com.mafurrasoft.dev.services.UserCredential;
import com.mafurrasoft.dev.services.UserInfoService;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;

import java.io.Serializable;

@Service
@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class AuthenticationServiceCap_07Impl  implements AuthenticationService, Serializable {

    @WireVariable
    UserInfoService userInfoService;

    @Override
    public boolean login(String account, String password) {
//        Selectors.wireVariables(Page page, this, Selectors.newVariableResolvers(getClass(), null));
        User user = userInfoService.findUser(account);
        if(user == null || !user.getPassword().equals(password)){
            return false;
        }

        Session session = Sessions.getCurrent();

        UserCredential userCredential = new UserCredential(user.getAccount(), user.getFullName());
        session.setAttribute("userCredential", userCredential);

        return true;

    }

    @Override
    public void logout() {
        Session session = Sessions.getCurrent();
        session.removeAttribute("userCredential");
    }

    @Override
    public UserCredential getUserCredential() {
        Session session = Sessions.getCurrent();
        UserCredential userCredential = (UserCredential)session.getAttribute("userCredential");

        if(userCredential == null){
            userCredential = new UserCredential();
            session.setAttribute("userCredential", userCredential);
        }
        return userCredential;
    }
}
