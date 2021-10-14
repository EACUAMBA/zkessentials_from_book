package com.mafurrasoft.dev.cap_06.controller;

import com.mafurrasoft.dev.cap_02.config.SidebarPageConfigCap_02Impl;
import com.mafurrasoft.dev.cap_06.config.SidebarPageConfigCap_06Impl;
import com.mafurrasoft.dev.services.SidebarPage;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.SerializableEventListener;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.*;

public class SidebarCap_06Controller extends SelectorComposer<Component> {

    @Wire //Vai amarar o componente com o ID e o tipo igual a essa variavel;
    private Grid sidebar;

    SidebarPageConfigCap_06Impl sidebarPageConfigCap_06 = new SidebarPageConfigCap_06Impl();

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);

        Rows rows = sidebar.getRows();

        for (SidebarPage sidebarPage : sidebarPageConfigCap_06.getPages()){
            Row row = constructSidebarRow(sidebarPage.getName(), sidebarPage.getLabel(), sidebarPage.getIconUri(), sidebarPage.getUri());
            rows.appendChild(row);
        }

    }

    private Row constructSidebarRow(String name, String label, String iconUri, final String locationUri){

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
                System.out.println("Codigo antes do sendRedirect(link)");
                Executions.getCurrent().sendRedirect(locationUri);
                System.out.println("Codigo após o senRedirect(link)");
            }
        };
        row.addEventListener(Events.ON_CLICK, actionEvent); //Adicionando o evento ao listener

        return row;
    }

}
