import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner input = new Scanner(System.in);
        System.out.println("Введите выражение");
        System.out.print(calc(input.nextLine()));
    }
    public static String calc(String input) throws Exception{
        boolean isArabic1=true;
        boolean isArabic2=true;
        int result;
        int a = 0;
        int b = 0;
        String[] expression = input.split(" ");
        if(expression.length != 3){
            throw new Exception();
        }
        for (RomanNum num:RomanNum.values()){
            if(expression[0].equals(num.name())){
                a = num.ordinal()+1;
                isArabic1 = false;
            }
            if(expression[2].equals(num.name())){
                b = num.ordinal()+1;
                isArabic2 = false;
            }
        }
        if(isArabic1!=isArabic2){
            throw new Exception();
        }
        if(isArabic1){
            a=Integer.parseInt(expression[0]);
            b=Integer.parseInt(expression[2]);
        }
        if (a<1 || a>10 || b<1 || b>10){
            throw new Exception();
        }
        result = switch (expression[1]){
            case "+":
                yield a+b;
            case "-":
                yield a-b;
            case "*":
                yield a*b;
            case "/":
                yield a/b;
            default:
                throw new Exception();
        };
        if(isArabic1){
            return String.valueOf(result);
        }
        return intToRoman(result);
    }
    public static String intToRoman(int x) throws Exception {
        if(x<1){
            throw new Exception();
        }
        String result = "";
        RomanNum[] romanNum = RomanNum.values();
        if (x<40){
            result+=unit(x, romanNum[9].toString());
        }
        else if(x<50){
            result+=romanNum[9].toString()+romanNum[10];
        }
        else if(x<90){
            x-=50;
            result+=romanNum[10];
            result+=unit(x, romanNum[9].toString());
        }
        else if(x<100){
            result+=romanNum[9].toString()+romanNum[11];
        }
        else{
            result+=romanNum[11];
        }
        if(x%10!=0){
            result+=romanNum[x%10-1];
        }
        return result;
    }
    public static String unit(int x,String romanNum){
        String result="";
        for (int i=0; i<x/10; i++){
            result+=romanNum;
        }
        return result;
    }
}