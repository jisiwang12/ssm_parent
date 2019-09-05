package cn.gsq;

public class MyTest extends Thread implements Runnable{
    public void father() {
        System.out.println("father");
    }

    public void child() {
        System.out.println("father");
    }

    public void child(String name) {

    }

    public String child(String name,String us) {
        return null;
    }




    public static void main(String[] args) {
  /*
       MyTest myTest = new MyTest2();
        myTest.child();*/
        int  total=0;
        for(int  i=0;i<4;i++) {
            if(i==1)continue;
            if(i==2)break;
            total +=i;
        }
        System.out.println(total);

    }

}


