package hash;

public class MyHash {
    // �ؽ� ���̺�
    public Slot[] hashTable;
    
    public MyHash(Integer size) {
        this.hashTable = new Slot[size];
    }
    
    public class Slot {
        String key;
        String value;
        Slot next;  // ��ũ�帮��Ʈ
        public Slot(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    
    // �ؽ� �Լ�
    public Integer hashFunc(String key) {
        return (int)(key.charAt(0)) % this.hashTable.length;
    }
    
    // ������ �߰�
    public boolean saveData(String key, String value) {
        // 1. �ؽ��ּҸ� ��´�
        Integer address = hashFunc(key);
        // 2. �ش� �ؽ��ּ��� �ؽ����̺� �����Ͱ� �ִ��� üũ
        if(hashTable[address] != null) {
            // 2-1. �����Ͱ� �ִ�
            // �����ϴ� ������ ������ ��ġ�ϴ� key�� �ִ��� Ž��
            Slot findSlot = hashTable[address];
            Slot prevSlot = hashTable[address];
            
            while(findSlot != null) {
                if(findSlot.key == key) {
                    findSlot.value = value;
                    return true;
                } else {
                    prevSlot = findSlot;
                    findSlot = findSlot.next;
                }
            }
            prevSlot.next = new Slot(key, value);
            
        } else {
            // 2-2. �����Ͱ� ����
            hashTable[address] = new Slot(key, value);
            
        }
        return true;
    }
    
    // Ư�� key���� value��������
    public String getData(String key) {
        // 1. �ؽ��ּ� ���
        Integer address = hashFunc(key);
        // 2. �ش� �ؽ��ּ��� �ؽ����̺� �����Ͱ� �ִ��� Ȯ��
        if(hashTable[address] != null) {
            // 2-1. �����Ͱ� �ִ�.
            // �����ϴ� ������ ������ ��ġ�ϴ� key�� �ִ��� Ž��
            Slot findSlot = hashTable[address];
            
            while(findSlot != null) {
                if(findSlot.key == key) {
                    return findSlot.value;
                } else {
                    findSlot = findSlot.next;
                }   
            }
            return null;
            
        } else {
            // 2-2. �����Ͱ� ����.
            return null;
            
        }
    }
    
    public static void main(String[] args) {
    	MyHash mainObject = new MyHash(20);
    	mainObject.saveData("�����", "15143948");
    	mainObject.saveData("������", "21348275");
    	mainObject.saveData("���̽�", "37845482");
    	mainObject.saveData("����", "44857935");
    	System.out.println(mainObject.getData("�����"));
    }
}
