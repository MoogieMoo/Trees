// Maggie Xia
// APCS2 pd1
// HW39 -- Heaping Piles of Sordidness
// 2017-05-11

public class HeapSort{
    
    public void heapSort(int arr[]){
        for (int x = arr.length / 2 - 1; x >= 0; x -= 1)
            heapify(arr, arr.length, x);
 
        for (int x = arr.length - 1; x >= 0; x -= 1){
            int temp = arr[0];
            arr[0] = arr[x];
            arr[x] = temp;
 
            heapify(arr, x, 0);
        }
    }
 
    public void heapify(int arr[], int a, int b){
        int largest = b;
        int l = 2 * b + 1;  //left
        int r = 2 * b + 2;  //right
 
        if (l < a && arr[l] > arr[largest])
            largest = l;
 
        if (r < a && arr[r] > arr[largest])
            largest = r;
 
        if (largest != b){
            int swap = arr[b];
            arr[b] = arr[largest];
            arr[largest] = swap;
 
            heapify(arr, a, largest);
        }
    }
 
   
    public static String printArr(int arr[]){
	String ret = "";
        for (int x = 0; x < arr.length; x += 1)
           ret += arr[x]+" ";
	return ret;
    }

    
    public static void main(String[] args){
        int arr[] = {12,11,13,5,6,7};
 
        HeapSort test = new HeapSort();

	System.out.println("array before sorting:");
	System.out.println(printArr(arr));
	System.out.println();

	test.heapSort(arr);
        System.out.println("array after sorting:");
        System.out.println(printArr(arr));
    }
}
