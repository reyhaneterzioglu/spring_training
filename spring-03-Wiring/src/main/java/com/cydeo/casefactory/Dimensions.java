package com.cydeo.casefactory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Dimensions {

    private int width;
    private int height;
    private int depth;

    public void pressPowerButton(){
        System.out.println("Power button pressed");
    }
}
