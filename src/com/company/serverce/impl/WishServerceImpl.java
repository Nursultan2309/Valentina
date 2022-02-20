package com.company.serverce.impl;

import com.company.exceptions.BlockSubcriber;
import com.company.exceptions.SubNotFount;
import com.company.exceptions.WishNotFound;
import com.company.models.Subscriber;
import com.company.models.Wish;
import com.company.serverce.SubscriberServerce;
import com.company.serverce.WishServerce;

public class WishServerceImpl implements WishServerce {
    private Wish[] wishes = new Wish[10];
 //   private SubscriberServerce serverce = new SubscriberServerceImpl();

    @Override
    public void createWish(String text, String phoneSender, String phoneReceipt) {

        Subscriber sender = SubscriberServerce.INCECRE.findOrCreateSubscriber(phoneSender);
        Subscriber receipt = SubscriberServerce.INCECRE.findOrCreateSubscriber(phoneReceipt);

        if (receipt.isActive()) {
            throw new BlockSubcriber("Получатель заблокирован!");

        }
        sender.incrementSubsWish();

        for (int i = 0; i < wishes.length; i++) {
            Wish wish = new Wish(text, sender, receipt);
            wishes[i] = wish;
            System.out.println("--------------------------------");
            System.out.println("Смс успешно отправлен!");
            System.out.println("--------------------------------");
            break;
        }
    }

    @Override
    public Wish[] receiptWishes(String phone) {

        Wish[] receiptWishes;
        Subscriber receiptFromDataBase = SubscriberServerce.INCECRE.findOrCreateSubscriber(phone);
        System.out.println("ID получателя из базы " + receiptFromDataBase.getId());
        int countWish = 0;
        for (int i = 0; i < wishes.length; i++) {
            if (wishes[i] != null && receiptFromDataBase.getId() == wishes[i].getReceipt().getId()) {
                countWish++;
            }
        }
        if (countWish == 0) {
            throw new WishNotFound("У вас пока нет смс");
        } else {
            receiptWishes = new Wish[countWish];
            int index = 0;
            for (Wish w : wishes) {
                if (w != null && w.getReceipt().getId() == receiptFromDataBase.getId()) {
                    receiptWishes[index] = w;
                    index++;
                }
            }
            return receiptWishes;
        }
    }

    private boolean checkSendSms(Subscriber sender, Subscriber receipt) {
        for (int i = 0; i < wishes.length; i++) {
            if (wishes[i] == null) {
                continue;
            } else {
                if (wishes[i].getSender().getId() == sender.getId()
                        && wishes[i].getReceipt().getId() == receipt.getId()) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}

