package 코딩테스트.프로그래머스.정렬.메뉴리뉴얼;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    
    private static class Menu{
        String name;
        int count;
        
        public Menu(String name, int count){
            this.name = name;
            this.count = count;
        }
        
        public void addCount(){
            this.count++;
        }
        
        public String toString(){
            return "(" + this.name + " : " + this.count + ")";
        }
        
        public String getName(){
            return this.name;
        }
        
        public int getCount(){
            return this.count;
        }
    }
    
    public String[] solution(String[] orders, int[] course) {
        List<Menu> menus = new ArrayList<>();

        createMenus(orders, course, menus);
        
        Map<Integer, List<Menu>> map = menus.stream()
            .filter(m -> m.count >= 2)
            .collect(Collectors.groupingBy(m -> m.name.length()));
        
        List<String> answers = new ArrayList<>();
        
        for(Integer key : map.keySet()){
            List<Menu> mapMenus = map.get(key);
            Integer max = mapMenus.stream()
                .map(Menu::getCount)
                .max((c1, c2) -> c1 - c2)
                .orElse(0);
            
            List<String> names = mapMenus.stream()
                .filter(m -> m.count == max)
                .map(Menu::getName)
                .collect(Collectors.toList());
            
            answers.addAll(new ArrayList<>(names));
        }
        
        Collections.sort(answers);
            
        return answers.toArray(new String[0]);
    }
    
    private void createMenus(String[] orders, int[] course, List<Menu> menus){
        for(int i = 0; i < orders.length; i++){
            String order = orders[i];
            int[] selected = new int[order.length()];
            
            for(int c = 0; c < course.length; c++){
                String[] splits = order.split("");
                Arrays.sort(splits);
                
                if(splits.length < course[c]) continue;
                    
                generate("", 0, course[c], splits, selected, menus);
            }
        
        }
    }
    
    private void generate(String str, int idx, int lastIdx, String[] order, int[] selected, List<Menu> menus){
        if(idx == lastIdx) {
            Optional<Menu> menu = menus.stream()
                .filter(m -> m.name.equals(str))
                .findFirst();
            
            if(menu.isPresent()){
                menu.get().addCount();
            } else {
                menus.add(new Menu(str, 1));
            }
            
            return;
        }
        
        int start = 0;
        if(idx > 0){
            start = selected[idx - 1] + 1;
        }
        
        for(int i = start; i < order.length; i++){
            String newMenu = str + order[i];
            
            selected[idx] = i;
            generate(newMenu, idx + 1, lastIdx, order, selected, menus);
            selected[idx] = 0;
        }
        
    }
}