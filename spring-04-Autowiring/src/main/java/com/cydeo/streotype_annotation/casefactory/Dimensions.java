package com.cydeo.streotype_annotation.casefactory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@AllArgsConstructor
@Getter
@Setter
@Component
public class Dimensions {

    private int width;
    private int height;
    private int depth;

    public Dimensions() {
        this.width = 20;
        this.height=10;
        this.depth=40;
    }

    public void pressPowerButton(){
        System.out.println("Power button pressed");
    }
}
