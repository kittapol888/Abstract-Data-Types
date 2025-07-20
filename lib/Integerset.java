package lib;
import java.util.ArrayList;
import java.util.Collections;

/**ADT ที่เก็บเลขจำนวนเต็ม แบบไม่ซ้ำกันและเรียงลำดับ
 */
public class IntegerSet {
    private ArrayList<Integer> Integer = new ArrayList<>();

    // Rep Invariant (RI):
    //  - ต้องไม่มีมีเลขซ้ำกันในเซต.
    //  - เลขทั้งหมดต้องเรียงจากน้อยไปมาก.
    //
    // Abstraction Function (AF):
    //  - AF(Integer) = เซตของจำนวนเต็มทั้งหมดอาเรลิสต์.
    /**
     * Constructor เริ่มต้น สร้างเซตว่าง
     */

    public IntegerSet() {
        Integer = new ArrayList<>();
        checkrep();
    }


/**
 * Representation invariant:
 * - ต้องไม่เป็น null
 * - ต้องเรียงลำดับและห้ามมีเลขซ้ำ
 */
    private void checkrep() {
        if (Integer == null) {
            throw new RuntimeException("Data list cannot be null");
        }

        for (int i = 0; i < Integer.size() - 1; i++) {
            if (Integer.get(i) >= Integer.get(i + 1)) {
                throw new RuntimeException("List must be strictly increasing (sorted, no duplicates)");
            }
        }
    }

    
    /**
     * เรียงลำดับตัวเลขในเซตจากน้อยไปมาก.
     */
    private void sort() {
        Collections.sort(Integer);
        checkrep();
    }

    /**
     * เพิ่มเลขเข้าไปในเซต.
     * @param x เลขจำนวนเต็มที่ต้องการเพิ่ม
     * @effects ถ้ามีอยู่แล้วจะไม่เพิ่มซ้ำ
     */
    public void add(int x) {
        if(Integer.contains(x)) return;
        Integer.add(x);
        sort();
        checkrep();
    }


    /**
     * ลบเลขออกจากเซต
     * @param x เลขที่ต้องการลบ
     * @effects ถ้าไม่มีอยู่ก็ไม่เป็นไร
     */
    public void remove(int x) {
        Integer.remove((Integer) x);
        checkrep();
    }

    /**
     * ตรวจสอบว่าเซตนี้มีเลขที่ระบุอยู่หรือไม่
     * @param x เลขที่ต้องการตรวจสอบ
     * @return true ถ้ามีเลขนี้ในเซต, false ถ้าไม่มี
     */
    public boolean contains(int x) {
        return Integer.contains(x);
    }

    /**
     * นับจำนวนตัวเลขในเซตนี้
     * @return จำนวนตัวเลขทั้งหมด
     */

    public int size() {
        return Integer.size();
    }

    /**
     * @return ข้อความที่แสดงรายการเลขทั้งหมดในเซต
     */
    @Override
    public String toString() {
        return Integer.toString();
    }
}


