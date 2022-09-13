package com.cydeo.streotype_annotation.casefactory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Getter
@Setter
@Component
public class Dimensions {

    private Integer width;
    private Integer height;
    private Integer depth;

    public void pressPowerButton(){
        System.out.println("Power button pressed");
    }
}
