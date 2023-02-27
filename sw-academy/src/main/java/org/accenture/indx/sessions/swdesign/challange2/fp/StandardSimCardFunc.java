package org.accenture.indx.sessions.swdesign.challange2.fp;


import org.accenture.indx.sessions.swdesign.challange2.SimCard;

import java.util.function.Function;

public class StandardSimCardFunc implements Function<SimCard, SimCard> {

    @Override
    public SimCard apply(SimCard simCard) {
        return simCard;
    }
}
