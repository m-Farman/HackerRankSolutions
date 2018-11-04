        //Write your code here
        Arrays.asList(s).subList(0, n).sort((s1, s2) -> {
            return new BigDecimal(s2).compareTo(new BigDecimal(s1));
        });
