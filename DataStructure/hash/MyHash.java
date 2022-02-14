package hash;

public class MyHash {
    // 해시 테이블
    public Slot[] hashTable;
    
    public MyHash(Integer size) {
        this.hashTable = new Slot[size];
    }
    
    public class Slot {
        String key;
        String value;
        Slot next;  // 링크드리스트
        public Slot(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    
    // 해시 함수
    public Integer hashFunc(String key) {
        return (int)(key.charAt(0)) % this.hashTable.length;
    }
    
    // 데이터 추가
    public boolean saveData(String key, String value) {
        // 1. 해시주소를 얻는다
        Integer address = hashFunc(key);
        // 2. 해당 해시주소의 해시테이블에 데이터가 있는지 체크
        if(hashTable[address] != null) {
            // 2-1. 데이터가 있다
            // 존재하는 데이터 내에서 일치하는 key가 있는지 탐색
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
            // 2-2. 데이터가 없다
            hashTable[address] = new Slot(key, value);
            
        }
        return true;
    }
    
    // 특정 key값의 value가져오기
    public String getData(String key) {
        // 1. 해시주소 얻기
        Integer address = hashFunc(key);
        // 2. 해당 해시주소의 해시테이블에 데이터가 있는지 확인
        if(hashTable[address] != null) {
            // 2-1. 데이터가 있다.
            // 존재하는 데이터 내에서 일치하는 key가 있는지 탐색
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
            // 2-2. 데이터가 없다.
            return null;
            
        }
    }
    
    public static void main(String[] args) {
    	MyHash mainObject = new MyHash(20);
    	mainObject.saveData("손흥민", "15143948");
    	mainObject.saveData("박지성", "21348275");
    	mainObject.saveData("로이스", "37845482");
    	mainObject.saveData("뮐러", "44857935");
    	System.out.println(mainObject.getData("손흥민"));
    }
}
