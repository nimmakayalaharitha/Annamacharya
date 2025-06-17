public class Binarysearch 
{
	public static void main(String[] args) {
		int[] num= {9,8,4,10,1};
		int key=4;
		int left=0;
		int right=num.length-1;
		boolean found =false;
		while(left<=right)
		{
			int mid=(left+right)/2;
			if(num[mid]==key)
			{
				System.out.println("found" +key+" at index" +mid);
				found=true;
				break;
			}else if(key<num[mid])
			{
				right=mid-1;
			}
			else
			{
				left=mid+1;
			}
			
		}
		if(!found) {
			System.out.println("not found");
		}

	}

}
