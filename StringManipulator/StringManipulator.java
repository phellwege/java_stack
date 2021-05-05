public class StringManipulator {
    public String trimAndConcat(String string1, String string2) {
        String string3 = string1.trim() + string2.trim();
        return string3;
    }
    public Integer getIndexOrNull(String str1, char x){
    int a = str1.indexOf(x);
    if(a == -1) {
        return null;
    }
    else {
        return a;
    }
}
    public Integer getIndexOrNull(String str1, String str2){
    int a = str1.indexOf(str2);
    if(a == -1) {
        return null;
    }
    else {
        return a;
    }
}
    public String concatSubstring(String str1, int x, int y, String str2){
        String z = str1.substring(x, y);
        return z+str2;
    }
}
