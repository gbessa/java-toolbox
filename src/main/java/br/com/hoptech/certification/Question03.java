package br.com.hoptech.certification;

public class Question03 {
    public static void main(String[] args) {
        try {
            throw new Father();
        } catch (Father e) {
            System.out.println("Father");
        //} catch (Son e) { os catchs tem de ser do mais especializado para o menos (Pai antes do filho)
        //    System.out.println("Son");
        } catch (Exception e) {
            System.out.println("Exception");
        }
    }
}

class Father extends RuntimeException {};
class Son extends Father {};
