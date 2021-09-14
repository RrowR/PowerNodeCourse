package day11;

public class Calculator {
    String branch;
    double bill;
    double add(double ... a){
        double sum = 0;
        for (double v : a) {
            sum += v;
        }
        return sum;
    }
    double subtraction(double a,double b){
        return a - b;
    }
    void getMessage(){
        System.out.println("品牌为:"+this.branch+",价格为:"+this.bill);
    }
}
