package Quick_Exchange;

import Util.Number_Util;

public class Quick_Exchange_Sort {

    /**
     * 快速排序
     * @param arrayNumbers 原始数组
     */
    public void quick_exchange_sort(int[] arrayNumbers,int left,int right){
        int i,j;
        int temp = arrayNumbers[left];
        i = left;
        j = right;


        while (i!=j){
            while ((arrayNumbers[j]>temp)&&(i<j)){
                j--;
            }
            while ((arrayNumbers[i]<=temp)&&(i<j)){
                i++;
            }
            if (i<j){
                Number_Util.change(i,j,arrayNumbers);
            }
        }
        Number_Util.change(left,i,arrayNumbers);
        if (i-1>left){
            quick_exchange_sort(arrayNumbers,left,i-1);
        }
        if(i+1<right){
            quick_exchange_sort(arrayNumbers,i+1,right);
        }

    }

    public void showArrayNum(int[] array_numbers,boolean isShowData){
        if(isShowData){
            Number_Util.print_numbers(0,array_numbers);
        }

        long timestamp_start = System.currentTimeMillis();
        quick_exchange_sort(array_numbers,0,array_numbers.length-1);
//        Number_Util.change(0,1,array_numbers);
        long timestamp_end = System.currentTimeMillis();
        long time = timestamp_end-timestamp_start;

        if(isShowData){
            Number_Util.print_numbers(1,array_numbers);
        }

        System.out.println("快速交换排序 算法耗时 ："+time+"  毫秒");

    }

    public static void main(String[] args) {
        Quick_Exchange_Sort quick_exchange = new Quick_Exchange_Sort();
//        int[] array_numbers = Number_Util.getNumbers(39,99999);
        int[] array_numbers = {5,4,3,2,1};
        quick_exchange.showArrayNum(array_numbers,true);
    }
}
