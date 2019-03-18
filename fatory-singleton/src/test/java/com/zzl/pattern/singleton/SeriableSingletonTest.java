package com.zzl.pattern.singleton;

import com.zzl.pattern.seriable.SeriableSingleton;

import java.io.*;

public class SeriableSingletonTest {

    public static void main(String[] args) {
        SeriableSingleton s1 = SeriableSingleton.getInstance();
        SeriableSingleton s2 = null;

        try {
            FileOutputStream fos = new FileOutputStream("SeriableSingleton.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s1);
            oos.flush();
            oos.close();

            FileInputStream fis = new FileInputStream("SeriableSingleton.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            s2 = (SeriableSingleton)ois.readObject();
            ois.close();

            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s1==s2);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
