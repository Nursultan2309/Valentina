package com.company.serverce.impl;

import com.company.exceptions.BlockSubcriber;
import com.company.exceptions.SubNotFount;
import com.company.models.Subscriber;
import com.company.serverce.SubscriberServerce;

public class SubscriberServerceImpl implements SubscriberServerce {

    Subscriber[] subscribers = new Subscriber[20];

    @Override
    public Subscriber findOrCreateSubscriber(String phone) {

        for (int i = 0; i < subscribers.length; i++) {
            if (subscribers[i] == null) {
                Subscriber subscriber = new Subscriber(phone);
                subscribers[i] = subscriber;
                return subscribers[i];
            } else {
                if (subscribers[i].getPhone().equals(phone)) {
                    return subscribers[i];
                } else {
                    continue;
                }
            }
        }
        throw new RuntimeException("Массив переполнен");
    }



   @Override
    public void blockSubcriber(String phone){
        System.out.println(subscribers[0]);
        for (int i = 0; i < subscribers.length; i++){
            if (subscribers[i] != null && subscribers[i].getPhone().equals(phone)){
                System.out.println("Апонент  найден!");
                System.out.println(subscribers[i].getPhone());
                Subscriber subscriber = subscribers[i];
                subscriber.setActive(true);
                subscribers[i] = subscriber;
                return;
            }
        }
        throw new SubNotFount("User не найден");
    }

}
          /*
        * Проверка на null -> если ячейка не пустая -> сравнить его номера
            return subscribers[i];
        * */


   /*

            Subcriber subs = findSubcriber(phone);
                subs -> isActibe = true;
                Записать его в массив

            findSubcriber(phone); -> null -> Сделать ошибку

        * */


