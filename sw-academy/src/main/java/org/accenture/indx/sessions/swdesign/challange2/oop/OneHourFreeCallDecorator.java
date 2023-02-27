package org.accenture.indx.sessions.swdesign.challange2.oop;

import org.accenture.indx.sessions.swdesign.challange2.SimCard;

public class OneHourFreeCallDecorator extends SimCardDecorator{

    public OneHourFreeCallDecorator(SimCard simCard) {
        super(simCard);
    }

    @Override
    public String create() {
        return super.create() + addOneHourFreeCall();
    }

    private String addOneHourFreeCall(){
        return " with one hour free call";
    }
}
