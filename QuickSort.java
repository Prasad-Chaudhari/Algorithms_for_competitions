class QuickSort{
    int [] a;
    public QuickSort(int b[],int left,int right){
        a=b;
        sort(left,right);
    }
    void sort(int left,int right){
        if(left<right){
            int p=pivot(left,right);
            //print();
            sort(left,p-1);
            sort(p+1,right);
        }
    }
    int pivot(int left,int right){
        int less=left-1;
        int pivot=a[right];
        for(int i=left;i<=right;i++){
            if(a[i]<=pivot){
                less++;
                if(less!=i){
                    swap(less,i);
                }
            }
        }
        return less;
    }
    
    void swap(int i,int j){
        a[i]=a[i]^a[j];
        a[j]=a[i]^a[j];
        a[i]=a[i]^a[j];
    }
    void print(){
        for(int i:a){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
