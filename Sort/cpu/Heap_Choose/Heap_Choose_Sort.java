package Heap_Choose;

import Util.Number_Util;

public class Heap_Choose_Sort {

    /**
     * 交换第一个和最后一个元素，输出最后一个元素（最大值），然后把剩下元素重新调整为大根堆
     * @param arrayNumbers
     */
    public void heap_choose_part(int[] arrayNumbers,int parents,int length){
        int temp = arrayNumbers[parents];
        int child = parents * 2 +1;//做孩子
        while (child<length){
            if ((child+1<length)&&arrayNumbers[child+1]>arrayNumbers[child]){
                child++;
            }
            if (temp>arrayNumbers[child]){
                break;
            }
            arrayNumbers[parents] = arrayNumbers[child];
            parents = child;
            child = parents*2 +1;
        }
        arrayNumbers[parents] = temp;

    }

    public void heap_choose_sort(int[] arrayNumbers){
        
        //首先我们建立原始堆
        int length = arrayNumbers.length;
        for (int i = length/2-1; i >=0 ; i--) {
            heap_choose_part(arrayNumbers,i,length);
        }

        //每次输出一个进行排序
        for (int i = length-1; i >=0; i--) {
            int temp = arrayNumbers[i];
            arrayNumbers[i] = arrayNumbers[0];
            arrayNumbers[0] = temp;
            heap_choose_part(arrayNumbers,0,i);
        }
    }

    public void showArrayNum(int[] array_numbers,boolean isShowData){
        if(isShowData){
            Number_Util.print_numbers(0,array_numbers);
        }


        long timestamp_start = System.currentTimeMillis();
        heap_choose_sort(array_numbers);
        long timestamp_end = System.currentTimeMillis();
        long time = timestamp_end-timestamp_start;

        if(isShowData){
            Number_Util.print_numbers(1,array_numbers);
        }

        System.out.println("堆选择排序 算法耗时 ："+time+"  毫秒");

    }

    public static void main(String[] args) {
        Heap_Choose_Sort heap_choose = new Heap_Choose_Sort();
        int[] array_numbers = Number_Util.getNumbers(39,99999);
        heap_choose.showArrayNum(array_numbers,true);

    }
}
