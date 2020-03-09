package Shell_Insert;

import Util.Number_Util;

public class Shell_Insert_Sort {

    /**
     * 这里采用的是那个希尔排序
     * @param arrayNumbers 这里主要是输入的原始数组
     *
     */
    public void shell_insert_sort(int[] arrayNumbers){
        int length = arrayNumbers.length;
        int h = 0;
        int block = 3;

        //h为分组，每块有多少个元素
        while(h<length){
            h = h*block + 1;
        }

        while (h>=1){
            int n,i,j,k;
            for(n=0;n<h;n++){
                //对于每个序列，进行直接插入排序
                for(i=n+h;i<length;i+=h){
                    for (j= i-h;j>=0&&arrayNumbers[j]>arrayNumbers[i];j-=h){

                    }
                    int temp = arrayNumbers[i];
                    for (k=i;k>j+h;k-=h){
                        arrayNumbers[k] = arrayNumbers[k-h];
                    }
                    arrayNumbers[j+h] = temp;
                }
            }
            h = h / block;
        }
    }

    public void showArrayNum(int[] array_numbers,boolean isShowData){

        if(isShowData){
            Number_Util.print_numbers(0,array_numbers);
        }

        long timestamp_start = System.currentTimeMillis();
        shell_insert_sort(array_numbers);
//        Number_Util.change(0,1,array_numbers);
        long timestamp_end = System.currentTimeMillis();
        long time = timestamp_end-timestamp_start;

        if(isShowData){
            Number_Util.print_numbers(1,array_numbers);
        }

        System.out.println("Shell排序 算法耗时 ："+time+"  毫秒");

    }

    public static void main(String[] args) {
        Shell_Insert_Sort shell = new Shell_Insert_Sort();
        int[] array_numbers = Number_Util.getNumbers(30000,99999);
        shell.showArrayNum(array_numbers,true);
    }

}
