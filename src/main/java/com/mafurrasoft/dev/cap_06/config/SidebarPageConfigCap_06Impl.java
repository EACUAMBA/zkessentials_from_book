package com.mafurrasoft.dev.cap_06.config;

import com.mafurrasoft.dev.services.SidebarPage;
import com.mafurrasoft.dev.services.SidebarPageConfig;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SidebarPageConfigCap_06Impl implements SidebarPageConfig {

    Map<String, SidebarPage> pageMap = new LinkedHashMap<String, SidebarPage>();

    public SidebarPageConfigCap_06Impl(){
        this.pageMap.put("zk", new SidebarPage("zk", "ZK", "/img/site.png", "http://www.zkoss.org/"));
        this.pageMap.put("zkdemo", new SidebarPage("zkdemo", "ZK Demo", "/img/demo.png", "http://www.zkoss.org/zkdemo"));
        this.pageMap.put("zkdevref", new SidebarPage("zkdevref", "ZK Developer's Reference", "/img/doc.png", "https://www.zkoss.org/wiki/ZK_Developer%27s_Reference"));

        this.pageMap.put("fn1", new SidebarPage("fn1", "Profile (MVC)", "/img/fn.png", "/cap_06/page_based/index-profile-mvc.zul"));
        this.pageMap.put("fn2", new SidebarPage("fn2", "Profile (MVVM)", "/img/fn.png", "/cap_06/page_based/index-profile-mvvm.zul"));
        this.pageMap.put("fn3", new SidebarPage("fn3", "Todo List (MVC)", "/img/fn.png", "/cap_06/page_based/index-todolist-mvc.zul"));
        this.pageMap.put("fn4", new SidebarPage("fn4", "Todo List (MVVM)", "/img/fn.png", "/cap_06/page_based/index-todolist-mvvm.zul"));
    }

    @Override
    public List<SidebarPage> getPages() {
        return new ArrayList<>(this.pageMap.values());
    }

    @Override
    public SidebarPage getPage(String name) {
        return this.pageMap.get(name);
    }

    public List<SidebarPage> getPages(boolean b) {
        this.pageMap.clear();
        this.pageMap.put("zk", new SidebarPage("zk", "ZK", "/img/site.png", "http://www.zkoss.org/"));
        this.pageMap.put("zkdemo", new SidebarPage("zkdemo", "ZK Demo", "/img/demo.png", "http://www.zkoss.org/zkdemo"));
        this.pageMap.put("zkdevref", new SidebarPage("zkdevref", "ZK Developer's Reference", "/img/doc.png", "https://www.zkoss.org/wiki/ZK_Developer%27s_Reference"));

        this.pageMap.put("fn1", new SidebarPage("fn1", "Profile (MVC)", "/img/fn.png", "/cap_06/ajax-based-mvvm/index-profile-mvc.zul"));
        this.pageMap.put("fn2", new SidebarPage("fn2", "Profile (MVVM)", "/img/fn.png", "/cap_06/ajax-based-mvvm/index-profile-mvvm.zul"));
        this.pageMap.put("fn3", new SidebarPage("fn3", "Todo List (MVC)", "/img/fn.png", "/cap_06/ajax-based-mvvm/index-todolist-mvc.zul"));
        this.pageMap.put("fn4", new SidebarPage("fn4", "Todo List (MVVM)", "/img/fn.png", "/cap_06/ajax-based-mvvm/index-todolist-mvvm.zul"));

        return new ArrayList<>(this.pageMap.values());
    }
}
