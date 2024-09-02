package com.wellsfargo.clientapp;

import com.wellsfargo.controller.MainController;
import com.wellsfargo.vo.CoronaPatientVO;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Scanner;

public class ClientApp
{
    public static void main(String[] args) {
        CoronaPatientVO vo = new CoronaPatientVO();
        Scanner scanf = new Scanner(System.in);
        System.out.println("Enter Patient Name");
        vo.setPatientName(scanf.nextLine());
        System.out.println("Enter Patient Address");
        vo.setPatientAddrs(scanf.nextLine());
        System.out.println("Enter Patient Mobile No");
        vo.setMobileNo(scanf.nextLine());
        System.out.println("Enter No of hospitalisation days");
        vo.setHospitalizationDays(scanf.nextLine());
        System.out.println("Enter Bill Amount per Day");
        vo.setBillPerDay(scanf.nextLine());
        try
        {
            DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
            XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
            reader.loadBeanDefinitions("applicationContext.xml");
            MainController mCon = factory.getBean("mCon", MainController.class);
            String message = String.valueOf(mCon.calculatePatientBill(vo));
            System.out.println(message);
        }
        catch (Exception e)
        {
            System.out.println("Internal Error!! Please Try again");
        }
        scanf.close();
    }
}
