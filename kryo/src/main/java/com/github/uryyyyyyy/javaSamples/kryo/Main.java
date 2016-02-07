package com.github.uryyyyyyy.javaSamples.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.github.uryyyyyyy.javaSamples.kryo.model.MyDto1;
import com.github.uryyyyyyy.javaSamples.kryo.model.MyDto3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Main {

    public static void main(String args[]) throws FileNotFoundException {
        dto1();
        dto3();
    }

    private static void dto1() throws FileNotFoundException {
        Kryo kryo = new Kryo();

        Output output = new Output(new FileOutputStream("dto1.bin"));
        MyDto1 dto1 = new MyDto1("hello", 1);
        kryo.writeObject(output, dto1);
        output.close();

        Input input = new Input(new FileInputStream("dto1.bin"));
        MyDto1 dto2 = kryo.readObject(input, MyDto1.class);
        input.close();
        System.out.println(dto2.fpubLong);
        System.out.println(dto2.fpubStr);
    }

    private static void dto3() throws FileNotFoundException {
        Kryo kryo = new Kryo();

        Output output = new Output(new FileOutputStream("dto3.bin"));
        MyDto3 dto1 = new MyDto3("hello", 1);
        kryo.writeObject(output, dto1);
        output.close();

        Input input = new Input(new FileInputStream("dto3.bin"));
        MyDto3 dto2 = kryo.readObject(input, MyDto3.class);
        input.close();
        System.out.println(dto2.getFpubLong());
        System.out.println(dto2.getFpubStr());
    }
}
