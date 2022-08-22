package com.java.Exception;

public class UserDefinedException extends Exception{
    private static int age[] = {100, 20, 03, 10};

    private static String name[] =
            {"Nish", "Shubh", "Sush", "Abhi", "Akash"};

    UserDefinedException()
    {    }


    UserDefinedException(String str)
    {
        super(str);
    }
    public static void main(String[] args) {
        try  {
            // display the heading for the table
            System.out.println("AGE" + "\t" + "CUSTOMER"
                    );

            // display the actual account information
            for (int i = 0; i < 5 ; i++)
            {
                System.out.println(age[i] + "\t" + name[i]
                       );

                // display own exception if balance < 1000
                if (age[i] < 10)
                {
                    UserDefinedException me =
                            new UserDefinedException("Age is less than 10");
                    throw me;
                }
            }
        }
        catch ( UserDefinedException e) {
            e.printStackTrace();
        }
    }
}
