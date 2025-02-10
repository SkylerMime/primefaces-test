package org.primefaces.test;

import jakarta.faces.component.FacesComponent;
import jakarta.faces.component.UINamingContainer;

import lombok.Getter;


@FacesComponent("myComponent")
public class MyComponent extends UINamingContainer {
    @Getter private String generatedId = "1111";
    @Getter private String unchangingId = "unchanged";

    public void init() {
        System.out.println("Initializing component");
        generatedId = "owner" + (String) getAttributes().get("userNumber");
    }
}
