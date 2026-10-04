// Definition for a pair
// class Pair {
//     int key;
//     String value;
//
//     Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
public class Solution {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {
        List<List<Pair>> result = new ArrayList<>();

        for (int i = 0; i < pairs.size(); i++) {
            int j = i;

            // Swap left while the left neighbour has a bigger key
            while (j > 0 && pairs.get(j - 1).key>pairs.get(j).key){

                Pair temp = pairs.get(j);
                pairs.set(j, pairs.get(j - 1));
                pairs.set(j - 1, temp);
                j--;
            
            }

            // Save a copy after each insertion
            result.add(new ArrayList<>(pairs));
        }

        return result;
    }
}
