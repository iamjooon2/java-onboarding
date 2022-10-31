package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        ArrayList<String> answer = new ArrayList<>();
        HashMap<String, Integer> nameCountMap = new HashMap<>();

        for (int i = 0; i < forms.size(); i += 1) {
            nameCount(forms, nameCountMap, i);
        }

        for (String key : nameCountMap.keySet()) {
            if (nameCountMap.get(key) > 1) {
                getOverlapEmail(forms, key, answer);
            }
        }

        Collections.sort(answer);

        return answer;
    }

    public static HashMap<String, Integer> nameCount(List<List<String>> forms, HashMap<String, Integer> nameCountMap, int index){
        for (int j = 0; j < forms.get(index).get(1).length() - 1; j += 1) {
            String slicedName = forms.get(index).get(1).substring(j, j + 2);
            updateNameCunt(nameCountMap, slicedName);
        }
        return nameCountMap;
    }

    public static void getOverlapEmail(List<List<String>> forms, String key, ArrayList<String> answer){
        for (int i = 0; i < forms.size(); i += 1) {
            if (forms.get(i).get(1).contains(key)) {
                answer.add(forms.get(i).get(0));
            }
        }
    }

    public static Integer updateNameCunt(HashMap<String, Integer> hashMap, String string) {
        if (hashMap.containsKey(string)) {
            return hashMap.put(string, hashMap.get(string) + 1);
        }
        return hashMap.put(string, 1);
    }
}