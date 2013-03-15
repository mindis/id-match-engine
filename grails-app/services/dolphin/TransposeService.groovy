package dolphin

import edu.ualr.oyster.utilities.OysterUtilityTranspose;

class TransposeService {
 
    static OysterUtilityTranspose singleton = new OysterUtilityTranspose();

   /**
     * One string differs from the other string by only one adjacent transposition (John - Jhon)
     * @param s1 source String
     * @param t1 target String
     * @return true if single position transpose, otherwise false
     */
    def boolean compare(String s1, String t1){
       //log.debug("Enter for "+s1+" and "+t1);
       if(s1.equalsIgnoreCase(t1)){return true}; //transposition not needed, just return true
       def result = singleton.differByTranspose(s1,t1);
       log.debug("Exit with  ${result} for "+s1+" and "+t1);
       return result;
    }

    def boolean findMatches(String inputValue, String registryColName, java.util.List users){
      java.util.List results = [];
        OysterUtilityTranspose transpose = new OysterUtilityTranspose();
        users.each() { user ->
           String registryValue = user."${registryColName}"
           if(transpose.differByTranspose(inputValue,registryValue)) results.add(user);
           log.debug("results found in Transpose ${results}");
        return results;
    }
   }
     
    /*
     * currently oyster transpose always defaults to distance of 1 and hence this method is redundant  
     */
    def boolean findMatches(String inputValue, String registryColName, java.util.List users, int distance){
      java.util.List results = [];
        OysterUtilityTranspose transpose = new OysterUtilityTranspose();
        users.each() { user ->
           String registryValue = user."${registryColName}"
           log.debug("comparing ${inputValue} and ${registryValue}");
           if(transpose.differByTranspose(inputValue,registryValue)) results.add(user);
    }
           log.debug("results found in Transpose ${results}");
           return results;
   }
}
