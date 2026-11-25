import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void merge(int[] a,int[] temp, int low, int mid, int high){
        int i=low;
        int j=mid+1;
        int k=low;

        while(i<=mid && j<=high){
            if(a[i]<=a[j]){
                temp[k++]=a[i++];
            }
            else{
                temp[k++]=a[j++];
            }
        }

        while(i<=mid){
            temp[k++]=a[i++];
        }

        while(j<=high){
            temp[k++]=a[j++];
        }

        for(int p=low;p<=high;p++){
            a[p]=temp[p];
        }
    }

    public static void mergeSort(int[] a, int[] temp, int low, int high){
        if(low<high) {
            int mid=low+(high-low)/2;
            mergeSort(a, temp, low, mid);
            mergeSort(a, temp, mid+1, high);
            merge(a, temp, low, mid, high);
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter array size: ");
        int n=sc.nextInt();

        if(n<=0){
            System.out.println("Invalid input");
            return;
        }

        int []a=new int[n];
        int []temp=new int[n];

        System.out.println("Enter array elements: ");
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }

        mergeSort(a, temp, 0, n-1);
        System.out.println("Sorted Array: "+Arrays.toString(a));

    }
}