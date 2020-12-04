package com.company;
import java.util.Arrays;
import java.util.Random;

public class Lab1 implements Runnable {
    
    public static final int N=10;
    int kt;
    int[] arr;
    public static int tong=0;

    public Lab1(int kt, int[] arr) {
        this.kt = kt;
        this.arr = arr;
    }

    //SCP
    public static boolean isPerfect(int n){
        if(n<1) return false;
        double s=Math.sqrt(n);
        return (s-Math.floor(s)==0);
    }
    //SNT
    public static boolean isPrime(int n){
        for (int i = 2; i*i <= n; i++) {
           if(n%i ==0) return false;
        }
        return n>1;
    }


    public void run(){
        if(kt==0) {
            for (int i = 0; i < N; i++) {
                if (isPrime(arr[i])) {
                    tong++;
                    System.out.println("SNT: "+arr[i]);
                }
            }
        }else {
            for (int i = 0; i < N; i++) {
                if (isPerfect(arr[i])) {
                    tong++;
                    System.out.println("SCP: " + arr[i]);
                }
            }

        }

    }

    //t1 t2 chay dan xen
    public static void main(String[] args) throws InterruptedException {
        int[] arr=new int[N];
        Random rd=new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i]=rd.nextInt(N+1);
        }
        System.out.println("Mang A :"+ Arrays.toString(arr));

        Thread t1=new Thread(new Lab1(0,arr));
        Thread t2=new Thread(new Lab1(1,arr));
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Tong so luong c : "+tong );

    }
}
