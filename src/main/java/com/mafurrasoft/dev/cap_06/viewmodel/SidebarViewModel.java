package com.mafurrasoft.dev.cap_06.viewmodel;

import com.mafurrasoft.dev.cap_06.config.SidebarPageConfigCap_06Impl;
import com.mafurrasoft.dev.services.SidebarPage;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;

import java.util.List;

public class SidebarViewModel {
    private SidebarPageConfigCap_06Impl sidebarPageConfigCap_06 = new SidebarPageConfigCap_06Impl();

    public List<SidebarPage> getSidebarPages(){
        return this.sidebarPageConfigCap_06.getPages(true);
    }

    private String url = "/cap_06/ajax-based-mvvm/layout/center.zul";


    @GlobalCommand("onNavegate")
    @NotifyChange({"url"})
    public void onNavegate(@BindingParam("page") SidebarPage page2){
        System.out.println("dentro o comando!");
        if(page2.getUri().contains("http")){
            System.out.println("Contem http");
            Executions.getCurrent().sendRedirect(page2.getUri(), "_blank");
            this.url = "/cap_06/ajax-based-mvvm/layout/center.zul";
            BindUtils.postNotifyChange(null, null, null, "url");
        }else{
            System.out.println("não tem http");
            this.url = page2.getUri();
        }
    }

    public String getUrl() {
        return url;
    }
}
