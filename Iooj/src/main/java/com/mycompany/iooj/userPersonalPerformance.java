package com.mycompany.iooj;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class userPersonalPerformance extends userTrainer{
    public userPersonalPerformance(){}
    @Override
    public String[] getfilecontent() throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("loggings.txt"));
        String Line;
        String[] fileinfo = new String[0];
        while ((Line = input.readLine()) != null) {
            fileinfo = addmoretoarray(fileinfo);
            fileinfo[fileinfo.length - 1] = Line;
        }
        return fileinfo;
    }
}
