package org.primefaces.test;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import lombok.Data;
import lombok.Getter;

@Data
@Named
@ViewScoped
public class TestRequestBean implements Serializable {

    private String string;
    private Integer integer;
    private BigDecimal decimal;
    private LocalDateTime localDateTime;
    private List<TestObject> list;

    public StreamedContent getFile(String name) {
        StreamedContent file = DefaultStreamedContent.builder()
                .name(name)
                .contentType("image/jpg")
                .stream(() -> FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/demo/images/boromir.jpg"))
                .build();

        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "File Downloaded", "The file has been downloaded successfully.");
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        return file;
    }
}
