public class MergeSort implements SortingAlgorithm{
    void merge(int arr[], int l, int m, int r)
    {
        int i, j, k;
        int n1 = m - l + 1;
        int n2 =  r - m;


        int L [] = new int [n1];
        int R [] = new int [n2];


        for (i = 0; i < n1; i++)
            L[i] = arr[l + i];
        for (j = 0; j < n2; j++)
            R[j] = arr[m + 1+ j];


        i = 0;
        j = 0;
        k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }


        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }


        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }


    void sort(int arr[], int left, int right)
    {
        if (left < right)
        {

            int m = left+(right-left)/2;

            // Sort first and second halves
            sort(arr, left, m);
            sort(arr, m+1, right);

            merge(arr, left, m, right);
        }
    }
    @Override
    public void sort(int[] arr) {
        sort(arr, 0,arr.length-1);

    }
}
