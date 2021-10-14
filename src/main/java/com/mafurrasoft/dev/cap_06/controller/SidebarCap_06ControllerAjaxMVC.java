package com.mafurrasoft.dev.cap_06.controller;

import com.mafurrasoft.dev.cap_06.config.SidebarPageConfigCap_06Impl;
import com.mafurrasoft.dev.services.SidebarPage;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.SerializableEventListener;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class SidebarCap_06ControllerAjaxMVC extends SelectorComposer<Component> {

    @Wire //Vai amarar o componente com o ID e o tipo igual a essa variavel;
    private Grid sidebar;


    static Map<String, SidebarPage> pageMap = new LinkedHashMap<String, SidebarPage>();

    static {
        pageMap.put("zk", new SidebarPage("zk", "ZK", "/img/site.png", "http://www.zkoss.org/"));
        pageMap.put("zkdemo", new SidebarPage("zkdemo", "ZK Demo", "/img/demo.png", "http://www.zkoss.org/zkdemo"));
        pageMap.put("zkdevref", new SidebarPage("zkdevref", "ZK Developer's Reference", "/img/doc.png", "https://www.zkoss.org/wiki/ZK_Developer%27s_Reference"));

        pageMap.put("fn1", new SidebarPage("fn1", "Profile (MVC)", "/img/fn.png", "/cap_06/ajax-based-mvc/index-profile-mvc.zul"));
        pageMap.put("fn2", new SidebarPage("fn2", "Profile (MVVM)", "/img/fn.png", "/cap_06/ajax-based-mvc/index-profile-mvvm.zul"));
        pageMap.put("fn3", new SidebarPage("fn3", "Todo List (MVC)", "/img/fn.png", "/cap_06/ajax-based-mvc/index-todolist-mvc.zul"));
        pageMap.put("fn4", new SidebarPage("fn4", "Todo List (MVVM)", "/img/fn.png", "/cap_06/ajax-based-mvc/index-todolist-mvvm.zul"));
    }


    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);

        Rows rows = sidebar.getRows();

        for (SidebarPage sidebarPage : pageMap.values()) {
            Row row = constructSidebarRow(sidebarPage.getName(), sidebarPage.getLabel(), sidebarPage.getIconUri(), sidebarPage.getUri());
            rows.appendChild(row);
        }

    }

    private Row constructSidebarRow(String name, String label, String iconUri, final String locationUri) {

        Row row = new Row();
        Image image = new Image(iconUri);
        Label label1 = new Label(label);

        row.appendChild(image);
        row.appendChild(label1);
        row.setSclass("sidebar-fn");

        //Criando o evento;
        EventListener<Event> actionEvent = new SerializableEventListener<Event>() {
            @Override
            public void onEvent(Event event) throws Exception {
                //Pegando o HttpServletRequest
                //
                //Enviando uma reposta ao navegador de redicionamento, o codigo por baixo deste method será ignorado;
//                Executions.getCurrent().sendRedirect(locationUri);
                Include include = (Include) Selectors.find(sidebar.getPage(), "#centerContent").iterator().next();
                include.setSrc(locationUri);
            }
        };
        row.addEventListener(Events.ON_CLICK, actionEvent); //Adicionando o evento ao listener

        return row;
    }

}
