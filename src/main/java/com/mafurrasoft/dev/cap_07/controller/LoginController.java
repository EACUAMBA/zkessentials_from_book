package com.mafurrasoft.dev.cap_07.controller;

import com.mafurrasoft.dev.cap_07.service.AuthenticationServiceCap_07Impl;
import com.mafurrasoft.dev.services.AuthenticationService;
import com.mafurrasoft.dev.services.UserCredential;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;

import java.awt.*;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class LoginController extends SelectorComposer<Component> {
    @Wire
    private Textbox conta;

    @Wire
    private Textbox senha;
    @Wire
    private Label message;

    @WireVariable("authenticationServiceCap_07Impl")
    AuthenticationService authenticationService ;

    @Listen("onClick=#login; onOK=#loginWin")
    public void login(){
        String conta = this.conta.getValue();
        String senha = this.senha.getValue();

        if(!authenticationService.login(conta, senha)){
            message.setValue("Senha incorecta, tente novamente");
            return;
        }
        UserCredential userCredential = authenticationService.getUserCredential();
        message.setValue("Welcome. " + userCredential.getName());
        message.setSclass("");

        Executions.getCurrent().sendRedirect("/cap_07/");
    }
}
