package org.accenture.indx.sessions.swdesign.challange2;

import org.accenture.indx.sessions.swdesign.challange2.fp.SimCardDecorators;
import org.accenture.indx.sessions.swdesign.challange2.fp.StandardSimCardFunc;
import org.accenture.indx.sessions.swdesign.challange2.oop.OneHourFreeCallDecorator;
import org.accenture.indx.sessions.swdesign.challange2.oop.StandardSimCard;
import org.accenture.indx.sessions.swdesign.challange2.oop.ThreeGBDataDecorator;

public class Client {
    public static void main(String[] args) {
        var simCard = new StandardSimCard();
        var OneHourFreeCallSimCard = new OneHourFreeCallDecorator(simCard);
        var ThreeGBDataSimCard = new ThreeGBDataDecorator(simCard);

        var OneHourFreeAndThreeGBDataSimCard = new OneHourFreeCallDecorator(new ThreeGBDataDecorator(simCard));

        System.out.println(simCard.create());
        System.out.println(OneHourFreeCallSimCard.create());
        System.out.println(ThreeGBDataSimCard.create());
        System.out.println(OneHourFreeAndThreeGBDataSimCard.create());


        var simCard2 = new StandardSimCard();
        var simCardFunc = new StandardSimCardFunc()
                .andThen(SimCardDecorators::OneThousandSms)
                .andThen(SimCardDecorators::ThreeGBData)
                .apply(simCard2);

        System.out.println(simCard2.create());
        System.out.println(simCardFunc.create());

    }
}
