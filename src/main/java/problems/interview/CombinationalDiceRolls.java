package problems.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationalDiceRolls {

    public static void main(String[] args) {
        CombinationalDiceRolls test = new CombinationalDiceRolls();
        System.out.println(test.getDiceRollsCombinations(3, 6));
        System.out.println(test.getDiceRollsCombinationsRecursively(3, 6, Collections.emptyList()));
    }

    public List<List<Integer>> getDiceRollsCombinationsRecursively(int numberOfDices, int faces, List<List<Integer>> combinations) {
        List<List<Integer>> currCombinations = new ArrayList<>();

        if (combinations.isEmpty()) {
            for (int i = 1; i <= faces; i++) {
                List<Integer> curr = new ArrayList<>();
                curr.add(i);
                currCombinations.add(curr);
            }
        } else {
            for (List<Integer> list : combinations) {
                for (int i = 1; i <= faces; i++) {
                    List<Integer> currList = new ArrayList<>(list);
                    currList.add(i);
                    currCombinations.add(currList);
                }
            }
        }

        while (numberOfDices > 1) {
            return getDiceRollsCombinationsRecursively(numberOfDices - 1, faces, currCombinations);
        }

        System.out.println(currCombinations.size());

        return currCombinations;
    }

    public List<List<Integer>> getDiceRollsCombinations(int numberOfDices, int faces) {
        List<List<Integer>> combinations = new ArrayList<>();

        for (int i = 1; i <= faces; i++) {
            List<Integer> curr = new ArrayList<>();
            curr.add(i);
            combinations.add(curr);
        }

        while (numberOfDices > 1) {
            combinations = append(combinations, faces);
            numberOfDices -= 1;
        }

        System.out.println(combinations.size());

        return combinations;
    }

    public List<List<Integer>> append(List<List<Integer>> combinations, int faces) {
        List<List<Integer>> currCombinations = new ArrayList<>();

        for (List<Integer> list : combinations) {
            for (int i = 1; i <= faces; i++) {
                List<Integer> currList = new ArrayList<>(list);
                currList.add(i);
                currCombinations.add(currList);
            }
        }

        return currCombinations;
    }

}