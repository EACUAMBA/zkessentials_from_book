package com.mafurrasoft.dev.cap_05.config;

import com.mafurrasoft.dev.services.SidebarPage;
import com.mafurrasoft.dev.services.SidebarPageConfig;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SidebarPageConfigCap_02Impl implements SidebarPageConfig {

    Map<String, SidebarPage> pageMap = new LinkedHashMap<String, SidebarPage>();

    public SidebarPageConfigCap_02Impl(){
        this.pageMap.put("fn1", new SidebarPage("zk", "ZK", "/img/site.png", "http://www.zkoss.org/"));
        this.pageMap.put("fn2", new SidebarPage("zkdemo", "ZK Demo", "/img/demo.png", "http://www.zkoss.org/zkdemo"));
        this.pageMap.put("fn3", new SidebarPage("zkdevref", "ZK Developer's Reference", "/img/doc.png", "https://www.zkoss.org/wiki/ZK_Developer%27s_Reference"));
    }

    @Override
    public List<SidebarPage> getPages() {
        return new ArrayList<>(this.pageMap.values());
    }

    @Override
    public SidebarPage getPage(String name) {
        return this.pageMap.get(name);
    }
}
