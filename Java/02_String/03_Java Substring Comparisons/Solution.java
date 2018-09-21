    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
      for(int i=0;i <= s.length()-k;i++){
          String sub=s.substring(i,i+k);
          if(i==0)
           smallest=largest=sub;
          
          smallest=smallest.compareTo(sub)>0?sub:smallest;
          largest=sub.compareTo(largest)>0?sub:largest;
          
      }
        
        
        return smallest + "\n" + largest;
    }
