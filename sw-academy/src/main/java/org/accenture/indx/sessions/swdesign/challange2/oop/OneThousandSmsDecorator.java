package org.accenture.indx.sessions.swdesign.challange2.oop;

import org.accenture.indx.sessions.swdesign.challange2.SimCard;

public class OneThousandSmsDecorator extends SimCardDecorator{

    public OneThousandSmsDecorator(SimCard simCard) {
        super(simCard);
    }

    @Override
    public String create() {
        return super.create() + setOneThousandSms();
    }

    private String setOneThousandSms(){
        return " with one thousand free sms";
    }
}
