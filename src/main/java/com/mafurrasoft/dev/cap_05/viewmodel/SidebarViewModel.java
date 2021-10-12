package com.mafurrasoft.dev.cap_05.viewmodel;

import com.mafurrasoft.dev.cap_02.config.SidebarPageConfigCap_02Impl;
import com.mafurrasoft.dev.services.SidebarPage;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.zk.ui.Executions;

import java.util.List;

public class SidebarViewModel {
    private SidebarPageConfigCap_02Impl sidebarPageConfigCap_02 = new SidebarPageConfigCap_02Impl();

    public List<SidebarPage> getSidebarPages(){
        return this.sidebarPageConfigCap_02.getPages();
    }


    @Command
    public void navegate(@BindingParam("page") SidebarPage page2){
        Executions.getCurrent().sendRedirect(page2.getUri(), "_black");
    }
}
