package com.mafurrasoft.dev.cap_07.service;

import com.mafurrasoft.dev.entity.User;
import com.mafurrasoft.dev.services.AuthenticationService;
import com.mafurrasoft.dev.services.UserCredential;
import com.mafurrasoft.dev.services.UserInfoService;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;

public class AuthenticationServiceCap_07Impl  implements AuthenticationService {

    UserInfoService userInfoService = new UserInfoServiceImpl();

    @Override
    public boolean login(String account, String password) {
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
