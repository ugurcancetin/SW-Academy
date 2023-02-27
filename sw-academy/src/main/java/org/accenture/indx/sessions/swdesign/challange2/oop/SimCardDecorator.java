package org.accenture.indx.sessions.swdesign.challange2.oop;

import org.accenture.indx.sessions.swdesign.challange2.SimCard;

public abstract class SimCardDecorator implements SimCard {

    protected final SimCard simCard;

    public SimCardDecorator(SimCard simCard){
        this.simCard = simCard;
    }

    @Override
    public String create() {
        return simCard.create();
    }

}
