
import java.util.*;
class Main {
    public static void main(String[] args) {
       int[][] a={
           {1,2,3},
           {5,6,7},
           {8,9,0}
       };
       int n=a.length;
       
       for(int i=0;i<n;i++){
           for(int j=i;j<n;j++){
               int temp=a[i][j];
               a[i][j]=a[j][i];
               a[j][i]=temp;
           }
       }
       
       for(int i=0;i<n;i++){
           for(int j=0;j<n;j++){
               int temp=a[i][j];
               a[i][j]=a[i][n-1-j];
               a[i][n-1-j]=temp;
           }
          
       }
       for(int[] matrix:a){
              System.out.println(Arrays.toString(matrix));
          }
    }
}
