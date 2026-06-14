class Solution {
    public boolean isPalindrome(String s) {
        ArrayList<Character> chars = new ArrayList<>();
        int size = s.length();
        for(int j=0; j<size; j++) {
            if(Character.isLetterOrDigit(s.charAt(j))) {
                chars.add(s.charAt(j));
            }
        }

        int length = chars.size();
        System.out.println(chars);
        for(int i=0; i*2<length-1; i++) {
            if(Character.toUpperCase(chars.get(i))!=Character.toUpperCase(chars.get(length-1-i))) {
                return false;
            }
        }
        return true;
    }
}
