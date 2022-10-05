package step.learing;

import com.google.inject.Guice;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");


        Guice.createInjector(new ConfigModule())
                .getInstance(App.class)
                .run();
    }


}