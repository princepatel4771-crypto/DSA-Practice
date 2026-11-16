import java.util.*;

class Solution {
    public String simplifyPath(String path) {
        
        // Stack mein folder names rakhenge
        Deque<String> stack = new ArrayDeque<>();
        
        // "/" se split karo, empty parts (jaise "//") skip honge
        for(String part : path.split("/")) {
            
            if(part.isEmpty() || part.equals(".")) {
                continue;                       // kuch nahi karna
            }
            else if(part.equals("..")) {
                if(!stack.isEmpty()) stack.pop(); // ek folder upar
            }
            else {
                stack.push(part);               // naya folder andar
            }
        }
        
        // Stack ko sahi order mein jodo
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = stack.descendingIterator();
        while(it.hasNext()) {
            sb.append('/').append(it.next());
        }
        
        // Agar kuch nahi bacha, to root "/" return karo
        return sb.length() == 0 ? "/" : sb.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println(sol.simplifyPath("/home/"));              // /home
        System.out.println(sol.simplifyPath("/../"));                // /
        System.out.println(sol.simplifyPath("/home//foo/"));         // /home/foo
        System.out.println(sol.simplifyPath("/a/./b/../../c/"));     // /c
    }
}