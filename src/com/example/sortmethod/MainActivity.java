package com.example.sortmethod;

import java.util.ArrayList;

import com.example.methodsort.R;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
	private Button insertButton;
	private Button shellButton;
	private Button simpleButton;
	private Button divideButton;
	private Button heapButton;
	private Button bubbleButton;
	private Button quickButton;
	private Button mergeButton;
	private Button radixButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        insertButton = (Button)findViewById(R.id.insertSort);
        shellButton = (Button)findViewById(R.id.shellSort);
        simpleButton = (Button)findViewById(R.id.SimpleSort);
        divideButton = (Button)findViewById(R.id.divideSort);
        heapButton = (Button)findViewById(R.id.HeapSort);
        bubbleButton = (Button)findViewById(R.id.bubbleSort);
        quickButton =(Button)findViewById(R.id.quickSort);
        mergeButton = (Button)findViewById(R.id.mergeSort);
        radixButton = (Button)findViewById(R.id.radixSort);
        
        insertButton.setOnClickListener(this);
        shellButton.setOnClickListener(this);
        simpleButton.setOnClickListener(this);
        divideButton.setOnClickListener(this);
        heapButton.setOnClickListener(this);
        bubbleButton.setOnClickListener(this);
        quickButton.setOnClickListener(this);
        mergeButton.setOnClickListener(this);
        radixButton.setOnClickListener(this);
    }


    public void insertSort(){
    	int[] a = {49,38,65,97,76,13,27,49,78,34,12,64,5,4};
    	int temp = 0;
    	for(int i = 1;i < a.length;i++){
    		temp = a[i];
    		int j;
    		for(j = i - 1;j >= 0 ;j--){
    			if(a[j]>temp){
    				a[j+1]=a[j];
    			}else {
					break;
				}
    		}
    		a[j+1] = temp;
    		Log.e("j", ""+j);
    	}
    	
    	for(int i = 0;i < a.length;i++){
    		Log.e("insert", ""+a[i]);
    	}
    }
    
    public void shellSort(){
    	int[] a = {49,38,65,97,76,13,27,49,78,34,12,64,1};
    	for(int i = 0;i < a.length;i++){
    		Log.e("希尔排序之前", ""+a[i]);
    	}
    	
    	int d = a.length;
    	while(true){
    		d = d / 2;
    		for(int x = 0;x < d;x++){
    			for(int i=x+d;i<a.length;i=i+d){
    				int temp = a[i];
    				int j;
    				for(j=i-d;j>=0&&a[j]>temp;j=j-d){
    					a[j+d]=a[j];
    					Log.e("j", ""+j);
    				}
    				a[j+d]=temp;
    			}
    		}
    		if(d == 1){
    			break;
    		}
    	}
    	
    	for(int i = 0;i < a.length;i++){
    		Log.e("排序之后", ""+a[i]);
    	}
    }
    
    public void divideSort(){
    	int[] a = {49,38,65,97,176,213,227,49,78,34,12,164,11,18,1};
    	for(int i = 0;i<a.length;i++){
    		Log.e("二分法：", ""+a[i]);
    	}
    	
    	for(int i=0;i<a.length;i++){
    		int temp = a[i];
    		int left = 0;
    		int middle = 0;
    		int right = i-1;
    		while(left<=right){
    			middle = (left+right)/2;
    			if(temp > a[middle]){
    				left = middle + 1;
    			}else{
					right = middle - 1;
				}
    		}
    		for(int j = i-1;j>=left;j--){
    			a[j+1]=a[j];
    		}
    		if(left != i){
    			a[left]=temp;
    		}
    	}
    	
    	for(int i=0;i<a.length;i++){
    		Log.e("排序后", ""+a[i]);
    	}
    }
    
    public void SimpleSort(){
    	int[] a={49,38,65,97,76,13,27,49,78,34,12,64,1,8};
    	for(int i=0;i<a.length;i++){
    		Log.e("简单排序前", ""+a[i]);
    	}
    	
    	for(int i=0;i<a.length;i++){
    		int min=a[i];
    		int n = i;
    		for(int j=i+1;j<a.length;j++){
    			if(min > a[j]){
    				min=a[j];
    				n=j;
    			}
    		}
    		a[n]=a[i];
    		a[i]=min;
    	}
    	
    	for(int i=0;i<a.length;i++){
    		Log.e("排序后", ""+a[i]);
    	}
    }
    
    public void HeapSort(){
    	int[] a={49,38,65,97,76,13,27,49,78,34,12,64};
    	for(int i = 0;i < a.length-1;i++){
    			BuildHeap(a, a.length-1-i);
    			swap(a, 0, a.length-1-i);
    	}
    	
    	for(int j = 0;j <a.length;j++){
    		Log.e("堆排序", ""+a[j]);
    	}
    	
    }
    
    public void BuildHeap(int[] a,int lastIndex){
    	for(int i = (lastIndex - 1)/2;i>=0;i--){
    		int k = i;
    		while(2*k+1<=lastIndex){
    			int biggerIndex = 2*k+1;
    			if(biggerIndex < lastIndex){
    				if(a[biggerIndex]<a[biggerIndex+1]){
    					biggerIndex++;
    				}
    			}
    			if(a[k] < a[biggerIndex]){
    				swap(a, k, biggerIndex);
    				k = biggerIndex;
    			}else {
					break;
				}
    		}
    	}
    }
    
    public void swap(int[] a,int i,int j){
    	int temp = a[i];
    	a[i] = a[j];
    	a[j] = temp;
    }
    
    public void BubbleSort(){
    	int[] a={49,38,65,97,76,13,27,49,78,34,12,64,1,8};
    	for(int i=0;i<a.length;i++){
    		Log.e("冒泡排序前", ""+a[i]);
    	}
    	
    	for(int i=0;i<a.length;i++){
    		for(int j=0;j<a.length-i-1;j++){	
    			if(a[j]>a[j+1]){
    				int temp=a[j];
    				a[j]=a[j+1];
    				a[j+1]=temp;
    			}
    		}
    	}
    	
    	for(int i=0;i<a.length;i++){
    		Log.e("冒泡后：", ""+a[i]);
    	}
    }
    
    public void quickSort(){
    	int[] a={49,38,65,97,76,13,27,49,78,34,12,64,1,8};
    	for(int i = 0;i<a.length;i++){
    		Log.e("快速排序", ""+a[i]);
    	}
    	quick(a, 0, a.length-1);
    	
    	for(int i = 0;i<a.length;i++){
    		Log.e("快速排序后", ""+a[i]);
    	}
    	
    }
    
    public void quick(int[] a,int l,int r){
    	if(l < r){
    		int i = l;
    		int j = r;
    		int temp = a[l];
    		
    		while(i < j){
    			while(i < j&&a[j]>=temp){
    				j--;
    			}
    			if(i < j){
    				a[i++]=a[j];
    			}
    			
    			while(i < j&&a[i]<temp){
    				i++;
    			}
    			if(i<j){
    				a[j--]=a[i];
    			}
    		}
    		a[i]=temp;
    		quick(a, l, i-1);
    		quick(a, i+1, r);
    	}
    }
    
    public void MergeSort(){
    	int[] a={49,38,65,97,76,13,27,49,78,34,12,64,1,8};
    	for(int i=0;i<a.length;i++){
    		Log.e("归并排序前", ""+a[i]);
    	}
    	
    	mergesort(a, 0, a.length-1);
    	
    	for(int i=0;i<a.length;i++){
    		Log.e("归并排序之后", ""+a[i]);
    	}
  	
    }
    
    public void mergesort(int[] a,int left,int right){
    	if(left < right){
    		int middle = (left+right)/2;
    		mergesort(a, left, middle);
    		mergesort(a, middle+1, right);
    		merge(a, left, middle, right);
    	}
    }
    
    public void merge(int[] a,int left,int middle,int right){
    	int[] tempArr = new int[a.length];
    	int mid = middle + 1;
    	int tmp = left;
    	int third = left;
    	
    	while(left <=middle && mid<=right){
    		if(a[left]<=a[mid]){
    			tempArr[third++]=a[left++];
    		}else {
				tempArr[third++]=a[mid++];
			}
    	}
    	
    	while (left<=middle) {
			tempArr[third++]=a[left++];
		}
    	
    	while (mid<=right) {
			tempArr[third++]=a[mid++];
		}
    	
    	while (tmp<=right) {
			a[tmp]=tempArr[tmp++];
		}	
    }
    

    public void RadixSort(){
    	int[] a={49,38,65,97,176,213,227,49,78,34,12,164,11,18,1};
    	for(int i=0;i<a.length;i++){
    		Log.e("基数排序前", ""+a[i]);
    	}
    	
    	radixsort(a);
    	
    	for(int i=0;i<a.length;i++){
    		Log.e("基数排序后", ""+a[i]);
    	}
    	
    }
    
    public void radixsort(int[] a){
    	int max = 0;
    	for(int i=0;i<a.length;i++){
    		if(max<a[i]){
    			max=a[i];
    		}
    	}
    	
    	int times = 0;
    	while (max>0) {
			max = max/10;
			times++;
		}
    	
    	ArrayList<ArrayList>queue = new ArrayList<ArrayList>();
    	for(int i=0;i<10;i++){
    		ArrayList queue1 = new ArrayList();
    		queue.add(queue1);
    	}
    	
    	for(int i=0;i<times;i++){
    		//分配
    		for(int j=0;j<a.length;j++){
    			int x = a[j]%(int)Math.pow(10, i+1)/(int)Math.pow(10,i);
    			ArrayList queue2 = queue.get(x);
    			queue2.add(a[j]);
    			queue.set(x, queue2);
    		}
    		
    		//收集
    		int count=0;
    		for(int j=0;j<10;j++){
    			while (queue.get(j).size()>0) {
					ArrayList<Integer> queue3 = queue.get(j);
					a[count]=queue3.get(0);
					queue3.remove(0);
					count++;
				}
    		}
    	}
    }


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.insertSort:
			insertSort();
			break;
			
		case R.id.shellSort:
			shellSort();
			break;
			
		case R.id.SimpleSort:
			SimpleSort();
			break;
			
		case R.id.divideSort:
			divideSort();
			break;
			
		case R.id.HeapSort:
			HeapSort();
			break;
			
		case R.id.bubbleSort:
			BubbleSort();
			break;
			
		case R.id.quickSort:
			quickSort();
			break;
			
		case R.id.mergeSort:
			MergeSort();
			break;
			
		case R.id.radixSort:
			RadixSort();
			break;

		default:
			break;
		}
	}
    
    
    
}

