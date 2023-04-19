package com.caihong.javathinking.enumtype;

public class PostOffice {
    enum MailHandle {
        GENERAL_DELIVERY {
            @Override
            boolean handle(Mail mail) {
                switch (mail.generalDelivery) {
                    case YES:
                        System.out.println("Using general delivery for " + mail);
                        return true;
                    default:
                        return false;
                }
            }
        },
        MACHINE_SCAN {
            @Override
            boolean handle(Mail mail) {
                switch (mail.scannability) {
                    case UNSCANNABLE:
                        return false;
                    default:
                        switch (mail.address) {
                            case INCORRECT:
                                return false;
                            default:
                                System.out.println("Delivering for " + mail + " automatically");
                                return true;
                        }
                }
            }
        },
        VISUAL_INSPECTION {
            @Override
            boolean handle(Mail mail) {
                return true;
            }
        };

        abstract boolean handle(Mail mail);
    }

    static void handle(Mail mail) {
        for (MailHandle mailHandle : MailHandle.values()) {
            if (mailHandle.handle(mail)) {
                return;
            }
        }
        System.out.println(mail + " is a dead letter");
    }

    public static void main(String[] args) {
        for (Mail mail : Mail.iterable(5)) {
            System.out.println(mail.details());
            handle(mail);
            System.out.println("----------");
        }
    }
}