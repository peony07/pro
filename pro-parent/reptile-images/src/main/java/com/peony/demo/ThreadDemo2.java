package com.peony.demo;

public class ThreadDemo2 extends Thread {
	private int ticket = 10;  //10张票
	 
    public void run() {
        for (int i=0; i<=20; i++) {
            if (this.ticket > 0) {
                System.out.println(Thread.currentThread().getName()+ "正在卖票"+this.ticket--);
            }
        }
    }
   
    //大家可以想象，如果这个是一个买票系统的话，如果ticket表示的是车票的数量的话，说明并没有实现资源的共享。
    
   public static void main(String arg[]){
	   ThreadDemo2 aDemo1=new ThreadDemo2();
	   ThreadDemo2 aDemo2=new ThreadDemo2();
	   aDemo1.start();
	   aDemo2.start();
   }
}
