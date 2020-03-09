package Radix;


import Util.Number_Util;

public class RadixSort {

    /**
     * 这里是基数排序，桶排序
     * @param arrayNumber  原始数组
     * @param max 这里表示是的是数组中出现的最大的值
     */
    public void radix_sort(int[] arrayNumber,int max){
        int n =1;
        int length = arrayNumber.length;

        //桶的容器
        int bucket[][] = new int[10][length];

        //这里使用order[digt]仅仅只是说用来记录相同尾数的个人
        int order[] = new int[length];
        int k = 0;
        while (n< max){
            for (int num: arrayNumber){
                int digt = (num/n)%10; //数字，位数
                bucket[digt][order[digt]] = num;
                order[digt]++;
            }

            for (int i = 0;i<length;i++){
                if (order[i] !=0){
                    for (int j=0;j<order[i];j++){
                        arrayNumber[k] = bucket[i][j];
                        k++;
                    }
                }
                order[i] = 0;
            }
            n*=10;
            k = 0;
        }
    }

    public void showArrayNum(int[] array_numbers,boolean isShowData){
        if(isShowData){
            Number_Util.print_numbers(0,array_numbers);
        }

        long timestamp_start = System.currentTimeMillis();
        radix_sort(array_numbers,100000);
//        Number_Util.change(0,1,array_numbers);
        long timestamp_end = System.currentTimeMillis();
        long time = timestamp_end-timestamp_start;

        if(isShowData){
            Number_Util.print_numbers(1,array_numbers);
        }

        System.out.println("基数排序 算法耗时 ："+time+"  毫秒");

    }

    public static void main(String[] args) {
        RadixSort radixSort = new RadixSort();
        int[] array_numbers = Number_Util.getNumbers(20,99);
        radixSort.showArrayNum(array_numbers,true);
    }

}
