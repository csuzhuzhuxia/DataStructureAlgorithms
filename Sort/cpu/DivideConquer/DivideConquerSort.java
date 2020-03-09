package DivideConquer;

import Util.Number_Util;

public class DivideConquerSort {

    private int[] arrayNumbertemp;


    /**
     *
     * 归并排序
     * @param arrayNumbers 这里是原始的数组
     * @param left  左边的下标
     * @param mid  中间的下标
     * @param right 右边的下标
     */
    public void divide_conquer_sort(int[] arrayNumbers,int left,int mid, int right){


        int i = left;
        int j = mid + 1;
//        int N = right+1;

        for (int k = left;k<=right;k++){
            if (i > mid){ //左侧元素已经全部比较完毕
                arrayNumbertemp[k] = arrayNumbers[j++];
            }else if (j>right){ //右侧元素已经完全比较完毕
                arrayNumbertemp[k] = arrayNumbers[i++];
            }else if (arrayNumbers[i]<arrayNumbers[j]){
                arrayNumbertemp[k] = arrayNumbers[i++];
            }else {
                arrayNumbertemp[k] = arrayNumbers[j++];
            }
        }

        //之后进行一个覆盖
        for (int k= left;k<=right;k++){
            arrayNumbers[k] = arrayNumbertemp[k];
        }
    }

    public void merge(int[] arrayNumbers,int left,int right){
        if (left >= right){
            return;
        }
        int mid = (left+right)/2;
        merge(arrayNumbers,left,mid);
        merge(arrayNumbers,mid+1,right);
        divide_conquer_sort(arrayNumbers,left,mid,right);
    }

    public void sort(int[] arrayNumbers){
        int length = arrayNumbers.length;
        arrayNumbertemp = new int[length];
        merge(arrayNumbers,0,length-1);
    }

    public void showArrayNum(int[] array_numbers,boolean isShowData){
        if(isShowData){
            Number_Util.print_numbers(0,array_numbers);
        }

        long timestamp_start = System.currentTimeMillis();
        sort(array_numbers);
//        Number_Util.change(0,1,array_numbers);
        long timestamp_end = System.currentTimeMillis();
        long time = timestamp_end-timestamp_start;

        if(isShowData){
            Number_Util.print_numbers(1,array_numbers);
        }

        System.out.println("归并排序 算法耗时 ："+time+"  毫秒");

    }

    public static void main(String[] args) {
        DivideConquerSort divide_conquer = new DivideConquerSort();
        int[] array_numbers = Number_Util.getNumbers(30000,99999);
        divide_conquer.showArrayNum(array_numbers,true);
    }
}
