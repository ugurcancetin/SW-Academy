package org.accenture.indx.sessions.swdesign.challange2.oop;

import org.accenture.indx.sessions.swdesign.challange2.SimCard;

public class ThreeGBDataDecorator extends SimCardDecorator{

    public ThreeGBDataDecorator(SimCard standardSimCard) {
        super(standardSimCard);
    }

    @Override
    public String create() {
        return super.create() + setThreeGBData();
    }

    private String setThreeGBData(){
       return " with three 3GB Data set";
    }
}
