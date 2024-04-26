import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        System.out.println("Input: ");
        String x = s.nextLine();
        String[] operands = x.split("[+\\-*/]");
        char [] charArray=operands[0].toCharArray();
        char [] charArray1=operands[1].toCharArray();
        if ( charArray[0]!='"' || charArray[operands[0].length()-1]!='"') {
            throw new Exception("первый введённый оператор не соответсвует формату строчного калькулятора");
        }
        String oper;
        String sum;
        String opera;
        oper = detectOperation(x);
        for (int i=0;i<operands.length;i++) {
            opera=operands[i].replace("\"","");
            if (opera.length()>10) {
                throw new Exception("Количество символов оператора не соответсвует формату строчного калькулятора");
            }
        }
        if (oper.equals("+")) {
            if ( charArray1[0]!='"' || charArray1[operands[1].length()-1]!='"') {
                throw new Exception("второй введённый оператор не соответсвует формату строчного калькулятора");
            }
            operands[0]=operands[0].substring(1,operands[0].length()-1);
            operands[1]=operands[1].substring(1,operands[1].length()-1);
            sum=operands[0].concat(operands[1]);
            System.out.println();
            System.out.println("Output:");
            System.out.println("\""+sum+"\"");
        }
        String opera1;
        String opera2;
        if (oper.equals("-")){
            if ( charArray1[0]!='"' || charArray1[operands[1].length()-1]!='"') {
                throw new Exception("второй введённый оператор не соответсвует формату строчного калькулятора");
            }
            opera1=operands[0].replace("\"","");
            opera2=operands[1].replace("\"","");
            int index = opera1.indexOf(opera2);
            if(index == -1){
                System.out.println();
                System.out.println("Output:");
                System.out.println(operands[0]);
            }else {
                String result = opera1.substring(0, index);
                result += opera1.substring(index + opera2.length());
                System.out.println();
                System.out.println("Output:");
                System.out.println("\"" + result + "\"");
            }
        }
        if (oper.equals("*")){
            if ( charArray1[0]=='"' || charArray1[operands[1].length()-1]=='"') {
                throw new Exception("Умножать и делить строку можно только на число");
            }
            int multiplier = Integer.parseInt(operands[1]);
            if (multiplier>10) {
                throw new Exception("Множитель строки не может быть больше 10");
            }
            opera1=operands[0].replace("\"","");
            String result = "";
            for (int i = 0; i < multiplier; i++) {
                result=String.join("",result,opera1);
            }
            if(result.length()>40){
                System.out.println();
                System.out.println("Output:");
                System.out.println("\""+result.substring(0,40)+"... "+"\"");
            }else {
                System.out.println();
                System.out.println("Output:");
                System.out.println("\""+result+"\"");
            }
        }
        if (oper.equals("/")) {
            if (charArray1[0] == '"' || charArray1[operands[1].length() - 1] == '"') {
                throw new Exception("Умножать и делить строку можно только на число");
            }
            int multiplier = Integer.parseInt(operands[1]);
            if (multiplier > 10) {
                throw new Exception("Делитель строки не может быть больше 10");
            }
            opera1 = operands[0].replace("\"", "");
            int div = opera1.length() / multiplier;
            String result1 = opera1.substring(0, div);
            System.out.println();
            System.out.println("Output:");
            System.out.println("\"" + result1 + "\"");
        }
    }
    static String detectOperation(String input) throws Exception {
        if (input.contains("+")) return "+";
        else if (input.contains("-")) return "-";
        else if (input.contains("*")) return "*";
        else if (input.contains("/")) return "/";
        else throw new Exception("Неподерживаемая математическая операция");
    }
}