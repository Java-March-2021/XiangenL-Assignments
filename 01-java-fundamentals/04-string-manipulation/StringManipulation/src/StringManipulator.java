
public class StringManipulator {
    public String trimAndConcat(String string1, String string2) {
        return string1.trim().concat(string2.trim());
    }
    
    public Integer getIndexOrNull(String string, char i) {
    	if (string.indexOf(i) == -1) {
    		return null;
    	}
    	return string.indexOf(i);
    }
    
    public Integer getIndexOrNull(String string, String substring) {
    	if (string.indexOf(substring) == -1) {
    		return null;
    	}
    	return string.indexOf(substring);
    }
    
    public String concatSubstring(String string, int indexStarting, int indexEnding, String string2) {
    	String substr = string.substring(indexStarting, indexEnding);
        return substr.concat(string2);
    }
}
