//https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/

import java.util.*;

public class FindAllPossibleRecipesFromGivenSupplies {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {

        HashMap<String, Integer> lst = new HashMap<>();
        int l = 0;

        HashMap<String, List<String>> map = new HashMap<>();

        HashMap<String, Integer> ingredientsNeeded = new HashMap<>();

        for (int i = 0; i < recipes.length; i++) {
            for (String string : ingredients.get(i)) {
                map.putIfAbsent(string, new ArrayList<>());
                map.get(string).add(recipes[i]);
                if (!lst.containsKey(string)) {
                    lst.putIfAbsent(string, l);
                    l++;
                }
            }
            if (!lst.containsKey(recipes[i])) {
                lst.putIfAbsent(recipes[i], l);
                l++;
            }
            ingredientsNeeded.put(recipes[i], ingredients.get(i).size());
        }

        for (String string : supplies) {
            if (!lst.containsKey(string)) {
                lst.putIfAbsent(string, l);
                l++;
            }
        }

        System.out.println(ingredientsNeeded);

        boolean vis[] = new boolean[l];
        Arrays.fill(vis, false);
        Stack<String> st = new Stack<>();
        
        List<String> ans = new ArrayList<>();
        HashSet<String> set = new HashSet<>(Arrays.asList(recipes));

        for (int i = 0; i < supplies.length; i++) {
            String supply = supplies[i];
            if (!vis[lst.get(supply)]) {
                dfs(supply, lst, ans, vis, map , set,ingredientsNeeded);
            }
        }
        
        return ans;
    }

    private void dfs( String supply, HashMap<String, Integer > lst, List<String> ans, boolean[] vis, HashMap<String, List<String>> map, HashSet<String> set, HashMap<String, Integer> ingredientsNeeded) {
        vis[lst.get(supply)] = true;
        if(map.containsKey(supply))
        for(String s : map.get(supply)){
            if(!vis[lst.get(s)]){
                if(!vis[lst.get(s)]){
                    if(ingredientsNeeded.containsKey(s)) ingredientsNeeded.put(s,ingredientsNeeded.getOrDefault(s, 0)-1);
                    if(!ingredientsNeeded.containsKey(s) || ingredientsNeeded.get(s) == 0)
                        dfs(s, lst, ans, vis, map,set,ingredientsNeeded);
                }
            }
        }
        if(set.contains(supply)) ans.add(supply);
    }
}
