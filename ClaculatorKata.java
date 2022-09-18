import javax.swing.table.TableStringConverter;
import java.util.Scanner;

public class ClaculatorKata {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Вас приветствует арабско-римский калькулятор:) Введите,пожалуйста, математическое выражение " +
                "с двумя целыми числами от 1 до 10 включительно. Учтите, что числа должны быть или римские, или арабские!");
        Scanner scn = new Scanner(System.in);
        String math_expr = scn.nextLine();

        if (math_expr.length() < 4 || math_expr.matches("(.*)10\\+10(.*)") || math_expr.matches("(.*)10\\*10(.*)")||
        math_expr.matches("(.*)10-10(.*)")||math_expr.matches("(.*)10/10(.*)")) {

            Map map = new Map();
            String[] actions = {"+", "*", "-", "/"};
            String[] regexSymb = {"\\+", "\\*", "-", "/"};

            int actionIndex = -1;
            for (int i = 0; i < actions.length; i++) {
                if (math_expr.contains(actions[i])) {
                    actionIndex = i;
                    break;
                }
            }

            if (actionIndex == -1) {
                System.out.println("throws Exception //т.к. формат математической операции не удовлетворяет заданию");
                return;
            }

            String[] data = math_expr.split(regexSymb[actionIndex]);

            if (map.isRoma(data[0]) == map.isRoma(data[1])) {
                int num1, num2;
                boolean isRoma = map.isRoma(data[0]);
                if (isRoma) {
                    num1 = map.romaInt(data[0]);
                    num2 = map.romaInt(data[1]);
                } else {
                    num1 = Integer.parseInt(data[0]);
                    num2 = Integer.parseInt(data[1]);
                    if (num1 > 10 || num2 > 10) {
                        System.out.println("throws Exception //т.к. Калькулятор должен принимать на вход числа от 1 до 10 (I до X) включительно, не более");
                        System.exit(0);
                    }
                }
                int finish = 0;
                if (num1 > 10 || num2 > 10) {
                    System.out.println("throws Exception //т.к. Калькулятор должен принимать на вход числа от 1 до 10 (I до X) включительно, не более");
                    System.exit(0);
                }

                switch (actions[actionIndex]) {
                    case "+":
                        finish = num1 + num2;
                        break;
                    case "*":
                        finish = num1 * num2;
                        break;
                    case "-":
                        finish = num1 - num2;
                        break;
                    case "/":
                        finish = num1 / num2;
                        break;
                }
                if (isRoma) {
                    System.out.println(map.intRoma(finish));
                } else {
                    System.out.println(finish);
                }


            } else {
                System.out.println("throws Exception //т.к. используются одновременно разные системы счисления");
            }


        }

    else
    {
        System.out.println("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор");
        System.exit(0);
    }
}}