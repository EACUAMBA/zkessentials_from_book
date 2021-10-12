package com.mafurrasoft.dev.cap_05.viewmodel;

import org.zkoss.bind.annotation.Init;
import org.zkoss.zkex.license.LicenseVerifier;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MenuViewModel {
    private List<MenuNode> menuHierarchy = null;

    @Init
    public void carryInfo(){
        this.menuHierarchy = new LinkedList<>();
        this.menuHierarchy.add(new MenuNode("Inicio", "", Arrays.asList(new MenuNode("Sobre nós", "", null), new MenuNode("Contactos", "", null))));
    }

    public List<MenuNode> getMenuHierarchy() {
        return menuHierarchy;
    }
}
