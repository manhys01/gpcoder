package com.gpcoder.annotation;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) throws IllegalAccessException, IOException {
        List<Image> iPhoneXImages = new ArrayList<>();

        Image iPhoneXImage1 = new Image();
        iPhoneXImage1.setId(1L);
        iPhoneXImage1.setName("iPhoneX.png");
        iPhoneXImage1.setLocation("/images/iPhoneX.png");
        iPhoneXImages.add(iPhoneXImage1);

        Image iPhoneXImage2 = new Image();
        iPhoneXImage2.setId(2L);
        iPhoneXImage2.setName("iPhoneX.jpg");
        iPhoneXImage2.setLocation("/images/iPhoneX.jpg");
        iPhoneXImages.add(iPhoneXImage2);

        Image iPhoneXImage3 = new Image();
        iPhoneXImage3.setId(3L);
        iPhoneXImage3.setName("iPhoneX.gif");
        iPhoneXImages.add(iPhoneXImage3);

        List<Product> products = new ArrayList<>();

        Product iPhoneX = new Product();
        iPhoneX.setId(1L);
        iPhoneX.setName("iPhone X");
        iPhoneX.setDescription("Designed by Apple");
        iPhoneX.setPrice(500F);
        iPhoneX.setImages(iPhoneXImages);
        products.add(iPhoneX);

        Product macbookPro2019 = new Product();
        macbookPro2019.setId(2L);
        macbookPro2019.setName("MacBookPro 2019");
        macbookPro2019.setDescription("Designed by Apple");
        macbookPro2019.setPrice(1000F);
        products.add(macbookPro2019);

        Store store = new Store();
        store.setName("Home Store");
        store.setLocation("123 street");
        store.setProducts(products);
        String toXml = ObjectToXmlHelper.convertToXml(store);
        File file = new File("result.xml");
        file.setReadable(true);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write(toXml);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().open(file);
        }
    }
}
