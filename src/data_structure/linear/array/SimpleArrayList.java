package array;

public class SimpleArrayList {

   //��̿��� ��̸���Ʈ�� �ٲ㺼�ž�
   int capacity = 3;   //���߿� �÷�������. ���߿� �ȹٲ�� �Ϸ��� final ����
   String[] dataArray = new String[capacity];      //ǥ���� �ڷᱸ�� ��������
   int size = 0;   //������ ���� = ������ ����

   String get(int index) {
      //�ε��� �� �޾Ƽ� ����� ������ ���������
      if(index<0 || index>size-1) {
    	  return null;
      }
      return dataArray[index];
   }
   
   void add(int index, String data) {
      //��� ��ġ�� �־��
	  if(index<0 || index>size) {
		  return; // validation check
	  }
	  if(size == capacity) {
		  enlargeCapacity(); // return;
	  }
	  for (int i = size-1; i>=index; i--) {
		  dataArray[i+1] = dataArray[i];   //����Ȯ��
	  }
	  dataArray[index] = data;
	  size++;
   }
   
   private void enlargeCapacity() {
	   // TODO Auto-generated method stub
	   String [] bigArray = new String [capacity * 2];
	   System.arraycopy(dataArray, 0, bigArray, 0, size);
	   dataArray = bigArray;
	   capacity = capacity * 2;
   }
   
   String remove(int index) {
      if(index<0 || index>size) {
         return null;
      }
      String val = dataArray[index];
      for(int i = index+1; i<size; i++) {
         dataArray[i-1] = dataArray[i];
      }
      return val;
      
   }
   boolean remove(String data) {
      int temp = indexOf(data);
      return (remove(temp) != null);
   }
   
   int indexOf(String data) {
      for(int i=0; i<size; i++) {
         if(data==dataArray[i]) {
        	 return i;
         }
      }
      return -1;
   }
   
   public int sizeOf() {
      return size;
   }
   
   public String toString() {
      String result = "";
      for(int i = 0; i<size; i++) {
    	  result = result + dataArray[i].toString() + " ";
      }
      return result;
   }
   
}