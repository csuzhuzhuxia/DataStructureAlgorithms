package Util;

import java.util.Random;

public class Number_Util {
    /**
     * 随机获取int数组
     */
    public static int[] getNumbers(int length,int max){
        int numbers[] = new int[length];
        Random random = new Random();
        for (int i=0;i<length;i++){
            numbers[i]= random.nextInt(max);
        }
        return numbers;
    }

    /**
     * 打印我们的数组
     * @param type 0\1 0:表示排序之前 1：表示排序之后
     * @param array_numbers:数组
     */
    public static void print_numbers(int type,int[] array_numbers){
        if (type ==0){
            System.out.println("排序之前的数组");
        }else if (type ==1){
            System.out.println("排序之后的数组");
        }else{
            System.out.println("参数异常，type 0\\1 0:表示排序之前 1：表示排序之后");
        }

        int length = array_numbers.length;
        if(length<40){
            for (int i=0;i<length;i++){
                System.out.print(array_numbers[i]+"  ");
            }
        }else {
            for (int i=0;i<length;i++){
                if(i<10){
                    System.out.print(array_numbers[i]+"  ");
                }else if(i>length-11){
                    System.out.print(array_numbers[i]+"  ");
                }else if (i==10){
                    System.out.print("......");
                }
            }
        }
    }

    /**
     * 交换数组中两个位置的值
     */
    public static void change(int first,int next,int[] array_numbers){
        int temp = array_numbers[first];
        array_numbers[first] = array_numbers[next];
        array_numbers[next] = temp;
    }

}
