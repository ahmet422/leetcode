class Solution {
    public boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stacky = new Stack<>();
        Map<Character, Character> mappings = new HashMap<>();
        mappings.put('(', ')');
        mappings.put('{', '}');
        mappings.put('[', ']');
        for (char c : s.toCharArray()) {
            if (mappings.containsKey(c)) {
                stacky.push(mappings.get(c));
            } else if (stacky.isEmpty() || stacky.pop() != c) {
                return false;
            }
        }
        return stacky.isEmpty();
    }
}
