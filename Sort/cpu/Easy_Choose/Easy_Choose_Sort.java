package Easy_Choose;

import Util.Number_Util;

public class Easy_Choose_Sort {


    /**
     * 简单排序
     * @param arrayNumbers 这里是指需要排序的原始序列
     */
    public void easy_choose_sort(int[] arrayNumbers){
        int length = arrayNumbers.length;
        int index;
        int MIN_Number;
        for(int i=0;i<length;i++){
            index = i;
            MIN_Number = arrayNumbers[i];
            for(int j=i;j<length;j++){
                if(arrayNumbers[j]<MIN_Number){
                    index = j;
                    MIN_Number = arrayNumbers[j];
                }
            }
            Number_Util.change(i,index,arrayNumbers);
        }
    }


    public void showArrayNum(int[] array_numbers,boolean isShowData){
        if(isShowData){
            Number_Util.print_numbers(0,array_numbers);
        }

        long timestamp_start = System.currentTimeMillis();
        easy_choose_sort(array_numbers);
//        Number_Util.change(0,1,array_numbers);
        long timestamp_end = System.currentTimeMillis();
        long time = timestamp_end-timestamp_start;

        if(isShowData){
            Number_Util.print_numbers(1,array_numbers);
        }

        System.out.println("简单选择排序 算法耗时 ："+time+"  毫秒");

    }

    public static void main(String[] args) {
        Easy_Choose_Sort easy_choose = new Easy_Choose_Sort();
        int[] array_numbers = Number_Util.getNumbers(39,99999);
        easy_choose.showArrayNum(array_numbers,true);
    }


}
