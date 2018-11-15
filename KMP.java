//Find a substring with O(n)

class KMP {

    private static void SearchStr(String str, String pattern) {
        int i = 0, j = 0;
        int n = pattern.length();
        int[] lsp = new int[n];

        computeLSPAray(pattern, n, lsp);

        while (i < str.length()) {
            if(str.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
            }

            if(j == n){
                System.out.println("At: " + (i - n));
                j = lsp[j - 1];
            }
            else if(i < str.length() && str.charAt(i) != pattern.charAt(j)){
                if(j == 0){
                    i++;
                }
                else{
                    j = lsp[j - 1];
                    i++;
                }
            }
        }
    }

    private static void computeLSPAray(String str, int n, int[] lsp) {
        int i = 1, len = 0;
        lsp[0] = 0;

        while (i < n) {
            if (str.charAt(i) == str.charAt(len)) {
                len++;
                lsp[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lsp[len - 1];
                } else {// len == 0
                    lsp[i] = 0;
                    i++;
                }
            }
        }
    }

    public static void main(String args[]) {
        String str = "ABSCHKSHABS";
        String pattern = "ABS";
        SearchStr(str, pattern);
    }
}