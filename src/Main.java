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
        switch (expression[1]){
            case "+":
                result=a+b;
                break;
            case "-":
                result=a-b;
                break;
            case "*":
                result=a*b;
                break;
            case "/":
                result=a/b;
                break;
            default:
                throw new Exception();
        }
        if(isArabic1){
            return String.valueOf(result);
        }
        if(result<1){
            throw new Exception();
        }
        if(result<11){

        }
        return "rom";
    }
}