package se.enums;

import java.util.Iterator;

/**
 * @author zhangyaowen
 */
public class PostOffice {
    enum MailHandler {
        GENERAL_DELIVERY {
            @Override
            boolean handle(Mail m) {
                if (m.generalDelivery == Mail.GeneralDelivery.YES) {
                    System.out.println("Using general delivery for " + m);
                    return true;
                }
                return false;
            }
        },
        MACHINE_SCAN {
            @Override
            boolean handle(Mail m) {
                if (m.scannability == Mail.Scannability.UNSCANNABLE) {
                    return false;
                }
                System.out.println("Delivering " + m + " automatically");
                return true;
            }
        },
        VISUAL_INSPECTION {
            @Override
            boolean handle(Mail m) {
                if (m.readability == Mail.Readability.ILLEGIBLE) {
                    return false;
                }
                if (m.address == Mail.Address.INCORRECT) {
                    return false;
                }
                System.out.println("Delivering " + m + " normally");
                return true;
            }
        },
        RETURN_TO_SENDER {
            @Override
            boolean handle(Mail m) {
                if (m.returnAddress == Mail.ReturnAddress.MISSING) {
                    return false;
                }
                System.out.println("Returning " + m + " to sender");
                return true;
            }
        };
        abstract boolean handle(Mail m);
    }
    static void handle(Mail m) {
        for (MailHandler handler: MailHandler.values()) {
            if (!handler.handle(m)) {
                System.out.println(m + " is a dead letter");
            }
        }
    }
    public static void main(String[] args) {
        for (Iterator<Mail> it = Mail.generator(3); it.hasNext(); ) {
            Mail mail = it.next();
            System.out.println(mail.details());
            handle(mail);
            System.out.println("********");
        }
    }
}
