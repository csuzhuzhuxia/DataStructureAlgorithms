public class Leetcode149 {
    class Point {
      int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
    }


    public int maxPoints(Point[] points) {


        if (points.length<2){
            return points.length;
        }

        int length = points.length;
        int maxlength = 0;
        for (int i = 0; i < length; i++) {
            int count = 1;
            int same_point = 0;
            for (int j=i+1; j < length ; j++) {
                int dx1 = points[j].x-points[i].x;
                int dy1 = points[j].y-points[i].y;
                int k = generateGCD(dx1,dy1);
                if(k != 0) {
                    dx1/=k;
                    dy1/=k;
                }

                if (dx1==0&&dy1==0)
                    same_point++;
                else {
                    count++;
                    for (int l = j+1 ; l < length; l++) {
                        int dx2 = points[l].x-points[i].x;
                        int dy2 = points[l].y-points[i].y;
                        k = generateGCD(dx2,dy2);
                        if(k != 0) {
                            dx2/=k;
                            dy2/=k;
                        }
                        System.out.println(dx1*dy2+"----"+dx2*dy1);
                        if (dx1*dy2 == dx2*dy1){
                            count++;
                        }
                    }
                }
                maxlength = Math.max(count+same_point,maxlength);
                System.out.println(maxlength);
                count=1;

            }
        }
        return maxlength;
    }

    private int generateGCD(int x, int y) {
        if (y == 0)
            return x;
        return generateGCD(y, x % y);
    }

    public static void main(String[] args) {
        System.out.println(0-65536*65536);
    }
}