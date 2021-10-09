package com.mafurrasoft.dev.cap_03.viewmodel;

import com.mafurrasoft.dev.cap_03.controller.ProfileViewController;
import com.mafurrasoft.dev.cap_03.service.AuthenticationServiceCap_03Impl;
import com.mafurrasoft.dev.cap_03.service.UserInfoServiceCap_03Impl;
import com.mafurrasoft.dev.entity.User;
import com.mafurrasoft.dev.services.AuthenticationService;
import com.mafurrasoft.dev.services.CommonInfoService;
import com.mafurrasoft.dev.services.UserCredential;
import com.mafurrasoft.dev.services.UserInfoService;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.util.Clients;

import java.util.List;

public class ProfileViewModel {
    private AuthenticationService authenticationService = new AuthenticationServiceCap_03Impl();
    private UserInfoService userInfoService = new UserInfoServiceCap_03Impl();
    private User currentUser;

    public ProfileViewModel(){
        UserCredential userCredential = authenticationService.getUserCredential();
        currentUser = userInfoService.findUser(userCredential.getAccount());
        if(currentUser == null)
            return;
    }

    public User getCurrentUser(){
        return this.currentUser;
    }

    public List<String> getCountryList(){
        return CommonInfoService.getCountryList();
    }


    @Command
    @NotifyChange("currentUser.bio")
    public void save(){
        currentUser = userInfoService.updateUser(currentUser);
        Clients.showNotification("Perfil Actualizado");
    }

    @org.zkoss.zk.ui.annotation.Command
    @NotifyChange("currentUser")
    public void reload(){
        UserCredential cre = authenticationService.getUserCredential();
        this.currentUser = userInfoService.findUser(cre.getAccount());
    }
}
