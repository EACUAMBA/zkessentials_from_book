package com.mafurrasoft.dev.cap_06.viewmodel;

import java.util.List;

public class MenuNode {
    private String label;
    private String iconSclass;
    private List<MenuNode> subMenus;

    public MenuNode(){

    }

    public MenuNode(String label, String iconSclass, List<MenuNode> subMenus){
        this.label = label;
        this.iconSclass = iconSclass;
        this.subMenus = subMenus;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getIconSclass() {
        return iconSclass;
    }

    public void setIconSclass(String iconSclass) {
        this.iconSclass = iconSclass;
    }

    public List<MenuNode> getSubMenus() {
        return subMenus;
    }

    public void setSubMenus(List<MenuNode> subMenus) {
        this.subMenus = subMenus;
    }
}
