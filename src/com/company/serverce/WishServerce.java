package com.company.serverce;

import com.company.models.Wish;

public interface WishServerce {
    void createWish(String text, String phoneSender, String phoneReceipt);

    Wish[] receiptWishes(String phone);

}
