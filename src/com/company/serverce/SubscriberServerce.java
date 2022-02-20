package com.company.serverce;

import com.company.exceptions.BlockSubcriber;
import com.company.models.Subscriber;
import com.company.models.Wish;
import com.company.serverce.impl.SubscriberServerceImpl;

public interface SubscriberServerce {
    SubscriberServerce INCECRE=new SubscriberServerceImpl();

    Subscriber findOrCreateSubscriber(String phone);

    void blockSubcriber(String phone);
}
