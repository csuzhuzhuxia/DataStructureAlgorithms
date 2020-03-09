package Bubble_Exchange;

import Util.Number_Util;

public class Bubble_Exchange_Sort {

    /**
     *这里是采用冒泡交换排序的算法
     * @param arrayNumber
     */
    public void bubble_exchange_sort(int[] arrayNumber){
        int length = arrayNumber.length;
        //进行length-1次排序
        for (int i=0;i<length-1;i++){
            for (int j=length-1;j>i;j--){
                if(arrayNumber[j]<arrayNumber[j-1]){
                    Number_Util.change(j,j-1,arrayNumber);
                }
            }
        }
    }

    public void showArrayNum(int[] array_numbers,boolean isShowData){
        if(isShowData){
            Number_Util.print_numbers(0,array_numbers);
        }

        long timestamp_start = System.currentTimeMillis();
        bubble_exchange_sort(array_numbers);
        long timestamp_end = System.currentTimeMillis();
        long time = timestamp_end-timestamp_start;

        if(isShowData){
            Number_Util.print_numbers(1,array_numbers);
        }

        System.out.println("冒泡交换排序 算法耗时 ："+time+"  毫秒");

    }

    public static void main(String[] args) {
        Bubble_Exchange_Sort bubble_exchange = new Bubble_Exchange_Sort();
        int[] array_numbers = Number_Util.getNumbers(39,99999);
        bubble_exchange.showArrayNum(array_numbers,true);
    }

}
