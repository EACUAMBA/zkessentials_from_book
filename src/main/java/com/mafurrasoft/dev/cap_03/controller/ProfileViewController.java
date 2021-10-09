package com.mafurrasoft.dev.cap_03.controller;

import com.mafurrasoft.dev.cap_03.service.AuthenticationServiceCap_03Impl;
import com.mafurrasoft.dev.cap_03.service.UserInfoServiceCap_03Impl;
import com.mafurrasoft.dev.entity.User;
import com.mafurrasoft.dev.services.AuthenticationService;
import com.mafurrasoft.dev.services.CommonInfoService;
import com.mafurrasoft.dev.services.UserCredential;
import com.mafurrasoft.dev.services.UserInfoService;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.*;

public class ProfileViewController extends SelectorComposer<Component> {

    @Wire
    Label account;

    @Wire
    Textbox fullName;

    @Wire
    Textbox email;

    @Wire
    Datebox birthday;

    @Wire
    Listbox country;

    @Wire
    Textbox bio;


    AuthenticationService authenticationService  = new AuthenticationServiceCap_03Impl();
    UserInfoService userInfoService = new UserInfoServiceCap_03Impl();

    @Override
    public void doAfterCompose(Component component) throws Exception{
        super.doAfterCompose(component);

        ListModelList<String> countryModel = new ListModelList<String>(CommonInfoService.getCountryList());
        country.setModel(countryModel);


    }

    private void refreshProfileView(){
        UserCredential userCredential = authenticationService.getUserCredential();
        User user = userInfoService.findUser(userCredential.getAccount());

        if(user == null)
            return;

        account.setValue(user.getAccount());
        fullName.setValue(user.getFullName());
        email.setValue(user.getEmail());
        birthday.setValue(user.getBirthday());
        bio.setValue(user.getBio());

        ((ListModelList)country.getModel()).addToSelection(user.getCountry());
    }
}
