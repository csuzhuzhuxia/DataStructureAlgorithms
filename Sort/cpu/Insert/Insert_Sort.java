package Insert;

import Util.Number_Util;

public class Insert_Sort {
    /**
     * 直接插入排序算法，默认是按照升序的
     */
    public void insert_sort(int[] array_numbers){
        int length = array_numbers.length;

        //每一次都是重新添加一个数到自己排好序的数组中,最开始的数组其实第一个可以认为是排好序的
        for (int i=1;i<length;i++){
            int number  = array_numbers[i];
            int j=0;
            int k =0;
            for (j=i-1;j>=0;j--){
                if(number>array_numbers[j]){
                    break;
                }
            }
            for (k=i;k>j+1;k--){
                if (k-1<0){
                    System.out.println("");
                }
                array_numbers[k] = array_numbers[k-1];
            }
            array_numbers[j+1] = number;
//            for(int j=0;j<i;j++){
//                if(number<array_numbers[j]){
//                    for(int k=i;k>j;k--){
//                        array_numbers[k] = array_numbers[k-1];
//                    }
//                    array_numbers[j] =number;
//                    break;
//                }
//            }
        }
    }

    public void showArrayNum(int[] array_numbers,boolean isShowData){

        if(isShowData){
            Number_Util.print_numbers(0,array_numbers);
        }

        long timestamp_start = System.currentTimeMillis();
        insert_sort(array_numbers);
//        Number_Util.change(0,1,array_numbers);
        long timestamp_end = System.currentTimeMillis();
        long time = timestamp_end-timestamp_start;

        if(isShowData){
            Number_Util.print_numbers(1,array_numbers);
        }

        System.out.println("耗时 ："+time+"  毫秒");

    }

    public static void main(String[] args) {
        Insert_Sort insert = new Insert_Sort();
        int[] array_numbers = Number_Util.getNumbers(30000,99999);
        insert.showArrayNum(array_numbers,true);
    }

}
