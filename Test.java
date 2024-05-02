package com.example.swe206project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args)throws FileNotFoundException {
      File infile = new File("C:\\Users\\faris\\OneDrive\\Desktop\\SWE-206 Project\\SWE-206 Project\\src\\main\\java\\com\\example\\swe206project\\TourmentsDataBase.txt");
        Scanner sc = new Scanner(infile);
       Tournaments tempTour = new Tournaments("BasketBall","Elimnation","Multuple",50,"1/2/2020-1/10/2030");
        //How to find startDate and due date of a tourament
        System.out.println(tempTour.getStartDate());
        System.out.println(tempTour.getDueDate());


    }

}
