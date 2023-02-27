package org.accenture.indx.sessions.swdesign.challange2.fp;

import org.accenture.indx.sessions.swdesign.challange2.SimCard;

public class SimCardDecorators {

    public static SimCard ThreeGBData(SimCard simCard){
        return () -> simCard.create() + " with 3GB Data.";
    }

    public static SimCard OneThousandSms(SimCard simCard){
        return () -> simCard.create() + " with one thousand Sms";
    }
}
