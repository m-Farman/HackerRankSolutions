    static boolean isAnagram(String a, String b) {
        if(a.length()!=b.length())
            return false;
        a=a.toLowerCase();
        b=b.toLowerCase();
        int[] aL=new int[26];
        int[] bL=new int[26];
        for(int i=0;i<a.length();i++){
            aL[a.charAt(i)-97]++;
            bL[b.charAt(i)-97]++;
        }
        for(int i=0;i< aL.length;i++){
            if(aL[i]!=bL[i])
                return false;
        }
        return true;
    }
