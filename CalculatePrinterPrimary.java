package calculateprinter;

import java.util.Scanner;

public class CalculatePrinterPrimary {
    public static void main(String[] args) {
        System.out.println("请输入你要打印题目的个数");
        Scanner sc = new Scanner(System.in);
        int numSum = sc.nextInt();
        String[] againArr = new String[numSum];
        String[] againArrP1 = new String[numSum];
        String[] againArrP2 = new String[numSum];
        int[] resArr = new int[numSum];
        int[] resArrP = new int[numSum];
        label:
        for (int i = 0; i < numSum; i++) {
            int choice1 = (int) (Math.random() * 2);
            int choice2 = (int) (Math.random() * 2);
            int choice3 = (int) (Math.random() * 4);
            int n1 = (int) (Math.random() * 100);
            int n2 = (int) (Math.random() * 100);
            switch (choice1) {
                case 0:
                    switch (choice2) {
                        case 0:
                            againArr[i] = n1 + "+" + n2;
                            resArr[i] = n1 + n2;
                            break;
                        case 1:
                            againArr[i] = n1 + "-" + n2;
                            resArr[i] = n1 - n2;
                            break;
                    }
                    break;
                case 1:
                    int n3 = (int) (Math.random() * 100);
                    switch (choice3) {
                        case 0:
                            againArr[i] = n1 + "+" + n2 + "+" + n3;
                            resArr[i] = n1 + n2 + n3;
                            break;
                        case 1:
                            againArr[i] = n1 + "+" + n2 + "-" + n3;
                            againArrP1[i] = n1 + "-" + n3 + "+" + n2;
                            againArrP1[i] = n2 + "-" + n3 + "+" + n1;
                            resArr[i] = n1 + n2 - n3;
                            resArrP[i] = n1 + n2;
                            break;
                        case 2:
                            againArr[i] = n1 + "-" + n2 + "+" + n3;
                            againArrP1[i] = n1 + "+" + n3 + "-" + n2;
                            againArrP1[i] = n3 + "+" + n1 + "-" + n2;
                            resArr[i] = n1 - n2 + n3;
                            resArrP[i] = n1 - n2;
                            break;
                        case 3:
                            againArr[i] = n1 + "-" + n2 + "-" + n3;
                            resArr[i] = n1 - n2 - n3;
                            break;
                    }
                    break;
            }
            if (resArr[i] > 100 || resArr[i] < 0
                    || resArrP[i] > 100 || resArrP[i] < 0) {
                i--;
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (againArr[i].equals(againArr[j]) || againArr[i].equals(againArrP1[j])
                        || againArr[i].equals(againArrP2[j])) {
                    i--;
                    continue label;
                }
            }
            System.out.println(i+1 + "." +againArr[i] + "=");
        }
        for (int i = 0; i < numSum; i++) {
            System.out.println(i+1 + "." + resArr[i]);
        }
    }
}

