import java.util.TreeMap;

public class Map {
    TreeMap<Character, Integer> romaMap = new TreeMap<>();


    public Map() {
        romaMap.put('I', 1);
        romaMap.put('V', 5);
        romaMap.put('X', 10);

        ArabMap.put(100, "C");
        ArabMap.put(90, "XC");
        ArabMap.put(50, "L");
        ArabMap.put(40, "XL");
        ArabMap.put(10, "X");
        ArabMap.put(9, "IX");
        ArabMap.put(5, "V");
        ArabMap.put(4, "IV");
        ArabMap.put(1, "I");
    }
    TreeMap<Integer, String> ArabMap = new TreeMap<>();

    public boolean isRoma(String number) {
        return romaMap.containsKey(number.charAt(0));
    }

    public String intRoma(int numFromArabMap) {
        String roma = "";
        int arabNum;
        do {
            arabNum = ArabMap.floorKey(numFromArabMap);
            roma += ArabMap.get(arabNum);
            numFromArabMap -=  arabNum;
        }
        while (numFromArabMap != 0);
        return roma;
    }

    public int romaInt(String s) {
        int end = s.length() - 1;
        char[] arr = s.toCharArray();
        int arab;
        int finish = romaMap.get(arr[end]);
        for (int i = end - 1; i >= 0; i--) {
            arab = romaMap.get(arr[i]);

            if (arab < romaMap.get(arr[i + 1])) {
                finish -= arab;
            } else {
                finish +=  arab;
            }

        }
        return finish;

    }
}

