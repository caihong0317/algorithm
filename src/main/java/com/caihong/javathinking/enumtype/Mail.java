package com.caihong.javathinking.enumtype;

import java.util.Iterator;

public class Mail {
    enum GeneralDelivery {YES, NO1, NO2, NO3}

    enum Scannability {UNSCANNABLE, YES1, YES2, YES3}

    enum Readability {ILLEGIBLE, YES1, YES2, YES3}

    enum Address {INCORRECT, OK1, OK2, OK3}

    enum ReturnAddress {MISSING, OK1, OK2, OK3}

    GeneralDelivery generalDelivery;
    Scannability scannability;
    Readability readability;
    Address address;
    ReturnAddress returnAddress;
    static long counter = 0;
    long id = counter++;

    @Override
    public String toString() {
        return "Mail" + id;
    }

    public String details() {
        return "Mail{" +
            "generalDelivery=" + generalDelivery +
            ", scannability=" + scannability +
            ", readability=" + readability +
            ", address=" + address +
            ", returnAddress=" + returnAddress +
            '}';
    }

    public static Mail generateMail() {
        Mail mail = new Mail();
        mail.generalDelivery = Enums.random(GeneralDelivery.class);
        mail.scannability = Enums.random(Scannability.class);
        mail.readability = Enums.random(Readability.class);
        mail.address = Enums.random(Address.class);
        mail.returnAddress = Enums.random(ReturnAddress.class);
        return mail;
    }

    public static Iterable<Mail> iterable(final int count) {
        return new Iterable<>() {
            int n = count;

            @Override
            public Iterator<Mail> iterator() {
                return new Iterator<>() {
                    @Override
                    public boolean hasNext() {
                        return n-- > 0;
                    }

                    @Override
                    public Mail next() {
                        return generateMail();
                    }
                };
            }
        };
    }
}
